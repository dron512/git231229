package com.mh.fileex.file;

import jakarta.persistence.*;

@Entity
@Table(name = "file")
public class FileEntity {

    // h2 database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

}
