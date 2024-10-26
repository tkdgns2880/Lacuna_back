package LacunaMatata.Lacuna.controller;

import LacunaMatata.Lacuna.aspect.annotation.user.AuthAop;
import LacunaMatata.Lacuna.dto.request.user.auth.ReqAccessTokenDto;
import LacunaMatata.Lacuna.dto.request.user.auth.ReqGeneralSigninDto;
import LacunaMatata.Lacuna.dto.request.user.auth.ReqGeneralSignupDto;
import LacunaMatata.Lacuna.service.AuthService;
import LacunaMatata.Lacuna.service.TokenService;
import LacunaMatata.Lacuna.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@Api(tags = "AuthController")
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    /************************************
     * version: 1.0.3                   *
     * author: 손경태                    *
     * description: accessToken()       *
     * createDate: 2024-10-11           *
     * updateDate: 2024-10-11           *
     ***********************************/
    @GetMapping("/access")
    @ApiOperation(value = "accessTokenApi")
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
    @PostMapping("/signin")
    @ApiOperation(value = "signinApi")
    @AuthAop
    public ResponseEntity<?> signin(HttpServletRequest request, @RequestBody ReqGeneralSigninDto dto, BindingResult bindingResult) {
        String accessToken = authService.signin(request, dto);
        String bearerToken = "Bearer ".concat(accessToken);
        System.out.println(bindingResult);

        return ResponseEntity.ok().body(bearerToken);
    }

    /************************************
     * version: 1.0.4                   *
     * author: 손경태                    *
     * description: signup() -세팅       *
     * createDate: 2024-10-16           *
     * updateDate: 2024-10-16           *
     ***********************************/
    @PostMapping("/signup")
    @ApiOperation(value = "signupApi")
    @AuthAop
    public ResponseEntity<?> signup(@RequestBody ReqGeneralSignupDto dto, BindingResult bindingResult) {
        authService.signup(dto);
        return ResponseEntity.ok().body(null);
    }
}
