package LacunaMatata.Lacuna.controller;

import LacunaMatata.Lacuna.security.jwt.JwtProvider;
import LacunaMatata.Lacuna.service.TokenService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/************************************
 * version: 1.0.0                   *
 * author: 권오광                    *
 * description: TestController      *
 * createDate: 2024-10-07           *
 * updateDate: 2024-10-07           *
 ***********************************/
@Slf4j
@Api(tags = {"Controller 이름"})
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "Test API")
    @GetMapping("/test")
    public ResponseEntity<?> access() {
        String accessToken = jwtProvider.generateAccessToken(1, 2);
        log.info("{}", accessToken);
        Claims claims = jwtProvider.getClaim(accessToken);
        Long userId = ((Integer) claims.get("userId")).longValue();
        log.info("{}", userId);
        return ResponseEntity.ok().body(null);
    }

//    @ApiOperation(value = "Test API")
//    @GetMapping("/auth/access")
//    public ResponseEntity<?> access2(ReqAccessTokenDto dto) {
//        String accessToken = jwtProvider.generateAccessToken(1);
//        String bearerToken = "Bearer ".concat(accessToken);
//        System.out.println(bearerToken);
//
//        tokenService.isValidToken(bearerToken);
//        return ResponseEntity.ok().body(true);
//    }

}