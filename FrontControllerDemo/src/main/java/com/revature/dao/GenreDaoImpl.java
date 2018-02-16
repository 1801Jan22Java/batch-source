package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Genre;
import com.revature.util.ConnectionUtil;

public class GenreDaoImpl implements GenreDao {

	@Override
	public List<Genre> getGenre() {
		List<Genre> gl = new ArrayList<>();
		Genre genre;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM GENRE";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("GENREID");
				String name = rs.getString("NAME");
				genre = new Genre(id, name);
				gl.add(genre);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return gl;
	}

}
