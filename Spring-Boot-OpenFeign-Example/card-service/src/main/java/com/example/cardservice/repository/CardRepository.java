package com.example.cardservice.repository;

import com.example.cardservice.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findCardByPan(String pan);

}
