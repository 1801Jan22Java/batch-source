package com.revature.dao;

import java.util.List;

import com.revature.domain.Image;

public interface ImageDao {

	public List<Image> getImages();

	public Image getImageById(int id);

	public int createImage(Image u);

	public int updateImage(Image u);

	public int deleteImage(Image u);
	
}
