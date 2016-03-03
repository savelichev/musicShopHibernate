package com.savelichev.music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bands")
public class Band {

	private int bandId;

	private String bandName;

	public Band() {

	}

	public Band(int bandId, String bandName) {

		this.bandId = bandId;
		this.bandName = bandName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "band_id")
	public int getBandId() {
		return bandId;
	}

	@Column(name = "band_name")
	public String getBandName() {
		return bandName;
	}

	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

}
