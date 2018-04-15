package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(path= "addFilm.do", method= RequestMethod.POST)
    public ModelAndView addFilm(Film film) {
        ModelAndView mv = new ModelAndView();
        film.setLanguageId(filmDAO.convertLangToLangId(film.getLanguage()));
        mv.setViewName("WEB-INF/views/results.jsp");
        mv.addObject("film", filmDAO.addFilm(film));
        return mv;
	}

	@RequestMapping(path= "updateFilm.do", method= RequestMethod.GET)
	public ModelAndView homeToUpdateFilm(RedirectAttributes redir, @RequestParam(name="id")Integer filmId) {
		Film film = filmDAO.getFullFilmById(filmId);
		ModelAndView mv = new ModelAndView();
		//film.setLanguageId(filmDAO.convertLangToLangId(film.getLanguage()));
		mv.setViewName("WEB-INF/views/updateFilm.jsp");
		System.out.println(filmId);
		mv.addObject("film", film);
		return mv;
	}
	
	@RequestMapping(path= "results.do", method= RequestMethod.GET)
	public ModelAndView updateFilm(Integer filmId, String title, String description, Integer releaseYear, Integer languageId, Integer rentalDuration, Double rentalRate, Integer length, Double replacementCost, String rating) {
		Film film = new Film(filmId, title, description, releaseYear, languageId, rentalDuration, rentalRate, length, replacementCost, rating);
		filmDAO.updateFilm(film);
		ModelAndView mv = new ModelAndView();
//		film.setLanguageId(filmDAO.convertLangToLangId(updatedFilm.getLanguage()));
		mv.setViewName("WEB-INF/views/results.jsp");
//		System.out.println(updatedFilm);
		mv.addObject("film", film);
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
	public ModelAndView deleteFilm(RedirectAttributes redir, @RequestParam("filmID") int filmId) {
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