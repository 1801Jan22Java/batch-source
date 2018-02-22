package com.revature.test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.revature.beans.Upload;
import com.revature.dao.UploadDao;
import com.revature.dao.UploadDaoImpl;
public class UploadDaoImplTest {
	@Test
	public static void testUploadDaoImpl() {
		UploadDao ud = new UploadDaoImpl();
		List<Upload> uploads = ud.getUploads();
		assertNotNull(uploads);
		
		assertNull(ud.getUploadById(0));
		assertNotNull(ud.getUploadById(1211));
		assertNull(ud.addUpload("Koala.jpg", 0));
		assertTrue(ud.updateUpload(ud.getUploadById(1026).getId(), "Koala.jpg", "Filename"));
		assertFalse(ud.deleteUpload(ud.getUploadById(1211).getId()));
	}
}