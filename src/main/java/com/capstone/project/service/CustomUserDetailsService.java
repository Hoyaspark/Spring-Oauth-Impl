package com.capstone.project.service;

import com.capstone.project.domain.Member;
import com.capstone.project.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 여기서 username 은 email

        Member findMember = authRepository.findMemberByEmail(username)
                .orElseThrow(() -> {
                    throw new RuntimeException("Failed Find Member With Email");
                });

        return new User(
                findMember.getEmail(),
                findMember.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(findMember.getAuthRole().toString())));

        // ROLE_USER, ROLE_ADMIN
    }

}
