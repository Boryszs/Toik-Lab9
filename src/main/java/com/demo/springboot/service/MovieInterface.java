package com.demo.springboot.service;

import com.demo.springboot.dto.CreateMovieDto;
import com.demo.springboot.dto.MovieDto;

import java.util.List;

public interface MovieInterface {

     List<MovieDto> getMovies();
     boolean deleteMovie(Integer id);
     boolean updateMovie(Integer id,MovieDto movieDto);
     boolean createMovie(CreateMovieDto createMovieDto);
}
