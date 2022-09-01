package dk.kea.moviefactsworkshopdat22v2.controller;

import dk.kea.moviefactsworkshopdat22v2.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @GetMapping("/")
    public String index(){
        return "Welcome to Movie Facts <br>" +
                "<b>/getFirst</b> returns first movie in database";

    }

    @GetMapping("/getFirst")
    public String getFirst(){
        MovieRepository movieRepository = new MovieRepository();
        String responseText = "<h1>First movie in database</h1>";
        responseText += movieRepository.getFirst();
        return responseText;
    }

}
