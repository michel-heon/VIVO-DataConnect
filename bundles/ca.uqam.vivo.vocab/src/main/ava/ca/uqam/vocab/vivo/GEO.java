/* CVS $Id: $ */
package ca.uqam.vocab.vivo; 
import org.apache.jena.rdf.model.*;
 
/**
 * Vocabulary definitions from /home/heon/01-SPRINT/2021-11-12-SPRINT-08/VivoStudioWS/ca.uqam.vivo.vocab/src/main/resources/vivo.nt 
 * @author Auto-generated by schemagen on 15 déc. 2021 14:57 
 */
public class GEO {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static final Model M_MODEL = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://aims.fao.org/aos/geopolitical.owl#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     * @return namespace as String
     * @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = M_MODEL.createResource( NS );
    
    public static final Resource area = M_MODEL.createResource( "http://aims.fao.org/aos/geopolitical.owl#area" );
    
    public static final Resource disputed = M_MODEL.createResource( "http://aims.fao.org/aos/geopolitical.owl#disputed" );
    
    public static final Resource economic_region = M_MODEL.createResource( "http://aims.fao.org/aos/geopolitical.owl#economic_region" );
    
    public static final Resource geographical_region = M_MODEL.createResource( "http://aims.fao.org/aos/geopolitical.owl#geographical_region" );
    
    public static final Resource group = M_MODEL.createResource( "http://aims.fao.org/aos/geopolitical.owl#group" );
    
    public static final Resource non_self_governing = M_MODEL.createResource( "http://aims.fao.org/aos/geopolitical.owl#non_self_governing" );
    
    public static final Resource organization = M_MODEL.createResource( "http://aims.fao.org/aos/geopolitical.owl#organization" );
    
    public static final Resource other = M_MODEL.createResource( "http://aims.fao.org/aos/geopolitical.owl#other" );
    
    public static final Resource self_governing = M_MODEL.createResource( "http://aims.fao.org/aos/geopolitical.owl#self_governing" );
    
    public static final Resource special_group = M_MODEL.createResource( "http://aims.fao.org/aos/geopolitical.owl#special_group" );
    
    public static final Resource territory = M_MODEL.createResource( "http://aims.fao.org/aos/geopolitical.owl#territory" );
    
}
