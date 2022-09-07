package com.sanedge.bookservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BOOK_TABLE")
@NoArgsConstructor
@Getter
@Setter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @Column
    private String name;
    private String description;
    private Double pricePerQty;
    private Double availableQty;
    private String authorName;
    private String authorEmail;
}
