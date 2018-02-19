package DAOTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.DocumentDAOImpl;

public class DocumentDAOImplTest {
	private DocumentDAOImpl docDao = new DocumentDAOImpl();
	@Test
	public final void getDocuments()
	{
		assertNotNull("wat", docDao.getDocuments());
	}
	@Test
	public final void getDocumentsById()
	{
		
		assertNotNull("wat", docDao.getDocuments(1001));
	}
	@Test
	public final void downloadDocumentsById()
	{
		assertEquals((docDao.downloadDocuments(1001).size()), 2);
	}
	@Test
	public final void uploadDocumentsById()
	{
		assertTrue("wat",docDao.uploadDocument(1001, null));
	}
	@Test
	public final void removeDocumentsById()
	{
		assertNotNull("wat", docDao.removeDocuments(1001));
	}
}
