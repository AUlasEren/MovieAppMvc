package com.ulas.dto.response;

import com.ulas.repository.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    Long id;
    String name;
    String surname;
    String email;
    String phone;

   // private List<Long> favGenres;

    //private List<Long> favMovies;


    private UserType userType;

    //private List<Long> comments;
}
