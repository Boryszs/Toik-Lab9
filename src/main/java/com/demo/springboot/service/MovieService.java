package com.demo.springboot.service;

import com.demo.springboot.dto.CreateMovieDto;
import com.demo.springboot.dto.MovieDto;
import com.demo.springboot.dto.MovieListDto;
import com.demo.springboot.service.serviceImpl.MovieInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MovieService implements MovieInterface {

    private final MovieListDto movies;

    public MovieService() {
        List<MovieDto> moviesList = new ArrayList<>();
        moviesList.add(new MovieDto(1,
                "Piraci z Krzemowej Doliny",
                1999,
                "https://fwcdn.pl/fpo/30/02/33002/6988507.6.jpg")
        );
        movies = new MovieListDto(moviesList);
    }

    @Override
    public List<MovieDto> getMovies() {
        Collections.sort(movies.getMovies());
        Collections.reverse(movies.getMovies());
        return movies.getMovies();
    }

    @Override
    public boolean deleteMovie(Integer id) {

        for(MovieDto movieDto:movies.getMovies()) {
            if(movieDto.getMovieId()==id) {
                movies.getMovies().remove(movieDto);
                return true;
            }
        }
            return false;
    }

    @Override
    public boolean updateMovie(Integer id, MovieDto movieDto) {
        for(MovieDto mDto:movies.getMovies()) {
            if(mDto.getMovieId()==id) {
                mDto.setTitle(movieDto.getTitle());
                mDto.setYear(movieDto.getYear());
                mDto.setImage(movieDto.getImage());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean createMovie(CreateMovieDto createMovieDto) {
        if(!createMovieDto.getTitle().equals("") && !(createMovieDto.getYear() ==null) && !createMovieDto.getImage().equals("")) {
            movies.getMovies().add(new MovieDto(movies.getMovies().get(0).getMovieId()+1, createMovieDto.getTitle(), createMovieDto.getYear(), createMovieDto.getImage()));
            return true;
        }else{
            return false;
        }
    }
}
