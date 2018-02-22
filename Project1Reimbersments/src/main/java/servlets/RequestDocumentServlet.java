package servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;

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
    	 String url = request.getQueryString();
    	 System.out.println(url);
    	 HttpSession session = request.getSession();
    	 session.setAttribute("requestId", url.substring(url.length()-4));
    	request.getRequestDispatcher("views/Request.html?requestId=" +url).include(request,response);
    	
    /*response.setContentType("image/jpeg");  
    ServletOutputStream out;  
    out = response.getOutputStream();  
    FileInputStream fin = new FileInputStream("C:\\Users\\panda\\Documents\\GitRepos\\1801-jan22-java\\batch-source\\Project1Reimbersments\\src\\main\\resources\\pics\\tempRequest.jpg");  
      
    BufferedInputStream bin = new BufferedInputStream(fin);  
    BufferedOutputStream bout = new BufferedOutputStream(ou.include(request,response);t);  
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
		 HttpSession session = request.getSession();
		 System.out.println(session);
		 ServerManager serverManager = new ServerManager();
		 System.out.println(serverManager.login((String)session.getAttribute("username"), (String)session.getAttribute("password")));   
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
			 //System.out.println(count);
			 byte[] byteArr = bao.toByteArray();
			 String url = request.getQueryString();
			 //String result = java.net.URLDecoder.decode(url, "UTF-8");
			 URLDecoder dec = new URLDecoder();
			 //String url2 = dec.decode(url,"UTF-8");
			 System.out.println(url);
			 //String requestId = result.substring(result.length()-5);
			 StringBuffer requestId2 = request.getRequestURL();
			 //System.out.println(dec.decode((requestId2.toString()), "UTF-8"));
			  System.out.println(requestId2);
			  String rId= (String)session.getAttribute("requestId");
			  System.out.println(rId);
			 //System.out.println(request.getParameterNames().nextElement());
			 int requestId = Integer.parseInt(rId);
			 
			 
			 serverManager.docDao.uploadDocument(requestId, byteArr);
			 request.getRequestDispatcher("EmployeeProfile").include(request,response);
		 }
		 
	 }
}
