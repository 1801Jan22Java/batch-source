package beans;
import java.io.File;
public class Document 
{
	public Document(int requestId, byte[] doc, int documentId) {
		super();
		this.requestId = requestId;
		this.docs = doc;
		this.documentId = documentId;
	}
	private int requestId;
	private byte[] docs;
	private int documentId;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public byte[] getDoc() {
		return docs;
	}
	public void setDocs(byte[] docs) {
		this.docs = docs;
	}
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String toString()
	{
		return this.requestId+"";
	}
}
