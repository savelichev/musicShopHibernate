package com.savelichev.music.DAOInterfaces;

import java.util.List;

import com.savelichev.music.model.Artist;

public interface ArtistDAO {

	public void addArtist(Artist artist);

	public void updateArtist(Artist artist);

	public void deleteArtist(Artist artist);

	public Artist getArtistById(int artistId);

	public List<Artist> getAllArtists();
}
