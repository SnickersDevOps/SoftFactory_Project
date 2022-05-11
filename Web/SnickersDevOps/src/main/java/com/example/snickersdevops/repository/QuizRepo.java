package com.example.snickersdevops.repository;

import com.example.snickersdevops.models.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizRepo extends JpaRepository<Quiz, Long> {

    Page<Quiz> findByIsPublishedTrue(Pageable pageable);

    Page<Quiz> findByUser(User user, Pageable pageable);

    @Query("select q from Quiz q where q.name like %?1%")
    Page<Quiz> searchByName(String name, Pageable pageable);
}
