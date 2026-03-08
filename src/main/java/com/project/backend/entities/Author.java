package com.project.backend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "affiliation")
    private String affiliation;

    @Column(name = "work_domain" , columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> workDomain;

    @Column(name = "scholar_link")
    private String scholarLink;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    List<Paper> papers;


}
