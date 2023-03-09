package com.ulas.controller;

import com.ulas.dto.request.MovieCommentCreateRequestDto;
import com.ulas.mapper.IUserMapper;
import com.ulas.repository.entity.Movie;
import com.ulas.repository.entity.MovieComment;
import com.ulas.repository.entity.User;
import com.ulas.service.MovieCommentService;
import com.ulas.service.MovieService;
import com.ulas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/moviecomment")
public class MovieCommentController {
    private final MovieCommentService movieCommentService;
    private final UserService userService;
    private final MovieService movieService;

    @PostMapping("/save")
    public ModelAndView save(MovieCommentCreateRequestDto dto){

       MovieComment movieComment= movieCommentService.save(IUserMapper.INSTANCE.toMovieComment(dto));
        Movie movie = movieService.findById(dto.getMovieid()).get();
        movie.getComments().add(movieComment.getId());
        movieService.save(movie);
        User user = userService.findById(dto.getUserid()).get();
        user.getComments().add(movieComment.getId());
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/movie/findbyid/"+dto.getMovieid()+"?userid="+dto.getUserid());
        return modelAndView;
    }
}
