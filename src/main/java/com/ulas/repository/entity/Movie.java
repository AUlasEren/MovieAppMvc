package com.ulas.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblmovie")
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ElementCollection
    private List<Long> genres;
    private String language;
    private String image;
    private String name;
    private String country;
    private Double rating;
    @Column(length = 2048)
    //@Lob
    private String summary;
    private String url;
    private LocalDate premired;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> comments;

}
