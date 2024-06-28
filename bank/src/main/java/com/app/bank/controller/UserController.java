package com.app.bank.controller;

import com.app.bank.utility.JwtTokenUtil;
import com.app.bank.entity.TokenReqRes;
import com.app.bank.entity.Users;
import com.app.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/accounts")
public class UserController {


    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired(required=true)
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody Users user){
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        if (userRepository.save(user).getId() > 0) {
            return ResponseEntity.ok("User Was Saved");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User Not Saved, Internal Server Error. Please Try Again");
    }

    @PostMapping("/generate-token")
    public ResponseEntity<Object> generateToken(@RequestBody TokenReqRes tokenReqRes){
        Users databaseUser = userRepository.findByUsername(tokenReqRes.getUsername());
        if (databaseUser == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sorry, User Does Not Exist");
        }
        if (new BCryptPasswordEncoder().matches(tokenReqRes.getPassword(), databaseUser.getPassword())){
            String token = jwtTokenUtil.generateToken(tokenReqRes.getUsername());
            tokenReqRes.setToken(token);
            tokenReqRes.setExpirationTime("60 Sec");
            return ResponseEntity.ok(tokenReqRes);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password Doesn't Match. Verify");
        }
    }
    @PostMapping("/validate-token")
    public ResponseEntity<Object> validateToken(@RequestBody TokenReqRes tokenReqRes){
        return ResponseEntity.ok(jwtTokenUtil.validateToken(tokenReqRes.getToken()));
    }

}
