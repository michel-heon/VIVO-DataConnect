package ca.uqam.vivodataconnect.images.etl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.iterable.S3Objects;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import ca.uqam.tool.vivoproxy.swagger.client.api.IndividualApi;
import ca.uqam.tool.vivoproxy.swagger.client.api.PersonApi;
import ca.uqam.tool.vivoproxy.swagger.client.handler.ApiClient;
import ca.uqam.tool.vivoproxy.swagger.client.handler.ApiException;
import ca.uqam.tool.vivoproxy.swagger.client.model.Image;
import ca.uqam.vivodataconnect.util.DataConnectHelper;

public class ETL_images {

	public static void main(String[] args) throws ApiException {
		ETL_images etl = new ETL_images();
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(DataConnectHelper.getVivoProxyUrl());
		IndividualApi indv = new IndividualApi(apiClient);
		S3Objects.inBucket(s3, DataConnectHelper.getBucketImages()).forEach((S3ObjectSummary objectSummary) -> {
			String imgName = objectSummary.getKey();
			String id = imgName.replace(".jpg", "");
			String bucket = objectSummary.getBucketName();
			System.err.println(objectSummary.toString());
			try {
				Image image = new Image();
				image.setIndividualIRI("http://purl.org/vivo.uqam.ca/data/people#"+id);
				image.setImageURL("https://photos-uqam.s3.ca-central-1.amazonaws.com/"+imgName);
				image.setOrigX(0);
				image.setOrigY(0);
				image.setHeight(270);
				image.setWidth(270);
				indv.indvAddImage(image);
			} catch (ApiException e) {
				e.printStackTrace();
			}
		});
        System.out.println("Done");
	}
}
