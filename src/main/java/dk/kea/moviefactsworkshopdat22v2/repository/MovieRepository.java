package dk.kea.moviefactsworkshopdat22v2.repository;

import dk.kea.moviefactsworkshopdat22v2.model.Movie;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MovieRepository {

    public Movie getFirst(){

        Movie movie = new Movie();

        //hent en film
        try {
            File file = new ClassPathResource("imdb-data.csv").getFile();

            Scanner input = new Scanner(file);
            //smid tabel header væk
            input.nextLine();

            //læs første film
            Scanner lineScanner = new Scanner(input.nextLine()).useDelimiter(";");

            //set et field ad gangen fra lineScanner
            //Year;Length;Title;Subject;Popularity;Awards
            movie.setYear(lineScanner.nextInt());
            movie.setLength(lineScanner.nextInt());
            movie.setTitle(lineScanner.next());
            movie.setSubject(lineScanner.next());
            movie.setPopularity(lineScanner.nextInt());
            //konverter Awards til boolean
            boolean result = lineScanner.next().equals("Yes");
            movie.setAwards(result);

        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e);
        }
        catch(IOException e){
            System.out.println("IO exception: " + e);
        }
        return movie;

    }
}
