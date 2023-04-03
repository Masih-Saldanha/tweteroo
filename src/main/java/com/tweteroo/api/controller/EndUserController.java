package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.EndUserDTO;
import com.tweteroo.api.model.EndUser;
import com.tweteroo.api.service.EndUserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth/sign-up")
public class EndUserController {
    @Autowired
    private EndUserService service;

    @GetMapping
    public List<EndUser> listAll() {
        return service.listAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public String signUp(@RequestBody @Valid EndUserDTO req) {
        service.signUp(req);
        return "OK";
    }
}
