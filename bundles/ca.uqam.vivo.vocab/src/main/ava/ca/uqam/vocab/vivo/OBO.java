/* CVS $Id: $ */
package ca.uqam.vocab.vivo; 
import org.apache.jena.rdf.model.*;
 
/**
 * Vocabulary definitions from /home/heon/01-SPRINT/2021-11-12-SPRINT-08/VivoStudioWS/ca.uqam.vivo.vocab/src/main/resources/vivo.nt 
 * @author Auto-generated by schemagen on 15 déc. 2021 14:55 
 */
public class OBO {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static final Model M_MODEL = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://purl.obolibrary.org/obo/";
    
    /** <p>The namespace of the vocabulary as a string</p>
     * @return namespace as String
     * @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = M_MODEL.createResource( NS );
    
    public static final Resource ARG_0000008 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ARG_0000008" );
    
    public static final Resource ARG_2000008 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ARG_2000008" );
    
    public static final Resource ARG_2000009 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ARG_2000009" );
    
    public static final Resource ARG_2000010 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ARG_2000010" );
    
    public static final Resource ARG_2000011 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ARG_2000011" );
    
    public static final Resource ARG_2000021 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ARG_2000021" );
    
    public static final Resource ARG_2000022 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ARG_2000022" );
    
    public static final Resource ARG_2000376 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ARG_2000376" );
    
    public static final Resource ARG_2000377 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ARG_2000377" );
    
    public static final Resource ARG_2000379 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ARG_2000379" );
    
    public static final Resource BCO_0000003 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BCO_0000003" );
    
    public static final Resource BCO_0000042 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BCO_0000042" );
    
    public static final Resource BFO_0000001 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000001" );
    
    public static final Resource BFO_0000002 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000002" );
    
    public static final Resource BFO_0000003 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000003" );
    
    public static final Resource BFO_0000004 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000004" );
    
    public static final Resource BFO_0000006 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000006" );
    
    public static final Resource BFO_0000008 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000008" );
    
    public static final Resource BFO_0000015 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000015" );
    
    public static final Resource BFO_0000016 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000016" );
    
    public static final Resource BFO_0000017 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000017" );
    
    public static final Resource BFO_0000019 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000019" );
    
    public static final Resource BFO_0000020 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000020" );
    
    public static final Resource BFO_0000023 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000023" );
    
    public static final Resource BFO_0000029 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000029" );
    
    public static final Resource BFO_0000031 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000031" );
    
    public static final Resource BFO_0000034 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000034" );
    
    public static final Resource BFO_0000038 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000038" );
    
    public static final Resource BFO_0000040 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000040" );
    
    public static final Resource BFO_0000141 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000141" );
    
    public static final Resource BFO_0000148 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/BFO_0000148" );
    
    /** <p>See OBI listserv discussion for considerations in defining instrument. http://sourceforge.net/tracker/index.php?func=detail&amp;aid=2894801&amp;group_id=177891&amp;atid=886178</p> */
    public static final Resource ERO_0000004 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000004" );
    
    /** <p>Coordinate with NIF. NIF ID: nlx_res_20090105</p> */
    public static final Resource ERO_0000005 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000005" );
    
    /** <p>Placeholder for class to be imported from the Reagent Ontology (ReO).</p> */
    public static final Resource ERO_0000006 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000006" );
    
    /** <p>Protocol is added to eagle-i temporarily until a relationship between the 
     *  informatio entity "protocol" and these planned processes is created. This 
     *  class refers to the axtual process not the document</p>
     */
    public static final Resource ERO_0000007 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000007" );
    
    public static final Resource ERO_0000012 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000012" );
    
    /** <p>Maybe SameAs "Investigation" but is the subject of funding</p> */
    public static final Resource ERO_0000014 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000014" );
    
    /** <p>This should be imported from OCRE- but they currently have no generic human 
     *  study type. Def is modified.</p>
     */
    public static final Resource ERO_0000015 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000015" );
    
    public static final Resource ERO_0000016 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000016" );
    
    /** <p>Should have relationship to Organism</p> */
    public static final Resource ERO_0000020 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000020" );
    
    /** <p>IAO is a planned specification, in SWO is an Information artifact. In eagle-i, 
     *  we have a need to collect material instances and is it thus currently classified 
     *  as a material entity.</p>
     */
    public static final Resource ERO_0000071 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000071" );
    
    public static final Resource ERO_0000224 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000224" );
    
    public static final Resource ERO_0000225 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000225" );
    
    /** <p>Coordinate with NIF</p> */
    public static final Resource ERO_0000391 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000391" );
    
    /** <p>coordinate with NIF. NIF ID:nlx_res_20090419</p> */
    public static final Resource ERO_0000392 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000392" );
    
    /** <p>Coordinate with NIF. NIF ID: nlx_res_20090444</p> */
    public static final Resource ERO_0000393 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000393" );
    
    /** <p>Coordinate with NIF: NIF ID: nlx_res_20090416</p> */
    public static final Resource ERO_0000394 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000394" );
    
    /** <p>Coordinate with NIF: NIF ID: nlx_res_20090420</p> */
    public static final Resource ERO_0000395 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000395" );
    
    /** <p>Coordinate with NIF. NIF ID: nlx_res_20090418</p> */
    public static final Resource ERO_0000396 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000396" );
    
    public static final Resource ERO_0000565 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000565" );
    
    public static final Resource ERO_0000595 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000595" );
    
    public static final Resource ERO_0000776 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000776" );
    
    public static final Resource ERO_0000777 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000777" );
    
    public static final Resource ERO_0000778 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000778" );
    
    public static final Resource ERO_0000779 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000779" );
    
    public static final Resource ERO_0000780 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000780" );
    
    public static final Resource ERO_0000783 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000783" );
    
    public static final Resource ERO_0000784 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000784" );
    
    public static final Resource ERO_0000785 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000785" );
    
    public static final Resource ERO_0000786 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000786" );
    
    public static final Resource ERO_0000787 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000787" );
    
    public static final Resource ERO_0000788 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000788" );
    
    public static final Resource ERO_0000789 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000789" );
    
    public static final Resource ERO_0000790 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000790" );
    
    public static final Resource ERO_0000914 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0000914" );
    
    public static final Resource ERO_0001245 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001245" );
    
    public static final Resource ERO_0001254 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001254" );
    
    public static final Resource ERO_0001255 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001255" );
    
    public static final Resource ERO_0001256 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001256" );
    
    public static final Resource ERO_0001257 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001257" );
    
    public static final Resource ERO_0001258 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001258" );
    
    public static final Resource ERO_0001259 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001259" );
    
    public static final Resource ERO_0001260 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001260" );
    
    public static final Resource ERO_0001261 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001261" );
    
    public static final Resource ERO_0001262 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001262" );
    
    public static final Resource ERO_0001263 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001263" );
    
    /** <p>Just a place horder. It will probably be replaced by NIF term: http://ontology.neuinfo.org/NIF/DigitalEntities/NIF-Resource.owl#nlx_res_20090405</p> */
    public static final Resource ERO_0001716 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/ERO_0001716" );
    
    public static final Resource IAO_0000003 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000003" );
    
    public static final Resource IAO_0000005 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000005" );
    
    public static final Resource IAO_0000007 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000007" );
    
    public static final Resource IAO_0000009 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000009" );
    
    public static final Resource IAO_0000013 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000013" );
    
    public static final Resource IAO_0000027 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000027" );
    
    public static final Resource IAO_0000030 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000030" );
    
    public static final Resource IAO_0000032 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000032" );
    
    public static final Resource IAO_0000033 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000033" );
    
    public static final Resource IAO_0000102 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000102" );
    
    public static final Resource IAO_0000104 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000104" );
    
    public static final Resource IAO_0000109 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000109" );
    
    public static final Resource IAO_0000144 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000144" );
    
    public static final Resource IAO_0000300 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/IAO_0000300" );
    
    public static final Resource OBI_0000011 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/OBI_0000011" );
    
    public static final Resource OBI_0000017 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/OBI_0000017" );
    
    public static final Resource OBI_0000066 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/OBI_0000066" );
    
    public static final Resource OBI_0000086 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/OBI_0000086" );
    
    public static final Resource OBI_0000094 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/OBI_0000094" );
    
    public static final Resource OBI_0000272 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/OBI_0000272" );
    
    public static final Resource OBI_0000571 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/OBI_0000571" );
    
    public static final Resource OBI_0000835 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/OBI_0000835" );
    
    public static final Resource OBI_0001554 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/OBI_0001554" );
    
    public static final Resource OBI_0100026 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/OBI_0100026" );
    
    public static final Resource OBI_0500000 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/OBI_0500000" );
    
    public static final Resource UO_0000280 = M_MODEL.createResource( "http://purl.obolibrary.org/obo/UO_0000280" );
    
}
