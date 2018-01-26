package com.revature.media;

public class Series extends Media {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4358691538711088979L;
	private int seasons; // number of extant seasons
	private int episodes; // episodes per season
	
	public Series(String creator, String title, int yearPublished, String genre, int seasons, int episodes) {
		super(creator, title, yearPublished, genre);
		this.seasons = seasons;
		this.episodes = episodes;
	}

	public Series() {
		
	}

	public int getSeasons() {
		return seasons;
	}

	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}

	public int getEpisodes() {
		return episodes;
	}

	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}

	@Override
	public String toString() {
		return "Series [title=" + title + "seasons=" + seasons + ", episodes=" + episodes + ", creator=" + creator
				+ ", yearPublished=" + yearPublished + ", genre=" + genre + "]";
	}

}
