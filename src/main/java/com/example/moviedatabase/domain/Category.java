package com.example.moviedatabase.domain;





//id
//category
//
//
import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryid;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Movie> movies;


    public Category(){}

    public Category(String name){
        super();
        this.name = name;

    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;

    }

    @Override
    public String toString(){
        return "Category{" +
                "categoryid=" + categoryid +
                ", name='" + name + '\'' +

                '}';
    }
}
