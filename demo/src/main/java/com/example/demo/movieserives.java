package com.example.demo;

import java.util.*;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.time.*;

@Service
public class movieserives {

    private final movierepo Movierepositorys;

    public movieserives(movierepo movierepositorys) {
        this.Movierepositorys = movierepositorys;
    }

    public movieapp savedata(movieapp movies) {
        return Movierepositorys.save(movies);
    }

    @Transactional
    public List<movieapp> deleteMovieByName(String name) throws Exception {
        Movierepositorys.deleteByName(name);
        return Movierepositorys.findAll();
    }

    public List<movieapp> savedbulk(List<movieapp> movies) {
        return Movierepositorys.saveAll(movies);
    }

    public List<movieapp> savebulk(List<movieapp> movies) {
        return Movierepositorys.saveAll(movies);
    }

    public List<movieapp> getMoviesByGenre(String genre) {
        return Movierepositorys.findByGenre1(genre);
    }

    public List<movieapp> getPopularMovies() {
        return Movierepositorys.findByIsPopularTrue();
    }

    public List<movieapp> getnames(String name) {
        return Movierepositorys.findByName(name);
    }

    public List<movieapp> getnewmovies() {
        LocalDate id = LocalDate.now();
        return Movierepositorys.upcoming(id);

    }

    public List<movieapp> getpast() {
        LocalDate id = LocalDate.now();
        return Movierepositorys.past(id);
    }

    public List<movieapp> getmoviesupcoming() {
        LocalDate id = LocalDate.now();
        return Movierepositorys.findupcoming(id);
    }

    public List<movieapp> getsmovies() {
        LocalDate id = LocalDate.now();
        return Movierepositorys.findallmovies(id);
    }

    public float getAvgMovieRating() {
        return Movierepositorys.findAverageRating();
    }

    public List<movieapp> getmovierating() {
        float ar = Movierepositorys.findAverageRating();
        return Movierepositorys.findmoviesByRating(ar);
    }

}
