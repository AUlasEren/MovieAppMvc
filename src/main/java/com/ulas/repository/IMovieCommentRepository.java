package com.ulas.repository;

import com.ulas.repository.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IMovieCommentRepository extends JpaRepository<MovieComment,Long> {

List<MovieComment> findAllByMovieid(Long movieid);
List<MovieComment> findAllByUserid(Long userid);

List<MovieComment> findAllByMovieidAndDateBetween(Long movieid, LocalDate startDate, LocalDate endDate);
List<MovieComment> findAllByUseridAndDateBetween(Long userid, LocalDate startDate, LocalDate endDate);


}
