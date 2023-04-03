package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.EndUser;

public interface UserRepository extends JpaRepository<EndUser, Long> {
    
}
