package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;


	public interface FilmDAO {
	  public Film getFilmById(int filmId);
	  public Film getFullFilmById(int filmId);
	  public Actor getActorById(int actorId);
	  public List<Actor> getActorsByFilmId(int filmId);
	  public int convertLangToLangId(String language);
	  public Film getFilmByKeyword(String keyword);
	  public String getLanguageByFilmId(int filmId);
	  public Film addFilm(Film film);
	  public void deleteFilm(int filmId);
	  public Film updateFilm(Film film);
	}


