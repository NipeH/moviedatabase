package com.example.moviedatabase.web;


import com.example.moviedatabase.domain.Category;
import com.example.moviedatabase.domain.CategoryRepository;
import com.example.moviedatabase.domain.Movie;
import com.example.moviedatabase.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {


    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CategoryRepository crepository;





    // kirjautuminen / login

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/returning")
    public String returning(){
        return "redirect:/movielist";
    }



    // Movie database LIST
    @RequestMapping(value="/movielist", method = RequestMethod.GET)
    public String getMovies(Model model) {
        List<Movie> movies  = (List<Movie>) movieRepository.findAll();
        model.addAttribute("movies", movies);

        return "movielist";

    }


    //REST books
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public @ResponseBody
    List<Movie> movieListRest(){
        return (List<Movie>) movieRepository.findAll();

    }

    @RequestMapping(value="/movie/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Movie> findMovieRest(@PathVariable("id") Long movieId){
        return movieRepository.findById(movieId);

    }


    // Moviedatabase FORM

    @RequestMapping(value="/newmovie", method = RequestMethod.GET)
    public String getMovieForm(Model model) {
        model.addAttribute("movie", new Movie()); // creates an empty movie class
        model.addAttribute("categories", crepository.findAll());
        return "movieform";

    }

    @RequestMapping(value="/newmovie", method = RequestMethod.POST)
    public String saveMovie(@ModelAttribute Movie movie) {
        movieRepository.save(movie);

        return "redirect:/movielist";

    }

    @RequestMapping(value="/deletemovie/{id}", method = RequestMethod.GET)
    public String deleteMovie(@PathVariable("id") Long movieId, Model model){
        movieRepository.deleteById(movieId);
        return "redirect:../movielist";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Movie movie) {
        movieRepository.save(movie);
        return "redirect:/movielist";
    }

    /*

     // Delete student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long studentId, Model model) {
    	repository.deleteById(studentId);
        return "redirect:../studentlist";
     */





}
