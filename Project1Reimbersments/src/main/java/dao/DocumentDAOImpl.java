package dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Document;
import beans.Employee;
import util.ConnectionUtil;
//QED
public class DocumentDAOImpl implements DocumentDAO
{
	private static String filename = "Properties";
	//QED
	@Override
	public ArrayList<Document> getDocuments() 
	{
		ArrayList<Document> docs = new ArrayList<Document>();
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "SELECT * FROM DOCUMENT";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(stmt);
			
			while (rs.next())
			{
				int docId = rs.getInt("DOCUMENT_ID");
				int reqId = rs.getInt("REQUEST_ID");
				Blob pic = rs.getBlob("DOC");
				InputStream in = pic.getBinaryStream();
				ByteArrayOutputStream bao = new ByteArrayOutputStream();
				int i = 0;
				while((i=in.read())!=-1)
				{
					bao.write(i);
				}
				Document d = new Document(reqId, bao.toByteArray(), docId);
				docs.add(d);
			}	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return docs;
	}

	//QED
	@Override
	public ArrayList<Document> getDocuments(int requestId) {
		ArrayList<Document> results = new ArrayList<Document>();
		for(Document d: this.getDocuments())
		{
			if(d.getRequestId()==requestId)
			{
				results.add(d);
			}
		}
		return results;
	}
	//QED
	@Override
	public boolean uploadDocument(int rid, byte[] pic) {
		/*PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "INSERT INTO DOCUMENTS(REQUEST_ID,DOC) VALUES(?,?)";
			pstmt = con.prepareStatement(sql);
			FileInputStream in = new FileInputStream(pic);
			// the cast to int is necessary because with JDBC 4 there is 
			// also a version of this method with a (int, long) 
			// but that is not implemented by Oracle
			pstmt.setBinaryStream(2, in, (int)pic.length()); 
			pstmt.setInt(1, rid);  // set the PK value
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return false;
		*/
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "INSERT INTO DOCUMENTS(REQUEST_ID,DOC) VALUES(?,?)";
			pstmt = con.prepareStatement(sql);
			Blob blob = con.createBlob();
			OutputStream os = blob.setBinaryStream(1);
			os.write(pic);
			pstmt.setBlob(2, blob); 
			pstmt.setInt(1, rid);  // set the PK value
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return false;
	}
	//QED
	@Override
	public ArrayList<Blob> downloadDocuments(int rid) {
		ArrayList<Blob> docs = new ArrayList<Blob>();
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			
			Blob pic = null;
			String sql = "SELECT * FROM DOCUMENTS WHERE REQUEST_ID = ?";
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				pic = rs.getBlob("DOC");
				System.out.println("here");
				docs.add(pic);
			}	
			return docs;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return docs;
	}
	//QED
	@Override	
	public boolean removeDocuments(int rid) {
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "DELETE FROM DOCUMENTS WHERE REQUEST_ID = ?";
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rid);
			return pstmt.execute();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e2) 
		{
			e2.printStackTrace();
		}
		return false;
	}
	//QED
	@Override
	public boolean updateDocument(int id, byte[] pic) {
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "UPDATE DOC = ? FROM DOCUMENTS WHERE REQUEST_ID = ?";
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			Blob blob = con.createBlob();
			OutputStream os = blob.setBinaryStream(1);
			os.write(pic);
			pstmt.setBlob(2, blob);
			return pstmt.execute();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e2) 
		{
			e2.printStackTrace();
		}
		return false;
	}

}
