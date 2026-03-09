package com.project.backend.controllers;


import com.project.backend.entities.Author;
import com.project.backend.entities.Paper;
import com.project.backend.repositories.AuthorRepository;
import com.project.backend.repositories.PaperRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AuthorController {

    private AuthorRepository authorRepository;
    private PaperRepository paperRepository;

    public AuthorController(AuthorRepository authorRepository,  PaperRepository paperRepository) {
        this.authorRepository = authorRepository;
        this.paperRepository = paperRepository;
    }


    @GetMapping("/findById")
    public Author getAuthor(@RequestParam long id) {
        return authorRepository.findById(id).get();

    }
    @GetMapping("/findByExactName")
    public List<Author> getAuthorByName(@RequestParam String name) {
        return authorRepository.findAuthorsByName(name);
    }

    @GetMapping("/findByNameContainingIGC")
    public List<Author> getAuthorsByNameContainingIgnoreCase(@RequestParam String name) {
        return authorRepository.findAuthorsByNameContainingIgnoreCase(name);
    }

    @GetMapping("/findByNameContainsIGC")
    public List<Author> getAuthorsByNameContainsIgnoreCase(@RequestParam String name) {
        return authorRepository.findAuthorsByNameContainsIgnoreCase(name);
    }

    @GetMapping("/findAll")
    public Page<Author> getAll(@RequestParam(defaultValue = "0") int page
                                , @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());

        return authorRepository.findAll(pageable);
    }



    @GetMapping("/categoryFilter")
    public List<Author> filterByCategory(@RequestParam String category) {
        return authorRepository.filterByCategory(category);

    }

    @GetMapping("/findPapers")
    public List<Paper> findPapers(@RequestParam long id) {
        return paperRepository.findPapersByAuthorId(id);
    }


}
