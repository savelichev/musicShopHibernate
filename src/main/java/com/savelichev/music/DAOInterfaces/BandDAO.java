package com.savelichev.music.DAOInterfaces;

import java.util.List;

import com.savelichev.music.model.Band;

public interface BandDAO {

	public void addBand(Band band);

	public void updateBand(Band band);

	public void deleteBand(Band band);

	public Band getBandById(int bandId);

	public List<Band> getAllBands();
}
