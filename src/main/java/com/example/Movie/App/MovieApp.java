package com.example.Movie.App;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class MovieApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private boolean isPopular;
    private String poster;
    private LocalDate releaseDate;  
    private boolean isUpcoming;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isPopular() {
        return isPopular;
    }

    public void setPopular(boolean isPopular) {
        this.isPopular = isPopular;
    }

    public String getPoster() {  
        return poster;
    }

    public void setPoster(String poster) {  
        this.poster = poster;
    }

    public LocalDate getReleaseDate() { 
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {  
        this.releaseDate = releaseDate;
    }

    public boolean isUpcoming() {
        return isUpcoming;
    }

    public void setUpcoming(boolean isUpcoming) {
        this.isUpcoming = isUpcoming;
    }

    public MovieApp() {
    }

    public MovieApp(Long id, String title, String genre, boolean isPopular, String poster, LocalDate releaseDate, boolean isUpcoming) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.isPopular = isPopular;
        this.poster = poster;
        this.releaseDate = releaseDate;
        this.isUpcoming = isUpcoming;
    }
}
