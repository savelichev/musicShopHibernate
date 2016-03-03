package com.savelichev.music.DAOFactory;

import com.savelichev.music.DAOImpl.BandDAOImpl;
import com.savelichev.music.DAOInterfaces.BandDAO;

public class BandDAOFactory {

	private static BandDAO bandDAO = null;
	private static BandDAOFactory instance = null;

	public static synchronized BandDAOFactory getInstance() {
		if (instance == null) {
			instance = new BandDAOFactory();
		}
		return instance;
	}

	public BandDAO getBandDAO() {
		if (bandDAO == null) {
			bandDAO = new BandDAOImpl();
		}
		return bandDAO;
	}
}