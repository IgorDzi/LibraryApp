package lib.edu.libraryapp.service.auth;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lib.edu.libraryapp.commonTypes.UserRole;
import lib.edu.libraryapp.infrastructure.entity.AuthEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * The type Jwt service.
 */
@Service
public class JwtService {

    @Value("${token.signing.key}")
    private String  jwtSigningKey;

    /**
     * Generate token string.
     *
     * @param userDetail the user detail
     * @return the string
     */
    public String generateToken(AuthEntity userDetail){
        return generateToken(new HashMap<>(), userDetail);
    }

    /**
     * Extract role user role.
     *
     * @param token the token
     * @return the user role
     */
    public UserRole extractRole(String token){
        String roleString = extractClaim(token, (claims)-> claims.get("role", String.class));
        return UserRole.valueOf(roleString);
    }

    /**
     * Is token valid boolean.
     *
     * @param token the token
     * @return the boolean
     */
    public boolean isTokenValid(String token){
        try {
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Extract username string.
     *
     * @param token the token
     * @return the string
     */
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token){
       return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims =  extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
    }

    private String generateToken(Map<String, Object> extraClaims, AuthEntity userDetails){
        extraClaims.put("role", userDetails.getRole());
        long tokenLifetime = 1000 * 60 * 24;
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + tokenLifetime))
                .signWith(getSigningKey())
                .compact();

    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
