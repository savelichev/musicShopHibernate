package com.savelichev.music.DAOFactory;

import com.savelichev.music.DAOImpl.SongDAOImpl;
import com.savelichev.music.DAOInterfaces.SongDAO;

public class SongDAOFactory {

	private static SongDAO songDAO = null;
	private static SongDAOFactory instance = null;

	public static synchronized SongDAOFactory getInstance() {
		if (instance == null) {
			instance = new SongDAOFactory();
		}
		return instance;
	}

	public SongDAO getSongDAO() {
		if (songDAO == null) {
			songDAO = new SongDAOImpl();
		}
		return songDAO;
	}
}