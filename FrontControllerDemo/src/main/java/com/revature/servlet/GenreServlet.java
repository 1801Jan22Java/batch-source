package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Genre;
import com.revature.dao.GenreDao;
import com.revature.dao.GenreDaoImpl;

/**
 * Servlet implementation class GenreServlet
 */
public class GenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenreServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GenreDao gd = new GenreDaoImpl();
		List<Genre> genreList = gd.getGenre();
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		String genreString = om.writeValueAsString(genreList);
		resp.getWriter().write("{\"genre\":" + genreString + "}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
