package kg.aklimoff.spy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {
    @NotBlank(message = "Username cannot be blank")
    private String nickname;

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 3, max = 24, message = "Length must be between 3 and 24")
    @Pattern(regexp = "^(?=.*[a-z]).+$",
            message = "Password must contain at least one lowercase letter.")
    private String password;

}
