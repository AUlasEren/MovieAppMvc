package com.ulas.controller;

import com.ulas.repository.entity.Movie;
import com.ulas.repository.entity.User;
import com.ulas.service.GenreService;
import com.ulas.service.MovieCommentService;
import com.ulas.service.MovieService;
import com.ulas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    private final GenreService genreService;
    private final UserService userService;
    private final MovieCommentService movieCommentService;

    @GetMapping("/findall")
    public ModelAndView getMoviePage(Long userid){
        User user;
        ModelAndView modelAndView = new ModelAndView();
        if (userid==null){
            modelAndView.addObject("user",null);
        }else{
            user=userService.findById(userid).get();
            modelAndView.addObject("user",user);
        }
        List<Movie> movieList = movieService.findAll();
        modelAndView.addObject("movies",movieList);
        modelAndView.addObject("genreservice",genreService);
        //modelAndView.addObject("genres",genreService.findAll());
        modelAndView.setViewName("movies");
        return modelAndView;
    }
    @GetMapping("/findbyid/{id}")
    public ModelAndView getMovieById(@PathVariable Long id,@RequestParam(required = false) Long userid){
        User user;
        ModelAndView modelAndView = new ModelAndView();
        if (userid==null){
            modelAndView.addObject("user",null);
        }else{
            user=userService.findById(userid).get();modelAndView.addObject("user",user);
        }

        Optional<Movie> movie = movieService.findById(id);
        modelAndView.addObject("movie",movie.get());
        modelAndView.addObject("genreservice",genreService);
        modelAndView.addObject("moviecommentservice",movieCommentService);
        modelAndView.addObject("userservice",userService);
        modelAndView.setViewName("moviesDetail");
        return modelAndView;
    }



}
