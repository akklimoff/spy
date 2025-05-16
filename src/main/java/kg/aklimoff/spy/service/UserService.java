package kg.aklimoff.spy.service;

import kg.aklimoff.spy.dto.UserRegisterDto;
import kg.aklimoff.spy.entity.User;

public interface UserService {
    void createUser(UserRegisterDto userRegisterDto);
    User findUserById(String userId);

}
