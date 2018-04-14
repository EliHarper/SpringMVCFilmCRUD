package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	FilmDAO filmDAO;
	
	public void setFilmDAO(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}
	
	@RequestMapping(path= "filmId.do", method= RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("filmID") Integer filmId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/results.jsp");
		mv.addObject("film", filmDAO.getFullFilmById(filmId));
		return mv;
	}
	
	@RequestMapping(path= "addFilm.do", method= RequestMethod.GET)

    public ModelAndView addFilm(Film film) {
        ModelAndView mv = new ModelAndView();
        film.setLanguageId(filmDAO.convertLangToLangId(film.getLanguage()));
        filmDAO.addFilm(film);
        mv.setViewName("WEB-INF/views/results.jsp");
        mv.addObject("film", filmDAO.addFilm(film));
        return mv;
	}
	
	@RequestMapping(path="filmKeyword.do", method= {RequestMethod.GET})
	public ModelAndView searchFilmByKeyword(@RequestParam("filmKeyword") String filmKeyword) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/results.jsp");
		mv.addObject("films", filmDAO.getFilmByKeyword(filmKeyword));
		return mv;
	}
	
	@RequestMapping(path="deleteFilm.do", method= {RequestMethod.GET})
	public ModelAndView deleteFilm(@RequestParam("filmID") int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.getFilmById(filmId);
		mv.setViewName("WEB-INF/views/results.jsp");
		mv.addObject("film", film);
		filmDAO.deleteFilm(filmId);
		return mv;
	}
	
	 @RequestMapping(path = "home.do")
	    public ModelAndView home() {
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("WEB-INF/views/home.jsp");
	        return mv;
	    }
}