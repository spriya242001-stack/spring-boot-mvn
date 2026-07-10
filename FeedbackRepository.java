package com.example.productcatalog.repository;


import com.example.productcatalog.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface FeedbackRepository
            extends JpaRepository<FeedbackEntity, Long> {
    }

