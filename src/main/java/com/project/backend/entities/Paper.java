//package com.project.backend.entities;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "paper")
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class Paper {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "paper_name")
//    private String paperName;
//
//    @Column(name = "paper_year")
//    private int paperYear;
//
//    @Column(name = "paper_scolar_link")
//    private String paperScolarLink;
//
//    @Column(name = "publisher_link")
//    private String publisherLink;
//
//    @Column(name = "category")
//    private String category;
//
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "author_id")
//    private Author author;
//
//}
