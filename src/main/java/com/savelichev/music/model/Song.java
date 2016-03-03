package com.savelichev.music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {

	private int songId;

	private String songTitle;

	private int artistId;

	public Song() {

	}

	public Song(int songId, String songTitle, int artistId) {
		this.songId = songId;
		this.songTitle = songTitle;
		this.artistId = artistId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "song_id")
	public int getSongId() {
		return songId;
	}

	@Column(name = "song_title")
	public String getSongTitle() {
		return songTitle;
	}

	@Column(name = "artist_id")
	public int getArtistId() {
		return artistId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

}
