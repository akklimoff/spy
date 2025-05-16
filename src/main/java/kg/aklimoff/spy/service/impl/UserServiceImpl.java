package kg.aklimoff.spy.service.impl;

import kg.aklimoff.spy.dto.UserRegisterDto;
import kg.aklimoff.spy.entity.User;
import kg.aklimoff.spy.repository.UserRepository;
import kg.aklimoff.spy.service.UserService;
import kg.aklimoff.spy.utils.UniqueIdGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private UniqueIdGenerator uniqueIdGenerator;

    @Override
    public User findUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found: " + userId));
    }


    @Override
    public void createUser(UserRegisterDto userRegisterDto) {
        userRegisterDto.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        User user = convertToEntity(userRegisterDto);
    }


    private User convertToEntity(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setId(uniqueIdGenerator.generateIdForUser());
        user.setEmail(userRegisterDto.getEmail());
        user.setNickname(userRegisterDto.getNickname());
        user.setPassword(userRegisterDto.getPassword());
        return user;
    }
}
