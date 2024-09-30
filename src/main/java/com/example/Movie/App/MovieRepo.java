package com.example.Movie.App;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepo extends JpaRepository<MovieApp, Long> {

    MovieApp findByTitle(@Param("title") String title);

    List<MovieApp> findByGenre(String genre);

    List<MovieApp> findByIsPopularTrue();

    @Query("SELECT m FROM MovieApp m WHERE m.title LIKE :title%")
    List<MovieApp> search(@Param("title") String title);

    @Query("SELECT m FROM MovieApp m WHERE m.releaseDate >= :today")  
    List<MovieApp> findUpcomingMovies(@Param("today") LocalDate today);

    @Query("SELECT m FROM MovieApp m WHERE m.releaseDate >= :today ORDER BY m.releaseDate DESC")  
    List<MovieApp> findUpcomingMoviesDescending(@Param("today") LocalDate today);
}
