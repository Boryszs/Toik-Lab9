package com.demo.springboot.service.serviceImpl;

import com.demo.springboot.dto.CreateMovieDto;
import com.demo.springboot.dto.MovieDto;
import com.demo.springboot.dto.MovieListDto;
import com.demo.springboot.service.MovieService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface MovieInterface {

     List<MovieDto> getMovies();
     boolean deleteMovie(Integer id);
     boolean updateMovie(Integer id,MovieDto movieDto);
     boolean createMovie(CreateMovieDto createMovieDto);
}
