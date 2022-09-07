package com.sanedge.bookservice.repository;

import org.springframework.stereotype.Repository;

import com.sanedge.bookservice.entity.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
