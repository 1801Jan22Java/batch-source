package com.revature.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.revature.beans.Upload;
import com.revature.dao.UploadDao;
import com.revature.dao.UploadDaoImpl;
public class UploadDaoImplTest {
	@Test
	public void testUploadDaoImpl() {
		UploadDao ud = new UploadDaoImpl();
		List<Upload> uploads = ud.getUploads();
		assertNotNull(uploads);
		
		assertNull(ud.getUploadById(0));
	}
}