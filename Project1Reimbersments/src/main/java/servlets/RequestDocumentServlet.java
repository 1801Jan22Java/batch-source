package servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.ServerManager;

/**
 * Servlet implementation class RequestDocumentServlet
 */
public class RequestDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException  
    {  
    	request.getRequestDispatcher("views/Request.html").include(request,response);
    /*response.setContentType("image/jpeg");  
    ServletOutputStream out;  
    out = response.getOutputStream();  
    FileInputStream fin = new FileInputStream("C:\\Users\\panda\\Documents\\GitRepos\\1801-jan22-java\\batch-source\\Project1Reimbersments\\src\\main\\resources\\pics\\tempRequest.jpg");  
      
    BufferedInputStream bin = new BufferedInputStream(fin);  
    BufferedOutputStream bout = new BufferedOutputStream(out);  
    int ch =0; ;  
    while((ch=bin.read())!=-1)  
    {  
    	bout.write(ch);  
    }  
      
    	bin.close();  
    	fin.close();  
    	bout.close();  
    	out.close();  */
    }  
	 public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	 {
		 ServerManager serverManager = new ServerManager();   
		 ServletInputStream in = request.getInputStream();
		 ByteArrayOutputStream bao = new ByteArrayOutputStream();
		 System.out.println(in.available());
		 if(in.available()!=-1)
		 {
			 int i = 0;
			 int count = 0;
			 while((i=in.read())!=-1)
			 {
				 bao.write(i);
				 count+=1;
			 }
			 System.out.println(count);
			 byte[] byteArr = bao.toByteArray();
			 int requestId = Integer.parseInt(request.getParameter("requestId"));
			 serverManager.docDao.uploadDocument(serverManager.currentEmployee.getEmployeeId(), byteArr);
		 }
		 
	 }
}
