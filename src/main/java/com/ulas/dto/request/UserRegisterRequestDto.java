package com.ulas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserRegisterRequestDto {
    String name;
    String surname;
    String email;
    String password;
    String rePassword;
}
