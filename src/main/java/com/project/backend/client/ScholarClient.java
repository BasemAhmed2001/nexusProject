//package com.project.backend.client;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.service.annotation.GetExchange;
//import org.springframework.web.service.annotation.PostExchange;
//import org.springframework.web.service.annotation.HttpExchange;
//
//@HttpExchange("/users") // Base path for all methods
//public interface ScholarClient {
//
//    @GetExchange("/{id}")
//    User findById(@PathVariable("id") Long id);
//
//    @PostExchange
//    User save(@RequestBody User user);
//}