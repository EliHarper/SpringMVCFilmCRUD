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
<<<<<<< HEAD
	  public Film getFilmByKeyword(String keyword);
	  public String getLanguageByFilmId(int filmId);
	  public Film addFilm(String title, String desc, String rating);
=======
	  public List<Film> getFilmByKeyword(String keyword);
	  public Language getLanguageByFilmId(int filmId);
	  public Film addFilm(Film film);
>>>>>>> 0cdedb8062b6c83a447314f300e9663c63e3e70e
	  public void deleteFilm(int filmId);
	}


