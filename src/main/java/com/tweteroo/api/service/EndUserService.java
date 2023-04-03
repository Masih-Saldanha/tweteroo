package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.EndUserDTO;
import com.tweteroo.api.model.EndUser;
import com.tweteroo.api.repository.EndUserRepository;

@Service
public class EndUserService {
    @Autowired
    private EndUserRepository repository;

    public List<EndUser> listAll() {
        return repository.findAll();
    }

    public void signUp(EndUserDTO dto) {
        repository.save(new EndUser(dto));
    }
}
