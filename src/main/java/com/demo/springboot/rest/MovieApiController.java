package com.demo.springboot.rest;

import com.demo.springboot.dto.CreateMovieDto;
import com.demo.springboot.dto.MovieDto;
import com.demo.springboot.service.serviceImpl.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class MovieApiController {
    private static final Logger LOG = LoggerFactory.getLogger(MovieApiController.class);

    @Autowired
    MovieService movieService;

    public MovieApiController() {

    }

    @GetMapping("/api/movies")
    public ResponseEntity<List<MovieDto>> getMovies() {
        LOG.info("--- get all movies: {}", movieService.getMovies());
        return ResponseEntity.ok().body(movieService.getMovies());    // = new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @DeleteMapping("/api/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Integer id) {
        LOG.info("--- id: {}", id);
        if(movieService.deleteMovie(id)){
            return ResponseEntity.ok().build();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/api/movies/{id}")
    public ResponseEntity<Void> updateMovie(@PathVariable("id") Integer id, @RequestBody MovieDto movieDto) {
        LOG.info("--- id: {}", id);
        if(movieService.updateMovie(id,movieDto)) {
            return ResponseEntity.ok().build();
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/movies")
    public ResponseEntity<Void> createMovie(@RequestBody CreateMovieDto createMovieDto) throws URISyntaxException {
        LOG.info("--- title: {}", createMovieDto.getTitle());
        LOG.info("--- title: {}", createMovieDto.getYear());
        LOG.info("--- title: {}", createMovieDto.getImage());

        if(movieService.createMovie(createMovieDto)){
            return ResponseEntity.created(new URI("/api/movies/" +movieService.getMovies().get(movieService.getMovies().size()-1))).build();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
