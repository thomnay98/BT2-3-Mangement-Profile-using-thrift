/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author thom
 */
public class HandleJWTsCookie {
    private static final String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

    private static final Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), 
                            SignatureAlgorithm.HS256.getJcaName());
    
    private final Instant now = Instant.now();
    
    public HandleJWTsCookie () {}
    
    public String encryptCookie(String email, String pass){
        String jwtToken = null;
        
        jwtToken = Jwts.builder()
        .claim("email", email)
        .claim("password", pass)
        .setId(UUID.randomUUID().toString())
        .setIssuedAt(Date.from(now))
        .setExpiration(Date.from(now.plus(10l, ChronoUnit.MINUTES)))
        .signWith(hmacKey)
        .compact();
        
        return jwtToken;
    }
    
    public Jws<Claims> parseJwt(String jwtString) {
        
        Jws<Claims> jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(jwtString);
        
        return jwt;
    }
}
