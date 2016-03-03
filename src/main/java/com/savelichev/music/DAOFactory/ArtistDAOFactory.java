package com.savelichev.music.DAOFactory;

import com.savelichev.music.DAOImpl.ArtistDAOImpl;
import com.savelichev.music.DAOInterfaces.ArtistDAO;

public class ArtistDAOFactory {

	private static ArtistDAO artistDAO = null;
	private static ArtistDAOFactory instance = null;

	public static synchronized ArtistDAOFactory getInstance() {
		if (instance == null) {
			instance = new ArtistDAOFactory();
		}
		return instance;
	}

	public ArtistDAO getArtistDAO() {
		if (artistDAO == null) {
			artistDAO = new ArtistDAOImpl();
		}
		return artistDAO;
	}
}