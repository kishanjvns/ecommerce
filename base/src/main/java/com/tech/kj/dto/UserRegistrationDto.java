package com.tech.kj.dto;

import com.tech.kj.constants.ValidatorConstants;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserRegistrationDto {
    @NotBlank(message = "{err.empty_string}")
    @Pattern(regexp = ValidatorConstants.REGX_NONSPACE_NONSPECIALCHARS)
    private String firstName;
    @NotBlank(message = "{err.empty_string}")
    @Pattern(regexp = ValidatorConstants.REGX_NONSPACE_NONSPECIALCHARS)
    private String lastName;

    @Size(min = 10,max = 13,message = "invalid.size")
    private String contactNumber;

    @Email(message = "{invalid.format}")
    @Size(min = 9, max = 50,message = "{invalid.size}")
    private String email;

    @NotBlank(message = "{err.empty_string}")
    private String userName;
}