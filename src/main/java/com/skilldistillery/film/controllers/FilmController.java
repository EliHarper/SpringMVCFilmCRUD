package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;

@Controller
public class FilmController {
	
	@Autowired
	FilmDAO filmDAO;
	
	public void setFilmDAO(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}
	
<<<<<<< HEAD
	@RequestMapping(params="filmID", path= "filmId.do", method= {RequestMethod.GET})
	public ModelAndView getFilmById(@RequestParam("filmID") Integer filmId) {
=======
	@RequestMapping(params="filmId", path= "home.do", method= {RequestMethod.GET})
	public ModelAndView getFilmById(@RequestParam("filmId") int filmId) {
>>>>>>> 0d2fad90d46e5c8e26bf0a525263960481fb164b
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/results.jsp");
		mv.addObject("film", filmDAO.getFilmById(filmId));
		return mv;
	}
	
	@RequestMapping(params= {"title", "description", "rating"}, path= "home.do", method= {RequestMethod.GET})
	public ModelAndView addFilm(@RequestParam("title, description, rating") String title, String description, String rating) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/results.jsp");
		mv.addObject("film", filmDAO.addFilm(title, description, rating));
		return mv;
	}
	
	@RequestMapping(params="filmKeyword", path="home.do", method= {RequestMethod.GET})
	public ModelAndView searchFilmByKeyword(@RequestParam("filmKeyword") String filmKeyword) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/results.jsp");
		mv.addObject("film", filmDAO.getFilmByKeyword(filmKeyword));
		return mv;
	}
	 @RequestMapping(path = "home.do")
	    public ModelAndView home() {
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("WEB-INF/views/home.jsp");
	        return mv;
	    }
}