package com.capstone.project.service.oauth;

import com.capstone.project.common.util.JwtTokenDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public interface OauthService {

    void redirectToLoginUri(HttpServletResponse response);
    JwtTokenDTO login(String authorizeCode);
    String makeLoginUri();
}
