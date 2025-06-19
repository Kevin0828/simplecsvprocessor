package com.learning.simplecsvprocessor.repository;

import com.learning.simplecsvprocessor.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
}
