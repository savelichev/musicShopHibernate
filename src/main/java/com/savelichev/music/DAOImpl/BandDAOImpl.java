package com.savelichev.music.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.savelichev.music.DAOInterfaces.BandDAO;
import com.savelichev.music.model.Band;

public class BandDAOImpl implements BandDAO {

	@Override
	public void addBand(Band band) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(band);
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
	public void updateBand(Band band) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(band);
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
	public void deleteBand(Band band) {
		// TODO Auto-generated method stub

	}

	@Override
	public Band getBandById(int bandId) {
		Session session = null;
		Band band = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			band = (Band) session.load(Band.class, bandId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return band;
	}

	@Override
	public List<Band> getAllBands() {
		Session session = null;
		List<Band> bands = new ArrayList<Band>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			bands = session.createCriteria(Band.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return bands;
	}

}
