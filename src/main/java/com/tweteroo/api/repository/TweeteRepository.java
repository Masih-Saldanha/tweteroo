package com.tweteroo.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tweteroo.api.model.Tweete;

public interface TweeteRepository extends JpaRepository<Tweete, Long> {
    @Query("FROM Tweete t")
    Page<Tweete> findAllByPage(Pageable pageable);

    @Query("FROM Tweete WHERE username = :searchTerm")
    List<Tweete> findAllByUsername(
            @Param("searchTerm") String searchTerm);
}
