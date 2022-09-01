package dk.kea.moviefactsworkshopdat22v2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @GetMapping("/")
    public String index(){
        return "Welcome to Movie Facts <br>" +
                "<b>/getFirst</b> returns first movie in database";

    }

}
