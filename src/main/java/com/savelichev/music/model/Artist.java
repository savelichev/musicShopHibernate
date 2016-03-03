package com.savelichev.music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist {

	private int artistId;

	private String artistName;

	private String artistRole;

	private int bandId;

	public Artist() {

	}

	public Artist(int artistId, String artistName, String artistRole, int bandId) {

		this.artistId = artistId;
		this.artistName = artistName;
		this.artistRole = artistRole;
		this.bandId = bandId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artist_id")
	public int getArtistId() {
		return artistId;
	}

	@Column(name = "artist_name")
	public String getArtistName() {
		return artistName;
	}

	@Column(name = "artist_role")
	public String getArtistRole() {
		return artistRole;
	}

	@Column(name = "band_id")
	public int getBandId() {
		return bandId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public void setArtistRole(String artistRole) {
		this.artistRole = artistRole;
	}

	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

}
