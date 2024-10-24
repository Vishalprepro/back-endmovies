package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class controller {
    private final movieserives ms;

    public controller(movieserives ms) {
        this.ms = ms;
    }

    @PostMapping("saved")
    public movieapp savedata(@RequestBody movieapp entity) {

        return ms.savedata(entity);
    }

    @PostMapping("savebulk")
    public List<movieapp> savebulk1(@RequestBody List<movieapp> entity) {
        return ms.savebulk(entity);
    }

    @GetMapping("/api/{genre1}")
    public List<movieapp> getMoviesByGenre(@PathVariable String genre1) throws Exception {
        return ms.getMoviesByGenre(genre1);
    }

    // mvn spring-boot:run

    @GetMapping("/popular")
    public List<movieapp> PopularMovies() {
        return ms.getPopularMovies();
    }

    @GetMapping("/allmovies1")
    public List<movieapp> getallmovies432() {
        return ms.getallmovies123();
    }

    @PostMapping("/byname/{entity}")
    public List<movieapp> postMethodName(@PathVariable String entity) {
        return ms.getnames(entity.toLowerCase());
    }

    @PutMapping("/movies/{id}/{newTitle}")
    public void updateMovieName(@PathVariable Long id, @PathVariable String newTitle) {
        ms.updateMovieName(id, newTitle); // Update movie title
    }

    @PostMapping("/delete/{name}")
    public List<movieapp> deleteByName(@PathVariable String name) throws Exception {
        return ms.deleteMovieByName(name);
    }

    @GetMapping("/upcoming")
    public List<movieapp> getMethodName() {
        return ms.getnewmovies();
    }

    @GetMapping("/pastmovies")
    public List<movieapp> pastmovies() {
        return ms.getpast();
    }

    @GetMapping("/findupcoming")
    public List<movieapp> getfindbyupcoming() {
        return ms.getmoviesupcoming();
    }

    @GetMapping("/allmovies")
    public List<movieapp> getmovies() {
        return ms.getsmovies();
    }

    @GetMapping("/rating")
    public float getRating() {
        return ms.getAvgMovieRating();
    }

    @GetMapping("/avgrating")
    public List<movieapp> getavgratings() {
        return ms.getmovierating();
    }

}
