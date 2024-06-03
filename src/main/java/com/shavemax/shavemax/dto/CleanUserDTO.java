package com.shavemax.shavemax.dto;

import com.shavemax.shavemax.entity.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CleanUserDTO {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private Role role;
}
