package kg.aklimoff.spy.controller;

import jakarta.validation.Valid;
import kg.aklimoff.spy.dto.UserRegisterDto;
import kg.aklimoff.spy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<?> register (
            @Valid UserRegisterDto userRegisterDto
    ) {
        userService.createUser(userRegisterDto);
        return ResponseEntity.ok().build();
    }
}
