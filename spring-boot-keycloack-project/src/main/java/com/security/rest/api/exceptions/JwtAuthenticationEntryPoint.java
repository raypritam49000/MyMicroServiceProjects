package com.security.rest.api.exceptions;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Serial
    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        LOGGER.info("@@@@ AuthenticationEntryPoint :::: ");
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
    }
}
