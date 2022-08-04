package com.tienda;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import javax.servlet.ServletException;

public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    protected void handle(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

    }
}
