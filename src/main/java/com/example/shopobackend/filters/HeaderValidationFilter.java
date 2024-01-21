package com.example.shopobackend.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class HeaderValidationFilter extends OncePerRequestFilter {

    List<String> channels = List.of("WEB","MOBILE");
    private final String CHANNEL = "CHANNEL";
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String channel = request.getHeader(CHANNEL);
        if(channel == null || !channels.contains(channel)){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        chain.doFilter(request, response);
    }

}
