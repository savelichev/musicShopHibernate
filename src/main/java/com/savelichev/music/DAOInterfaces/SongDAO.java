package com.savelichev.music.DAOInterfaces;

import java.util.List;

import com.savelichev.music.model.Song;

public interface SongDAO {

	public void addSong(Song song);

	public void updateSong(Song song);

	public void deleteSongById(int songId);

	public Song getSongById(int songId);

	public List<Song> getAllSongs();
}
