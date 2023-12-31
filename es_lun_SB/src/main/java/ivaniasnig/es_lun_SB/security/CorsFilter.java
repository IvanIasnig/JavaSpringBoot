package ivaniasnig.es_lun_SB.security;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, java.io.IOException {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3002");
        response.setHeader("Access-Control-Allow-Methods", "");
        response.setHeader("Access-Control-Allow-Headers", "");
        response.setHeader("Access-Control-Allow-Max-Age", "3600");

        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }

    }

}
