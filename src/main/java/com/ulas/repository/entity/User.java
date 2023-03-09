package com.ulas.repository.entity;

import com.ulas.repository.entity.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.List;
/*
userrepository -userservice
-usercontroller
-register işlemi yapalım ve verileri teker teker alalım.
-name surname password ve email olsun

 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tbluser")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 50)
    String name;
    @Column(length = 50)
    String surname;
    @Column(length = 50)
    String email;
    String phone;
    @Column(length = 32)
    String password;
    @ElementCollection
    private List<Long> favGenres;
    @ElementCollection
    private List<Long> favMovies;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserType userType = UserType.USER;
    @ElementCollection
    private List<Long> comments;

}
