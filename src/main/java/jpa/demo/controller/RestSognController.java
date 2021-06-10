package jpa.demo.controller;

import jpa.demo.model.Sogn;
import jpa.demo.repository.KommuneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import jpa.demo.repository.SognRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@CrossOrigin()
@org.springframework.web.bind.annotation.RestController
public class RestSognController {
    SognRepository sognRepository;
    KommuneRepository kommuneRepository;

    public RestSognController(SognRepository sognRepository, KommuneRepository kommuneRepository){
        this.sognRepository = sognRepository;
        this.kommuneRepository = kommuneRepository;
    }

    // HTTP Get List
    @GetMapping("/sogns")
    public ResponseEntity<Iterable<Sogn>> findSogns(){
        return ResponseEntity.status(HttpStatus.OK).body(sognRepository.findAll());
    }

    // HTTP Get by ID
    @GetMapping("/sogns/{id}")
    public ResponseEntity<Optional<Sogn>> findById(@PathVariable Long id)
    {
        Optional<Sogn> optionalRecipe = sognRepository.findById(id);
        if (optionalRecipe.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalRecipe);
        }
        else{
            //Not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalRecipe);
        }
    }

    // HTTP Post, ie. create
}
