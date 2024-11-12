package LacunaMatata.Lacuna.controller;

import LacunaMatata.Lacuna.aspect.annotation.user.AuthAop;
import LacunaMatata.Lacuna.dto.request.user.auth.*;
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
import javax.servlet.http.HttpServletResponse;

/************************************
 * version: 1.0.3                   *
 * author: 손경태                    *
 * description: accessToken()       *
 * createDate: 2024-10-11           *
 * updateDate: 2024-11-05           *
 ***********************************/
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

    // 토큰 인증 요청
    @GetMapping("/access")
    @ApiOperation(value = "accessTokenApi")
    public ResponseEntity<?> accessToken(ReqAccessTokenDto dto) {
        tokenService.isValidToken(dto.getAccessToken());
        return ResponseEntity.ok().body(true);
    }

    // 일반 로그인
    @PostMapping("/signin")
    @ApiOperation(value = "signinApi")
    @AuthAop
    public ResponseEntity<?> signin(HttpServletRequest request, @RequestBody ReqGeneralSigninDto dto, BindingResult bindingResult) throws Exception {
        String accessToken = authService.signin(request, dto);
        String bearerToken = "Bearer ".concat(accessToken);
        System.out.println(bindingResult);

        return ResponseEntity.ok().body(bearerToken);
    }

    // 일반 회원가입
    @PostMapping("/signup")
    @ApiOperation(value = "signupApi")
    @AuthAop
    public ResponseEntity<?> signup(@RequestBody ReqGeneralSignupDto dto, BindingResult bindingResult) {
        authService.signup(dto);
        return ResponseEntity.ok().body(true);
    }

    // 오어스 회원가입
    @ApiOperation(value = "authSignupApi")
    @PostMapping("/oauth2user/signup")
    @AuthAop
    public ResponseEntity<?> oauthSignup(@RequestBody ReqOauthSignupDto dto, BindingResult bindingResult) {
        System.out.println(dto);
        authService.oauthSignup(dto);
        return ResponseEntity.ok().body(true);
    }

    // 회원가입 시 이메일 인증(인증 메일 보내기) 1
    @PostMapping("/email")
    @ApiOperation(value = "sendAuthEmailApi")
    public ResponseEntity<?> sendAuthEmail(@RequestBody ReqAuthEmailDto dto) {
        authService.sendAuthEmail(dto);
        return ResponseEntity.ok().body(true);
    }

    // 회원가입시 이메일 인증(토큰 받는곳) 2
    @GetMapping("/email")
    @ApiOperation(value = "emailValidApi")
    public Boolean emailValid(@RequestParam String emailtoken, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        String validResult = authService.validToken(emailtoken);

        if(validResult.equals("validFail")) {
            response.getWriter().println(errorView("인증시간이 만료되었습니다. 다시 시도해 주세요"));
            throw new Exception("인증 시간 만료");
        }
        response.getWriter().println(successView());
        return true;
    }

    private String successView() {
        StringBuilder sb = new StringBuilder();

        sb.append("<html>");
        sb.append("<body>");
        sb.append("<script>");
        sb.append("alert('인증이 완료되었습니다');");
        sb.append("</script>");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    private String errorView(String message) {
        StringBuilder sb = new StringBuilder();

        sb.append("<html>");
        sb.append("<body>");
        sb.append("<div style=\"text-align:center;\">");
        sb.append("<h2>");
        sb.append(message);
        sb.append("</h2>");
        // onclick 소문자로 해야함
        sb.append("<button onclick='window.close()'>닫기</button>");
        sb.append("</div>");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    // 사용자 아이디 찾기
    @PostMapping("/find/id")
    @ApiOperation(value = "findUsernameApi")
    public ResponseEntity<?> findUsername(@RequestBody ReqFindUsernameDto dto) throws Exception {
        authService.findUsername(dto);
        return ResponseEntity.ok().body(true);
    }

    // 사용자 비밀번호 찾기
    @PostMapping("/find/password")
    @ApiOperation(value = "findPasswordApi")
    public ResponseEntity<?> findPassword(@RequestBody ReqFindPasswordDto dto) throws Exception {
        authService.findPassword(dto);
        return ResponseEntity.ok().body(true);
    }
}
