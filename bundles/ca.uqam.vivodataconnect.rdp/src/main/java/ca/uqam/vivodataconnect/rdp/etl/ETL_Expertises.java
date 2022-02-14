package ca.uqam.vivodataconnect.rdp.etl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.github.jsonldjava.utils.JsonUtils;

import ca.uqam.tool.vivoproxy.swagger.client.api.ConceptApi;
import ca.uqam.tool.vivoproxy.swagger.client.handler.ApiClient;
import ca.uqam.tool.vivoproxy.swagger.client.handler.ApiException;
import ca.uqam.tool.vivoproxy.swagger.client.model.Concept;
import ca.uqam.tool.vivoproxy.swagger.client.model.LinguisticLabel;
import ca.uqam.vivodataconnect.util.DataConnectHelper;

public class ETL_Expertises {
    private AmazonS3 s3Client;
    private S3Object object;
    private S3ObjectInputStream objectData;
    private String expertiseModel = null;
    private ResultSet resultSet;


    public static void main(String[] args) throws IOException, ApiException {
        Configurator.setLevel("com.amazonaws", Level.WARN);
        ETL_Expertises etl = new ETL_Expertises();
        /*
         * Extraction de S3
         */
        etl.extract();
        etl.transformToOnto();
        etl.loadToVivo();
    }

    private void loadToVivo() throws ApiException {
        ConceptApi conceptApi = getProxyApi();
        while (resultSet.hasNext()) {
            QuerySolution qsol = resultSet.nextSolution();
            Iterator<String> varNames = qsol.varNames();
            Map<String, Object> jsonMap = new HashMap<String, Object>();
            while (varNames.hasNext()) {
                String varName = varNames.next();
                String value = qsol.get(varName).toString();
                String value_en = translate(value);
                Concept expertise = new Concept();
                LinguisticLabel labelItem = new LinguisticLabel();
                labelItem.setLanguage(Locale.CANADA_FRENCH.toLanguageTag());
                labelItem.setLabel(value);
                LinguisticLabel labelItem_en = new LinguisticLabel();
                labelItem_en.setLanguage(Locale.US.toLanguageTag());
                labelItem_en.setLabel(value_en);
                expertise.addLabelsItem(labelItem_en);
                expertise.addLabelsItem(labelItem);
                String expertUrl = "http://purl.org/uqam.ca/vocabulary/expertise#"+WordUtils.uncapitalize(StringUtils.stripAccents(value).replace(" ", "_").replace("-", "_"), '_');
                expertise.setIRI(expertUrl);
                conceptApi.createConcept(expertise);
                System.out.println(expertise);
            }
        }
    }

    private  ConceptApi getProxyApi() {
            ApiClient apiClient = new ApiClient();
            apiClient.setBasePath(DataConnectHelper.getVivoProxyUrl());
            ConceptApi api = new ConceptApi(apiClient);
            return api;
    }

    private String translate(String value) {
        AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();

        AmazonTranslate translate = AmazonTranslateClient.builder()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds.getCredentials()))
                .withRegion("ca-central-1")
                .build();
        TranslateTextRequest request = new TranslateTextRequest()
                .withText(value)
                .withSourceLanguageCode("fr")
                .withTargetLanguageCode("en");
        TranslateTextResult result  = translate.translateText(request);
        return result.getTranslatedText();
        }

    private void transformToOnto() throws JsonGenerationException, IOException {

        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        model.read((InputStream)objectData, "http://uqam.ca/data_src/expertises_rdp", Lang.NT.getLabel());

        Query query = QueryFactory.create(""
                + "SELECT ?label WHERE {"
                + "    ?s <http://uqam.ca/data_src/expertises_rdp#Titre> ?label ."
                + "} limit 10");
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);   
        resultSet = queryExecution.execSelect();
        //        resultSetToJson(resultSet);

        //        RDFDataMgr.write(System.out, model, Lang.TURTLE) ;
        //       System.out.println("Done");
    }

    private void resultSetToJson(ResultSet resultSet) throws JsonGenerationException, IOException {
        List<Map> jsonList = new Vector<Map>();
        while (resultSet.hasNext()) {
            QuerySolution qsol = resultSet.nextSolution();
            Iterator<String> varNames = qsol.varNames();
            Map<String, Object> jsonMap = new HashMap<String, Object>();
            while (varNames.hasNext()) {
                String varName = varNames.next();
                jsonMap.put(varName, qsol.get(varName).toString());
            }
            jsonList.add(jsonMap);
        }
        System.out.println(JsonUtils.toPrettyString(jsonList));        
    }

    private void extract() throws IOException {
        s3Client = AmazonS3ClientBuilder.standard().build();
        object = s3Client.getObject(new GetObjectRequest(DataConnectHelper.getBucketRDP(), DataConnectHelper.getRdpExpertises()));
        objectData = object.getObjectContent();
        //        expertiseModel = IOUtils.toString(objectData, StandardCharsets.UTF_8);
        //        System.out.println(result);        
    }

}
