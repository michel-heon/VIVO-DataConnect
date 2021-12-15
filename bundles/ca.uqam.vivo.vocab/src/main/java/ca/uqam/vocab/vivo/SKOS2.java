/* CVS $Id: $ */
package ca.uqam.vocab.vivo; 
import org.apache.jena.rdf.model.*;
 
/**
 * Vocabulary definitions from /home/heon/01-SPRINT/2021-11-12-SPRINT-08/VivoStudioWS/ca.uqam.vivo.vocab/src/main/resources/vivo.nt 
 * @author Auto-generated by schemagen on 15 déc. 2021 15:19 
 */
public class SKOS2 {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static final Model M_MODEL = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://www.w3.org/2008/05/skos#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     * @return namespace as String
     * @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = M_MODEL.createResource( NS );
    
}
