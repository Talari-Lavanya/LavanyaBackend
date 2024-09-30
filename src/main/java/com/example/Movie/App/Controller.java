package com.example.Movie.App;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class Controller {

    private final MovieService movieService;

    @Autowired
    public Controller(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("saveMovies")
    public MovieApp saveMovie(@RequestBody MovieApp movie) {
        return movieService.save(movie);
    }

    @PostMapping("/saveBulk")
    public List<MovieApp> saveBulk(@RequestBody List<MovieApp> movies) {
        return movieService.saveBulk(movies);
    }

    @GetMapping("/popular")
    public List<MovieApp> getPopularMovies() {
        return movieService.getPopularMovies();
    }

    @GetMapping("/genre/{genre}")
    public List<MovieApp> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping("findbytitle/{title}")
    public MovieApp getByTitle(@PathVariable String title) {
        return movieService.findByTitle(title);
    }

    @GetMapping("search/{title}")
    public List<MovieApp> searchMovies(@PathVariable String title) {
        return movieService.search(title);
    }

    @GetMapping("/upcoming")
    public List<MovieApp> getUpcomingMovies() {
        return movieService.getUpcomingMovies();
    }

    @GetMapping("/upcoming-desc")
    public List<MovieApp> getUpcomingMoviesDesc() {
        return movieService.getUpcomingMoviesDesc();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }
}
