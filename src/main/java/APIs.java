//
//import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import java.util.List;
//import java.util.Map;
//import java.util.HashMap;
//
//
//
//
//
//import java.util.Optional;
//
//@SpringBootApplication
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/movies")
//public class APIs {
//
//
//    @Autowired
//    private MovieRepository movieRepository;
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(APIs.class, args);
//    }
//
//
//
//
//    @GetMapping("/all")
//    public @ResponseBody Iterable<Movie> getAllMovies() {
//        return movieRepository.findAll();
//    }
//
//
//
//    @PostMapping("/addMovie")
//    public @ResponseBody String addAMovie (@RequestParam String title, @RequestParam String summary, @RequestParam int comedy) {
//        Movie savedMovie = new Movie(title, summary, comedy);
//        movieRepository.save(savedMovie);
//        return "Saved";
//    }
//
//    @PostMapping("/addMovieBody")
//    public Movie createMovie(@RequestBody Movie movie) {
//        return movieRepository.save(movie);
//    }
//
//    @PostMapping("/deleteMovie")
//    public @ResponseBody String deleteMovie (@RequestParam int film_id){
//        movieRepository.deleteById(film_id);
//        return "Deleted";
//    }
//
//    @PostMapping("/updateMovie")
//    public @ResponseBody String updateMovie (@RequestParam int film_id,
//                                             @RequestParam String title, @RequestParam String summary, @RequestParam int comedy){
//        Optional<Movie> movie = movieRepository.findById(film_id);
//        Movie film = movie.get();
//        film.setComedy(comedy);
//        film.setTitle(title);
//        film.setSummary(summary);
//        movieRepository.save(film);
//        return "Movie updated";
//    }
//
//    @GetMapping("/id/{film_id}")
//    public @ResponseBody Movie findByID(@PathVariable("film_id") int film_id){
//        Movie movieresponse = movieRepository.findById(film_id).orElse(null);
//        ///Movie newMovie = movieresponse.get();
//        return movieresponse;
//    }
//
//	/*@GetMapping("/addRating")
//	public @ResponseBody String addMovieRating (@RequestParam int film_id, @RequestParam int rating){
//		Optional<Movie> movie = movieRepository.findById(film_id);
//		Movie film = movie.get();
//		int previous_rating = film.getRating();
//		int newrating = (previous_rating + rating)/5;
//		film.setRating(newrating);
//		movieRepository.save(film);
//		return "Rating updated";
//	}*/
//
//    @GetMapping("/getMovie")
//    public @ResponseBody Movie getFilm(@RequestParam int film_id) {
//        Optional<Movie> filmResponse = movieRepository.findById(film_id);
//        Movie film = filmResponse.get();
//        return film;
//    }
//    ////////////////////////////////new stuff///////////////////////
//
//
//    @GetMapping("/films")
//    public @ResponseBody Iterable<Movie> getAllFilm() {
//        return movieRepository.findAll();
//    }
//
//
//    @PostMapping("/films")
//    public Movie createFilm(@RequestBody Movie movie) {
//        return movieRepository.save(movie);
//    }
//
//    @GetMapping("/films/{id}")
//    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
//        Movie movie = movieRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Movie not exist with id :" + id));
//        return ResponseEntity.ok(movie);
//    }
//
//    // update employee rest api
//
//    @PutMapping("/films/{id}")
//    public ResponseEntity<Movie> updateEmployee(@PathVariable int id, @RequestBody Movie movieDetails){
//        Movie movie = movieRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Movie not exist with id :" + id));
//
//        movie.setTitle(movieDetails.getTitle());
//        movie.setSummary(movieDetails.getSummary());
//        movie.setComedy(movieDetails.getComedy());
//
//        Movie updatedMovie = movieRepository.save(movie);
//        return ResponseEntity.ok(updatedMovie);
//    }
//
//    // delete employee rest api
//    @DeleteMapping("/films/{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteFilm(@PathVariable int id){
//        Movie movie = movieRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Movie not exist with id :" + id));
//
//        movieRepository.delete(movie);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }
//
//}
