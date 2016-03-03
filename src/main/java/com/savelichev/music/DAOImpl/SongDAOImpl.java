package com.savelichev.music.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.savelichev.music.DAOInterfaces.SongDAO;
import com.savelichev.music.model.Song;

public class SongDAOImpl implements SongDAO {

	@Override
	public void addSong(Song song) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(song);
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
	public void updateSong(Song song) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(song);
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
	public Song getSongById(int songId) {
		Session session = null;
		Song song = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			song = (Song) session.load(Song.class, songId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return song;
	}

	@Override
	public List<Song> getAllSongs() {
		Session session = null;
		List<Song> songs = new ArrayList<Song>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			songs = session.createCriteria(Song.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return songs;
	}

	@Override
	public void deleteSongById(int songId) {
		Session session = null;
		Song tempSong = new Song();
		tempSong.setSongId(songId);

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(tempSong);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

}
