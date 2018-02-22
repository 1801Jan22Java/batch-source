package beans;
import java.io.File;
public class Document 
{
	public Document(int requestId, byte[] doc, int documentId) {
		super();
		this.requestId = requestId;
		this.doc = doc;
		this.documentId = documentId;
	}
	private int requestId;
	private byte[] doc;
	private int documentId;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public byte[] getDoc() {
		return doc;
	}
	public void setDocs(byte[] docs) {
		this.doc = docs;
	}
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String toString()
	{
		return this.requestId+""+this.doc;
	}
}
