package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Language;

public class FilmDAOImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static final String user = "student", pass = "student";

	@Override
	public Film getFilmById(int filmId) {
		String sql = "SELECT f.title, f.release_year, f.rating, f.description, f.id, language_id FROM film f WHERE f.id = ?";
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String title = rs.getString(1);
				int releaseYear = rs.getInt(2);
				String rating = rs.getString(3);
				String description = rs.getString(4);
				int id = rs.getInt(5);
				int lanaguageId = rs.getInt(6);

				List<Actor> cast = getActorsByFilmId(id);
				Language language = getLanguageByFilmId(lanaguageId);
				film = new Film(title, releaseYear, rating, cast, language, description);

			}
			rs.close();
			stmt.close();
			conn.close();

			if (film == null) {
				System.out.println("\t*****No films found matching Film ID:" + " \"" + filmId + "\""
						+ ", please search again.*****");
				film = new Film();
			}

		} catch (SQLException sqlex) {
			System.err.println("Error retrieving film id " + filmId);
			sqlex.printStackTrace();
		}

		return film;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load DB driver. Exiting");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public Actor getActorById(int actorId) {
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String fName = rs.getString(2);
				String lName = rs.getString(3);

				actor = new Actor(id, fName, lName);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqlex) {
			System.err.println("Error retrieving ACTOR ID." + actorId);
			sqlex.printStackTrace();
		}

		return actor;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		List<Actor> cast = new ArrayList<>();
		Connection conn;
		String sql = "SELECT id, first_name, last_name FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_actor.film_id = ?";
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String fName = rs.getString(2);
				String lName = rs.getString(3);
				Actor actor = new Actor(id, fName, lName);
				cast.add(actor);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqlex) {
			System.err.println("Error retrieving actors for film " + filmId);
			sqlex.printStackTrace();
		}

		return cast;
	}

	@Override
	public List<Film> getFilmByKeyword(String keyword) {
		List<Film> filmsList = new ArrayList<>();
		String sql = "SELECT f.title, f.release_year, f.rating, f.description, f.id, f.language_id FROM film f WHERE f.title like ? OR f.description like ?";
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String title = rs.getString(1);
				int releaseYear = rs.getInt(2);
				String rating = rs.getString(3);
				String description = rs.getString(4);
				int id = rs.getInt(5);
				int lanaguageId = rs.getInt(6);

				List<Actor> cast = getActorsByFilmId(id);
				Language language = getLanguageByFilmId(lanaguageId);
				film = new Film(title, releaseYear, rating, cast, language, description);
				filmsList.add(film);
			}

			if (film == null) {
				System.out.println("\t*****No films found matching" + " \"" + keyword.toUpperCase() + "\""
						+ ", please search again.*****");
				film = new Film();
			}
			rs.close();
			stmt.close();
			conn.close();
		}

		catch (SQLException sqlex) {
			System.err.println("Error retrieving film keyword " + keyword.toUpperCase());
			sqlex.printStackTrace();
		}

		return filmsList;
	}

	@Override
	public Language getLanguageByFilmId(int filmId) {
		String sql = "SELECT name FROM language WHERE id = ?";
		Language language = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString(1);
				language = new Language(name);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqlex) {
			System.err.println("Error retrieving LANGUAGE ID " + filmId);
			sqlex.printStackTrace();
		}

		return language;
	}

	@Override
	public Film getFullFilmById(int filmId) {
		List<Film> filmsList = new ArrayList<>();
		String sql;
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			sql = "SELECT id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				int releaseYear = rs.getInt(4);
				int languageId = rs.getInt(5);
				int rentalDuration = rs.getInt(6);
				double rentalRate = rs.getDouble(7);
				int length = rs.getInt(8);
				double replacementCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String specialFeatures = rs.getString(11);

				List<Actor> cast = getActorsByFilmId(id);
				Language language = getLanguageByFilmId(id);
				film = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
						replacementCost, rating, specialFeatures, cast, language);

			}
		} catch (SQLException sqlex) {
			System.err.println("Error retrieving film. Exiting");
			System.exit(1);
		}

		return film;
	}

	@Override
	public Film addFilm(String title, String desc, String rating) {
		Film addedFilm = new Film();
		Connection conn = null;
		String sql;
		int newFilmID = 0;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sql = "INSERT INTO film (title, description, language_id, rating ) VALUES(?, ?, '1', ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			conn.setAutoCommit(false); // Start transaction
			stmt.setString(1, title);
			stmt.setString(2, desc);
			stmt.setString(3, rating);
			int updatedCount = stmt.executeUpdate();

			addedFilm.setTitle(title);
			addedFilm.setDescription(desc);
			addedFilm.setLanguageId(1);
			addedFilm.setRating(rating);

			if (updatedCount == 1) { // Insert succeeded
				ResultSet rs = stmt.getGeneratedKeys();

				if (rs.next()) {
					newFilmID = rs.getInt(1);

					System.out.println("New film ID is: " + newFilmID);

				}

			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error during inserts.");
			// e.printStackTrace();
			System.err.println("SQL Error: " + e.getErrorCode() + ": " + e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			// Need to rollback, which also throws SQLException.
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}

		return addedFilm;
	}

	@Override
	public void deleteFilm(int filmId) {
		Film deletedFilm = new Film();
		Connection conn = null;
		String sql;
		String title = null;
		int newFilmID = 0;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // Start transaction
			sql = "delete from film where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			int updateCount = stmt.executeUpdate();
			System.out.println("Film with id \"" + filmId + "\" has been removed.");
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error during inserts.");
			// e.printStackTrace();
			System.err.println("SQL Error: " + e.getErrorCode() + ": " + e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			// Need to rollback, which also throws SQLException.
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}
	}

}

