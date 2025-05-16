package kg.aklimoff.spy.repository;

import kg.aklimoff.spy.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
    @Query("SELECT a.id FROM Authority a WHERE a.role = :role")
    String findAuthorityIdByRole(@Param("role") String role);
}
