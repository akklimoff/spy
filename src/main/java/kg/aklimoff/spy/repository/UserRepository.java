package kg.aklimoff.spy.repository;

import kg.aklimoff.spy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> getOptionalUserByNickname(String nickname);

}
