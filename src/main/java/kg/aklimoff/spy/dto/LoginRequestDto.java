package kg.aklimoff.spy.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDto {
    @NotBlank
    private String nickname;
    @NotBlank
    private String password;
}
