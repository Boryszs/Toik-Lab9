package com.demo.springboot.dto;

public class UpdateMovieDto {
    private String title;
    private Integer year;
    private String image;

    public UpdateMovieDto() {
    }

    public UpdateMovieDto(String title, Integer year, String image) {
        this.title = title;
        this.year = year;
        this.image = image;
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
}
