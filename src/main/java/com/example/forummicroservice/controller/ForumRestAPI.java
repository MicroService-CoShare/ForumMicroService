package com.example.forummicroservice.controller;

import com.example.forummicroservice.entites.Forum;
import com.example.forummicroservice.service.ForumInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/forums")
public class ForumRestAPI {

    //private static final GrantedAuthority GOLD_CUSTOMER = new SimpleGrantedAuthority("gold");

    //@GetMapping("/quotes/{symbol}")
    //public Mono<Quote> getQuote(@PathVariable("symbol") String symbol,
                               // BearerTokenAuthentication auth ) {

       // Quote q = new Quote();
       // q.setSymbol(symbol);
       // if ( auth.getAuthorities().contains(GOLD_CUSTOMER)) {
         //   q.setPrice(10.0);
       // }
        //else {
         //   q.setPrice(12.0);
        //}
       // return Mono.just(q);
    //}

    private String title="hello , im the updated forum microservice";

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println(title);
        return title;
    }

    @Autowired
    private ForumInterface forumService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Forum> add(@RequestBody Forum forum) {
        return new ResponseEntity<>(forumService.createForum(forum), HttpStatus.OK);
    }
}
