package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweeteDTO;
import com.tweteroo.api.service.TweeteService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tweets")
public class TweeteController {
    @Autowired
    private TweeteService service;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String createTweet(@RequestBody @Valid TweeteDTO req) {
        service.createTweet(req);
        return "OK";
    }

    @GetMapping
    public List<TweeteDTO> getTweetsByPage(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return service.getTweetsByPage(page);
    }

    @GetMapping("/{username}")
    public List<TweeteDTO> getTweetsByUser(@PathVariable String username) {
        return service.getTweetsByUser(username);
    }
}
