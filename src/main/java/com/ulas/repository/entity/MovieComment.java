package com.ulas.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tblmoviecomment")
@Entity
public class MovieComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Builder.Default
    private LocalDate date = LocalDate.now();
    private String content;
    String yorum;
    private Long userid;
    private Long movieid;
}
