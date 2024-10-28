package LacunaMatata.Lacuna.controller.user;

import LacunaMatata.Lacuna.dto.response.user.user.RespMyProfileDto;
import LacunaMatata.Lacuna.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Api(tags = {"userController"})
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "getMyProfile")
    @GetMapping("/profile")
    public ResponseEntity<?> getMyProfile() {
        RespMyProfileDto myProfile = userService.getMyProfile();
        return ResponseEntity.ok().body(myProfile);
    }
}
