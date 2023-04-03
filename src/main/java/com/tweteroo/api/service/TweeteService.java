package com.tweteroo.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweeteDTO;
import com.tweteroo.api.model.Tweete;
import com.tweteroo.api.repository.TweeteRepository;

@Service
public class TweeteService {
    @Autowired
    private TweeteRepository repository;

    public void createTweet(TweeteDTO dto) {
        repository.save(new Tweete(dto));
    }

    // public List<Tweete> listAll() {
    // return repository.findAll();
    // }

    public List<TweeteDTO> getTweetsByPage(int page) {
        int size = 5;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");

        Page<Tweete> withId = repository.findAllByPage(pageRequest);
        List<TweeteDTO> withoutId = new ArrayList<>();
        for (Tweete tweet : withId) {
            withoutId.add(tweet.clone());
        }

        return withoutId;
    }
}
