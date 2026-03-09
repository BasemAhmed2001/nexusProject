package com.project.backend.repositories;

import com.project.backend.entities.Author;
import com.project.backend.entities.Paper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@EnableJpaRepositories(basePackageClasses = AuthorRepository.class)
public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query(value = "SELECT * from author where category= :category" , nativeQuery = true)
    List<Author> filterByCategory(@Param("category") String category);

    List<Author> findAuthorsByName(String name);

    List<Author> findAuthorsByNameContainingIgnoreCase( String name);


    //List<Author> findAll(Pageable pageable);

    List<Author> findAuthorsByNameContainsIgnoreCase(String name);


}
