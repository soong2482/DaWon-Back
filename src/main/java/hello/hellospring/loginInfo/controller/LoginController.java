package hello.hellospring.loginInfo.controller;

import hello.hellospring.loginInfo.domain.LoginRequest;
import hello.hellospring.loginInfo.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("${DaWonCar.backEndPoint}/AdminLogin")
    public ResponseEntity<Void> login(@RequestBody(required = false) LoginRequest loginRequest, HttpServletResponse response, HttpServletRequest request) {
        if (loginRequest == null) {
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("user") != null) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        loginService.Login(loginRequest, response, request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("${DaWonCar.backEndPoint}/AdminLogout")
    public ResponseEntity<Void> logout(HttpServletRequest  request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok().build();
    }


}