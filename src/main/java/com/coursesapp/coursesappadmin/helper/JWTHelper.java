package com.coursesapp.coursesappadmin.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.coursesapp.coursesappadmin.constant.JWTUtil.*;

//    This class is used to generate JWT tokens and extract the tokens from the request header.
@Component
public class JWTHelper {

//   The JWT tokens are signed with the HS256 algorithm and the secret key is used to
    Algorithm algorithm = Algorithm.HMAC256(SECRET);


//    The generateAccessToken() method generates an access token with the user's email and roles.
    public String generateAccessToken(String email, List<String> roles) {
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_ACCESS_TOKEN))
                .withIssuer(ISSUER)
                .withClaim("roles", roles)
                .sign(algorithm);
    }

//    The generateRefreshToken() method generates a refresh token with the user's email.
    public String generateRefreshToken(String email) {
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_REFRESH_TOKEN))
                .withIssuer(ISSUER)
                .sign(algorithm);
    }

//    This method verifies that the token starts with the Bearer prefix, not null and then extracts the token from the request header.
    public String extractTokenFromHeaderIfExists(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_PREFIX)) {
            return authorizationHeader.substring(BEARER_PREFIX.length());
        }
        return null;
    }

//    This method returns a map of the access token and refresh token to send back to the client.
    public Map<String, String> getTokensMap(String jwtAccessToken, String jwtRefreshToken) {
        Map<String, String> idTokens = new HashMap<>();
        idTokens.put("accessToken", jwtAccessToken);
        idTokens.put("refreshToken", jwtRefreshToken);
        return idTokens;
    }
}
