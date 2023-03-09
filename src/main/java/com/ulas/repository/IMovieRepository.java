package com.ulas.repository;

import com.ulas.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Transactional
@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findAllByRatingIsGreaterThan(double rate);

    List<Movie> findAllByPremiredBefore(LocalDate date);

    @Query("select rating,count(rating)from Movie group by rating ")
    Object [] searchByRating();
    @Query("select rating,count(rating)from Movie group by rating having rating=?1 ")
    Object [] searchByRating(double rating);



    List<Movie> findAllByRatingIn(List<Double> ratings);
   List<Movie> findAllByNameIn(String [] movieNames);

   int countAllByRating(double rating);

}
