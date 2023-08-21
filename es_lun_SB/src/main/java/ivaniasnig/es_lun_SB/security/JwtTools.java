package ivaniasnig.es_lun_SB.security;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import ivaniasnig.es_lun_SB.exceptions.UnauthorizedException;
import ivaniasnig.es_lun_SB.utenti.Utente;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class JwtTools {
	
	@Value("${spring.jwt.secret}")
	private String secret; //ho messo 32 alfanumerifici nel properties
	
	public String createToken(Utente utente) {
		String token = Jwts.builder().setSubject(utente.getId().toString()) //utente a cui appartiene il token
						.setIssuedAt(new Date(System.currentTimeMillis())) //iat del payload
						.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) //un giorno
						.signWith(Keys.hmacShaKeyFor(secret.getBytes())) //terza parte del token (firma)
						.compact(); //creazione token
		return token;
	}
	
	public void verifyToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parse(token);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new UnauthorizedException("Token non valido");
		}
	}
	
	public String extractSubject(String token) {
		return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJws(token).getBody().getSubject();
	}
	
}
