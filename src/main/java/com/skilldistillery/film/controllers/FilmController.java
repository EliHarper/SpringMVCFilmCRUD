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
	
	@RequestMapping(params="filmId", path= "results.do", method= {RequestMethod.GET})
	public ModelAndView getFilmById(@RequestParam("filmId") int filmId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/result.jsp");
		mv.addObject("film", filmDAO.getFilmById(filmId));
		return mv;
	}
	
	@RequestMapping(params="title, description, rating", path= "addedFilm.do", method= {RequestMethod.GET})
	public ModelAndView addFilm(@RequestParam("title, description, rating") String title, String description, String rating) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/result.jsp");
		mv.addObject("film", filmDAO.addFilm(title, description, rating));
		return mv;
	}
//	public class StateController {
//		@Autowired
//		StateDAO stateDAO;
//
//		public void setStateDAO(StateDAO stateDAO) {
//			this.stateDAO = stateDAO;
//		}
//
//		@RequestMapping(params="name",path = "GetStateData.do", method = { RequestMethod.GET })
//		public ModelAndView getStateByName(@RequestParam("name") String name) {
//			ModelAndView mv = new ModelAndView();
//			mv.setViewName("WEB-INF/result.jsp");
//			mv.addObject("state", stateDAO.getStateByName(name));
//			return mv;
//		}
//
//		@RequestMapping(params="abbr", path = "GetStateData.do", method = { RequestMethod.GET })
//		public ModelAndView getStateByAbbr(@RequestParam("abbr") String abbr) {
//			ModelAndView mv = new ModelAndView();
//			mv.setViewName("WEB-INF/result.jsp");
//			mv.addObject("state", stateDAO.getStateByAbbreviation(abbr));
//			return mv;
		
}
