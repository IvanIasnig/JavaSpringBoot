package ivaniasnig.es_lun_SB.security;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.io.IOException;
import ivaniasnig.es_lun_SB.exceptions.UnauthorizedException;
import ivaniasnig.es_lun_SB.utenti.Utente;
import ivaniasnig.es_lun_SB.utenti.UtenteService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter{
	
	@Autowired
	JwtTools jwtTools;
	
	@Autowired
	UtenteService utentiService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, java.io.IOException{
			String authHeader = request.getHeader("Authorization"); 
			
			if(authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new UnauthorizedException("token non trovato");
			}
			String token = authHeader.substring(7);
			System.out.println("-------------------------TOKEN-------------------------------");
			System.out.println(token);
			
//			--------------------------------------------------------
//			eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0YTE4OGM4Ni1kNjEyLTQ2M2ItYTY4NS1hNzQ5MmRkM2VhNWMiLCJpYXQiOjE2OTExMTk0MDYsImV4cCI6MTY5MTIwNTgwNn0.xlfsWWLjUx0rNeoUg4Zm2Gdw_VFBScDGKkqWHJnUefw
//			/utenti
			
			jwtTools.verifyToken(token);
			
			//se non ho i ruoli quindi sta parte la posso saltare(?)s
			
			String id = jwtTools.extractSubject(token);
			Utente utenteCorrente = utentiService.findById(UUID.fromString(id));
			
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken (utenteCorrente, null, utenteCorrente.getAuthorities()); //ATTEZIONEEEE
			SecurityContextHolder.getContext().setAuthentication(authToken);
			
			filterChain.doFilter(request, response);
		}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		System.out.println(request.getServletPath());
		System.out.println("*********************************************");

		return new AntPathMatcher().match("/auth/**", request.getServletPath());
	}
		
}
