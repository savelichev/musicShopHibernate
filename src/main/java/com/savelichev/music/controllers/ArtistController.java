package com.savelichev.music.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.savelichev.music.DAOFactory.ArtistDAOFactory;
import com.savelichev.music.DAOInterfaces.ArtistDAO;
import com.savelichev.music.model.Artist;

@Controller
public class ArtistController {

	ArtistDAO artistDAO = ArtistDAOFactory.getInstance().getArtistDAO();

	@RequestMapping(value = "/listArtist", method = RequestMethod.GET)
	public ModelAndView listArtist(ModelAndView model) {
		List<Artist> listArtist = artistDAO.getAllArtists();
		model.addObject("listArtist", listArtist);
		model.setViewName("listAllArtists");
		return model;

	}

	@RequestMapping(value = "/newArtist", method = RequestMethod.GET)
	public ModelAndView newArtist(ModelAndView model) {

		Artist newArtist = new Artist();
		model.addObject("artist", newArtist);
		model.setViewName("ArtistEditOrAddForm");
		return model;

	}

	@RequestMapping(value = "/saveArtist", method = RequestMethod.POST)
	public ModelAndView saveArtist(@ModelAttribute Artist artist) {

		artistDAO.addArtist(artist);

		return new ModelAndView("redirect:/listArtist");
	}

	// @RequestMapping(value = "/deleteArtist", method = RequestMethod.GET)
	// public ModelAndView deleteArtist(HttpServletRequest request) {
	// int artistId = Integer.parseInt(request.getParameter("id"));
	// artistDAO.delete(artistId);
	// return new ModelAndView("redirect:/listArtist");
	// }

	@RequestMapping(value = "/editArtist", method = RequestMethod.GET)
	public ModelAndView editArtist(HttpServletRequest request) {
		int artistId = Integer.parseInt(request.getParameter("id"));
		Artist artist = artistDAO.getArtistById(artistId);
		ModelAndView model = new ModelAndView("ArtistEditOrAddForm");
		model.addObject("artist", artist);

		return model;
	}
}
