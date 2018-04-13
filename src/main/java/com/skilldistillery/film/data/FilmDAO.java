package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Language;


	public interface FilmDAO {
	  public Film getFilmById(int filmId);
	  public List<Film> getFullFilmById(int filmId);
	  public Actor getActorById(int actorId);
	  public List<Actor> getActorsByFilmId(int filmId);
	  public List<Film> getFilmByKeyword(String keyword);
	  public Language getLanguageByFilmId(int filmId);
	  public Film addFilm(String title, String desc, String rating);
	  public void deleteFilm(int filmId);
	}


