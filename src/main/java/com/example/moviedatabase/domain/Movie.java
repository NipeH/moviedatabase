package com.example.moviedatabase.domain;


//id
//title
//director
//year
//description
//img URL youtube URL???

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title, director, description;
    private int year;

    //category
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryid")
    private Category category;

    public Movie(){}

    public Movie(String title, String director, String description, int year, Category category) {

        super();

        this.title = title;
        this.director = director;
        this.description = description;
        this.year = year;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", category=" + category +
                '}';
    }
}



