package LacunaMatata.Lacuna.controller;

import LacunaMatata.Lacuna.dto.request.ReqAccessTokenDto;
import LacunaMatata.Lacuna.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    /************************************
     * version: 1.0.3                   *
     * author: 손경태                    *
     * description: accessToken()       *
     * createDate: 2024-10-11           *
     * updateDate: 2024-10-11           *
     ***********************************/
    @GetMapping("/access")
    ResponseEntity<?> accessToken(ReqAccessTokenDto dto) {
        tokenService.isValidToken(dto.getAccessToken());
        return ResponseEntity.ok().body(true);
    }

    /************************************
     * version: 1.0.4                   *
     * author: 손경태                    *
     * description: signin() -세팅       *
     * createDate: 2024-10-16           *
     * updateDate: 2024-10-16           *
     ***********************************/
    @PostMapping("/login")
    public ResponseEntity<?> signin() {
        return ResponseEntity.ok().body(null);
    }

    /************************************
     * version: 1.0.4                   *
     * author: 손경태                    *
     * description: signup() -세팅       *
     * createDate: 2024-10-16           *
     * updateDate: 2024-10-16           *
     ***********************************/
    @PostMapping("/join")
    public ResponseEntity<?> signup() {
        return ResponseEntity.ok().body(null);
    }
}
