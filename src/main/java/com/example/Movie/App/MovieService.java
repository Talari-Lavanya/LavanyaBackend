package com.example.Movie.App;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public MovieApp save(MovieApp movie) {
        return movieRepo.save(movie);
    }

    public List<MovieApp> getPopularMovies() {
        return movieRepo.findByIsPopularTrue();
    }

    public List<MovieApp> getMoviesByGenre(String genre) {
        return movieRepo.findByGenre(genre);
    }

    public List<MovieApp> search(String title) {
        return movieRepo.search(title);
    }

    public List<MovieApp> saveBulk(List<MovieApp> movies) {
        return movieRepo.saveAll(movies);
    }

    public MovieApp findByTitle(String title) {
        return movieRepo.findByTitle(title);
    }

    public List<MovieApp> getUpcomingMovies() {
        LocalDate today = LocalDate.now();
        return movieRepo.findUpcomingMovies(today);
    }

    public List<MovieApp> getUpcomingMoviesDesc() {
        LocalDate today = LocalDate.now();
        return movieRepo.findUpcomingMoviesDescending(today);
    }

    public String deleteMovie(Long id) {
        movieRepo.deleteById(id);
        return "Deleted Successfully";
    }
}
