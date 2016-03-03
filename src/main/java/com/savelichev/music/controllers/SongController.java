package com.savelichev.music.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.savelichev.music.DAOFactory.SongDAOFactory;
import com.savelichev.music.DAOInterfaces.SongDAO;
import com.savelichev.music.model.Song;

@Controller
public class SongController {

	SongDAO songDAO = SongDAOFactory.getInstance().getSongDAO();

	@RequestMapping(value = "/listSong", method = RequestMethod.GET)
	public ModelAndView listSong(ModelAndView model) {
		List<Song> listSong = songDAO.getAllSongs();
		model.addObject("listSong", listSong);
		model.setViewName("listAllSongs");

		return model;
	}

	@RequestMapping(value = "/newSong", method = RequestMethod.GET)
	public ModelAndView newSong(ModelAndView model) {
		Song newSong = new Song();
		model.addObject("song", newSong);
		model.setViewName("SongEditOrAddForm");
		return model;
	}

	@RequestMapping(value = "/saveSong", method = RequestMethod.POST)
	public ModelAndView saveSong(@ModelAttribute Song song) {

		if (song.getSongId() > 0) {
			songDAO.updateSong(song);
		} else {
			songDAO.addSong(song);
		}

		return new ModelAndView("redirect:/listSong");
	}

	@RequestMapping(value = "/deleteSong", method = RequestMethod.GET)
	public ModelAndView deleteSong(HttpServletRequest request) {
		int songId = Integer.parseInt(request.getParameter("id"));
		songDAO.deleteSongById(songId);
		return new ModelAndView("redirect:/listSong");
	}

	@RequestMapping(value = "/editSong", method = RequestMethod.GET)
	public ModelAndView editSong(HttpServletRequest request) {
		int songId = Integer.parseInt(request.getParameter("id"));
		Song song = songDAO.getSongById(songId);
		ModelAndView model = new ModelAndView("SongEditOrAddForm");
		model.addObject("song", song);

		return model;
	}
}
