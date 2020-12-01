package com.demo.springboot.dto;

import java.util.Comparator;

public class MovieDto implements Comparable<MovieDto> {
    private Integer movieId;
    private String title;
    private Integer year;
    private String image;

    public MovieDto() {
    }

    public MovieDto(Integer movieId, String title, Integer year, String image) {
        this.movieId = movieId;
        this.title = title;
        this.year = year;
        this.image = image;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public int compareTo(MovieDto o) {
        return this.getMovieId().compareTo(o.movieId);
    }
}
