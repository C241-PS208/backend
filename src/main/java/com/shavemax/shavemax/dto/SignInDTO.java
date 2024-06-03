package com.shavemax.shavemax.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SignInDTO {
    @NotNull
    private String email;
    @NotNull
    private String password;
}