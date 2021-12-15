/* CVS $Id: $ */
package ca.uqam.vocab.vivo; 
import org.apache.jena.rdf.model.*;
 
/**
 * Vocabulary definitions from /home/heon/01-SPRINT/2021-11-12-SPRINT-08/VivoStudioWS/ca.uqam.vivo.vocab/src/main/resources/vivo.nt 
 * @author Auto-generated by schemagen on 15 déc. 2021 14:56 
 */
public class BIBO {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static final Model M_MODEL = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://purl.org/ontology/bibo/";
    
    /** <p>The namespace of the vocabulary as a string</p>
     * @return namespace as String
     * @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = M_MODEL.createResource( NS );
    
    /** <p>A scholarly academic article, typically published in a journal.</p> */
    public static final Resource AcademicArticle = M_MODEL.createResource( "http://purl.org/ontology/bibo/AcademicArticle" );
    
    /** <p>A written composition in prose, usually nonfiction, on a specific topic, forming 
     *  an independent part of a book or other publication, as a newspaper or magazine.</p>
     */
    public static final Resource Article = M_MODEL.createResource( "http://purl.org/ontology/bibo/Article" );
    
    /** <p>An audio document; aka record.</p> */
    public static final Resource AudioDocument = M_MODEL.createResource( "http://purl.org/ontology/bibo/AudioDocument" );
    
    /** <p>An audio-visual document; film, video, and so forth.</p> */
    public static final Resource AudioVisualDocument = M_MODEL.createResource( "http://purl.org/ontology/bibo/AudioVisualDocument" );
    
    /** <p>Draft legislation presented for discussion to a legal body.</p> */
    public static final Resource Bill = M_MODEL.createResource( "http://purl.org/ontology/bibo/Bill" );
    
    /** <p>A written or printed work of fiction or nonfiction, usually on sheets of paper 
     *  fastened or bound together within covers.</p>
     */
    public static final Resource Book = M_MODEL.createResource( "http://purl.org/ontology/bibo/Book" );
    
    /** <p>A section of a book.</p> */
    public static final Resource BookSection = M_MODEL.createResource( "http://purl.org/ontology/bibo/BookSection" );
    
    /** <p>A written argument submitted to a court.</p> */
    public static final Resource Brief = M_MODEL.createResource( "http://purl.org/ontology/bibo/Brief" );
    
    /** <p>A chapter of a book.</p> */
    public static final Resource Chapter = M_MODEL.createResource( "http://purl.org/ontology/bibo/Chapter" );
    
    /** <p>A collection of statutes.</p> */
    public static final Resource Code = M_MODEL.createResource( "http://purl.org/ontology/bibo/Code" );
    
    /** <p>A document that simultaneously contains other documents.</p> */
    public static final Resource CollectedDocument = M_MODEL.createResource( "http://purl.org/ontology/bibo/CollectedDocument" );
    
    /** <p>A collection of Documents or Collections</p> */
    public static final Resource Collection = M_MODEL.createResource( "http://purl.org/ontology/bibo/Collection" );
    
    /** <p>A meeting for consultation or discussion.</p> */
    public static final Resource Conference = M_MODEL.createResource( "http://purl.org/ontology/bibo/Conference" );
    
    /** <p>A collection of legal cases.</p> */
    public static final Resource CourtReporter = M_MODEL.createResource( "http://purl.org/ontology/bibo/CourtReporter" );
    
    /** <p>A document (noun) is a bounded physical representation of body of information 
     *  designed with the capacity (and usually intent) to communicate. A document 
     *  may manifest symbolic, diagrammatic or sensory-representational information.</p>
     */
    public static final Resource Document = M_MODEL.createResource( "http://purl.org/ontology/bibo/Document" );
    
    /** <p>a distinct part of a larger document or collected document.</p> */
    public static final Resource DocumentPart = M_MODEL.createResource( "http://purl.org/ontology/bibo/DocumentPart" );
    
    /** <p>The status of the publication of a document.</p> */
    public static final Resource DocumentStatus = M_MODEL.createResource( "http://purl.org/ontology/bibo/DocumentStatus" );
    
    /** <p>An edited book.</p> */
    public static final Resource EditedBook = M_MODEL.createResource( "http://purl.org/ontology/bibo/EditedBook" );
    
    /** <p>A passage selected from a larger work.</p> */
    public static final Resource Excerpt = M_MODEL.createResource( "http://purl.org/ontology/bibo/Excerpt" );
    
    /** <p>aka movie.</p> */
    public static final Resource Film = M_MODEL.createResource( "http://purl.org/ontology/bibo/Film" );
    
    /** <p>An instance or a session in which testimony and arguments are presented, esp. 
     *  before an official, as a judge in a lawsuit.</p>
     */
    public static final Resource Hearing = M_MODEL.createResource( "http://purl.org/ontology/bibo/Hearing" );
    
    /** <p>A document that presents visual or diagrammatic information.</p> */
    public static final Resource Image = M_MODEL.createResource( "http://purl.org/ontology/bibo/Image" );
    
    /** <p>A formalized discussion between two or more people.</p> */
    public static final Resource Interview = M_MODEL.createResource( "http://purl.org/ontology/bibo/Interview" );
    
    /** <p>something that is printed or published and distributed, esp. a given number 
     *  of a periodical</p>
     */
    public static final Resource Issue = M_MODEL.createResource( "http://purl.org/ontology/bibo/Issue" );
    
    /** <p>A periodical of scholarly journal Articles.</p> */
    public static final Resource Journal = M_MODEL.createResource( "http://purl.org/ontology/bibo/Journal" );
    
    /** <p>A document accompanying a legal case.</p> */
    public static final Resource LegalCaseDocument = M_MODEL.createResource( "http://purl.org/ontology/bibo/LegalCaseDocument" );
    
    /** <p>A document containing an authoritative determination (as a decree or judgment) 
     *  made after consideration of facts or law.</p>
     */
    public static final Resource LegalDecision = M_MODEL.createResource( "http://purl.org/ontology/bibo/LegalDecision" );
    
    /** <p>A legal document; for example, a court decision, a brief, and so forth.</p> */
    public static final Resource LegalDocument = M_MODEL.createResource( "http://purl.org/ontology/bibo/LegalDocument" );
    
    /** <p>A legal document proposing or enacting a law or a group of laws.</p> */
    public static final Resource Legislation = M_MODEL.createResource( "http://purl.org/ontology/bibo/Legislation" );
    
    public static final Resource Letter = M_MODEL.createResource( "http://purl.org/ontology/bibo/Letter" );
    
    /** <p>A periodical of magazine Articles. A magazine is a publication that is issued 
     *  periodically, usually bound in a paper cover, and typically contains essays, 
     *  stories, poems, etc., by many writers, and often photographs and drawings, 
     *  frequently specializing in a particular subject or area, as hobbies, news, 
     *  or sports.</p>
     */
    public static final Resource Magazine = M_MODEL.createResource( "http://purl.org/ontology/bibo/Magazine" );
    
    /** <p>A small reference book, especially one giving instructions.</p> */
    public static final Resource Manual = M_MODEL.createResource( "http://purl.org/ontology/bibo/Manual" );
    
    /** <p>An unpublished Document, which may also be submitted to a publisher for publication.</p> */
    public static final Resource Manuscript = M_MODEL.createResource( "http://purl.org/ontology/bibo/Manuscript" );
    
    /** <p>A graphical depiction of geographic features.</p> */
    public static final Resource Map = M_MODEL.createResource( "http://purl.org/ontology/bibo/Map" );
    
    /** <p>A periodical of documents, usually issued daily or weekly, containing current 
     *  news, editorials, feature articles, and usually advertising.</p>
     */
    public static final Resource Newspaper = M_MODEL.createResource( "http://purl.org/ontology/bibo/Newspaper" );
    
    /** <p>Notes or annotations about a resource.</p> */
    public static final Resource Note = M_MODEL.createResource( "http://purl.org/ontology/bibo/Note" );
    
    /** <p>A document describing the exclusive right granted by a government to an inventor 
     *  to manufacture, use, or sell an invention for a certain number of years.</p>
     */
    public static final Resource Patent = M_MODEL.createResource( "http://purl.org/ontology/bibo/Patent" );
    
    /** <p>A public performance.</p> */
    public static final Resource Performance = M_MODEL.createResource( "http://purl.org/ontology/bibo/Performance" );
    
    /** <p>A group of related documents issued at regular intervals.</p> */
    public static final Resource Periodical = M_MODEL.createResource( "http://purl.org/ontology/bibo/Periodical" );
    
    public static final Resource PersonalCommunicationDocument = M_MODEL.createResource( "http://purl.org/ontology/bibo/PersonalCommunicationDocument" );
    
    /** <p>A compilation of documents published from an event, such as a conference.</p> */
    public static final Resource Proceedings = M_MODEL.createResource( "http://purl.org/ontology/bibo/Proceedings" );
    
    /** <p>An excerpted collection of words.</p> */
    public static final Resource Quote = M_MODEL.createResource( "http://purl.org/ontology/bibo/Quote" );
    
    /** <p>A document that presents authoritative reference information, such as a dictionary 
     *  or encylopedia .</p>
     */
    public static final Resource ReferenceSource = M_MODEL.createResource( "http://purl.org/ontology/bibo/ReferenceSource" );
    
    /** <p>A document describing an account or statement describing in detail an event, 
     *  situation, or the like, usually as the result of observation, inquiry, etc..</p>
     */
    public static final Resource Report = M_MODEL.createResource( "http://purl.org/ontology/bibo/Report" );
    
    /** <p>A loose, thematic, collection of Documents, often Books.</p> */
    public static final Resource Series = M_MODEL.createResource( "http://purl.org/ontology/bibo/Series" );
    
    /** <p>A slide in a slideshow</p> */
    public static final Resource Slide = M_MODEL.createResource( "http://purl.org/ontology/bibo/Slide" );
    
    /** <p>A presentation of a series of slides, usually presented in front of an audience 
     *  with written text and images.</p>
     */
    public static final Resource Slideshow = M_MODEL.createResource( "http://purl.org/ontology/bibo/Slideshow" );
    
    /** <p>A document describing a standard</p> */
    public static final Resource Standard = M_MODEL.createResource( "http://purl.org/ontology/bibo/Standard" );
    
    /** <p>A bill enacted into law.</p> */
    public static final Resource Statute = M_MODEL.createResource( "http://purl.org/ontology/bibo/Statute" );
    
    /** <p>A document created to summarize research findings associated with the completion 
     *  of an academic degree.</p>
     */
    public static final Resource Thesis = M_MODEL.createResource( "http://purl.org/ontology/bibo/Thesis" );
    
    /** <p>The academic degree of a Thesis</p> */
    public static final Resource ThesisDegree = M_MODEL.createResource( "http://purl.org/ontology/bibo/ThesisDegree" );
    
    /** <p>A web page is an online document available (at least initially) on the world 
     *  wide web. A web page is written first and foremost to appear on the web, as 
     *  distinct from other online resources such as books, manuscripts or audio documents 
     *  which use the web primarily as a distribution mechanism alongside other more 
     *  traditional methods such as print.</p>
     */
    public static final Resource Webpage = M_MODEL.createResource( "http://purl.org/ontology/bibo/Webpage" );
    
    /** <p>A group of Webpages accessible on the Web.</p> */
    public static final Resource Website = M_MODEL.createResource( "http://purl.org/ontology/bibo/Website" );
    
    /** <p>A seminar, discussion group, or the like, that emphasizes zxchange of ideas 
     *  and the demonstration and application of techniques, skills, etc.</p>
     */
    public static final Resource Workshop = M_MODEL.createResource( "http://purl.org/ontology/bibo/Workshop" );
    
}
