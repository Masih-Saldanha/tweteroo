package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweeteDTO;
import com.tweteroo.api.model.Tweete;
import com.tweteroo.api.repository.TweeteRepository;

@Service
public class TweeteService {
    @Autowired
    private TweeteRepository repository;

    public List<Tweete> listAll() {
        return repository.findAll();
    }
    
    public void createTweet(TweeteDTO dto) {
        repository.save(new Tweete(dto));
    }
}
