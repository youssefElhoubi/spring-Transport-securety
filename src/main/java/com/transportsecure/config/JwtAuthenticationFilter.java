package com.transportsecure.config;
import com.transportsecure.service.CustomUserDetailsService;
import com.transportsecure.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final CustomUserDetailsService userDetailsService;
    private final JwtService jwtService;

    public JwtAuthenticationFilter(CustomUserDetailsService userDetailsService, JwtService jwtService) {
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String Header = request.getHeader("Authorization");
        if (Header != null && Header.startsWith("Bearer ")) {
            String token = Header.substring(7);
            try {
                String id  = jwtService.extractId(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(id);
                UsernamePasswordAuthenticationToken  auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication( auth );
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        filterChain.doFilter(request,response ) ;
    }
}
