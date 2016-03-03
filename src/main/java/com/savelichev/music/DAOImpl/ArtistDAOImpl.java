package com.savelichev.music.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.savelichev.music.DAOInterfaces.ArtistDAO;
import com.savelichev.music.model.Artist;

public class ArtistDAOImpl implements ArtistDAO {

	@Override
	public void addArtist(Artist artist) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(artist);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updateArtist(Artist artist) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(artist);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void deleteArtist(Artist artist) {
		// TODO Auto-generated method stub

	}

	@Override
	public Artist getArtistById(int artistId) {
		Session session = null;
		Artist artist = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			artist = (Artist) session.load(Artist.class, artistId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return artist;
	}

	@Override
	public List<Artist> getAllArtists() {
		Session session = null;
		List<Artist> artists = new ArrayList<Artist>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			artists = session.createCriteria(Artist.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return artists;
	}

}
