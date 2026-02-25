//package com.project.backend.repositories;
//
//
//import com.project.backend.entities.Paper;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface PaperRepository extends JpaRepository<Paper, Long> {
//
//
//
//    @Query(value = "select * from paper p where p.author_id = :id", nativeQuery = true)
//    List<Paper> findPapersByAuthorId(@Param("id") Long id);
//}
