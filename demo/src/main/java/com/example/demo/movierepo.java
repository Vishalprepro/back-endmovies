package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.time.*;
import java.util.List;

@Repository
public interface movierepo extends JpaRepository<movieapp, Long> {

    @Query("select m from movieapp m where m.genre1=:genre")
    List<movieapp> findByGenre1(@Param("genre") String genre);

    @Query("select m from movieapp m where m.popular=true")
    List<movieapp> findByIsPopularTrue();

    @Query("select m from movieapp m where m.name LIKE :name%")
    List<movieapp> findByName(@Param("name") String name);

    List<movieapp> findAll();

    @Modifying
    @Transactional // Required for modifying queries
    @Query("DELETE FROM movieapp m WHERE m.name = :name")
    void deleteByName(@Param("name") String name);

    @Query("select m from movieapp m where m.Date>=:today")
    List<movieapp> upcoming(@Param("today") LocalDate today);

    @Query("select m from movieapp m where m.Date<=:today")
    List<movieapp> past(@Param("today") LocalDate today);

    @Query("select m from movieapp m where m.Date >=:today order by m.Date desc")
    List<movieapp> findupcoming(@Param("today") LocalDate today);

    @Query("SELECT m FROM movieapp m ORDER BY m.Date DESC")
    List<movieapp> findallmovies(@Param("today") LocalDate today);

    @Query("SELECT AVG(m.rating) FROM movieapp m")
    float findAverageRating();

    @Query("from movieapp")
    List<movieapp> findAllMovies();

    @Modifying
    @Transactional
    @Query("Update movieapp m set m.name=:name where m.id=:id")
    void updateMovie(@Param("name") String name, @Param("id") Long id);

    @Query("select m from movieapp m where m.rating >2.0  AND m.rating <= :avgrating")
    List<movieapp> findmoviesByRating(@Param("avgrating") float avgrating);

}
