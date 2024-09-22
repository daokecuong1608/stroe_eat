package sv.cuong.store_eat.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtilHelper {

    @Value("${jwt.privateKey}")
    private String jwtPrivateKey;

    public String generateToken(String data) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtPrivateKey));
        String jwts = Jwts.builder().setSubject(data).signWith(key).compact();
        return jwts;

    }

}