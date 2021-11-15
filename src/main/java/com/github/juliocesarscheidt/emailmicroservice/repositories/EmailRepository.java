package com.github.juliocesarscheidt.emailmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.juliocesarscheidt.emailmicroservice.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}
