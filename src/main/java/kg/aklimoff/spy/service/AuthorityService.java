package kg.aklimoff.spy.service;

import kg.aklimoff.spy.entity.Authority;

public interface AuthorityService {
    String getAuthorityIdByRole(String role);
    Authority getAuthorityById(String authorityId);
}
