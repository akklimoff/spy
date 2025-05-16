package kg.aklimoff.spy.service.impl;

import kg.aklimoff.spy.entity.Authority;
import kg.aklimoff.spy.repository.AuthorityRepository;
import kg.aklimoff.spy.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository authorityRepository;

    @Override
    public String getAuthorityIdByRole(String role) {
        return authorityRepository.findAuthorityIdByRole(role);
    }

    @Override
    public Authority getAuthorityById(String authorityId) {
        return authorityRepository.findById(authorityId)
                .orElseThrow(() -> new NoSuchElementException("Authority not found with id: " + authorityId));
    }
}
