package com.shavemax.shavemax.restcontroller;

import com.shavemax.shavemax.aspect.ValidateToken;
import com.shavemax.shavemax.enums.RoleEnum;
import com.shavemax.shavemax.repository.RoleRepository;
import com.shavemax.shavemax.service.AuthService;
import com.shavemax.shavemax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final AuthService authService;

    @Autowired
    public UserRestController(UserService userService, RoleRepository roleRepository, AuthService authService) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.authService = authService;
    }

    @GetMapping("/u")
    @ValidateToken(RoleEnum.USER)
    public ResponseEntity<?> userOnly() {
        return ResponseEntity.ok("Only accessible for users");
    }

    @GetMapping("/a")
    @ValidateToken(RoleEnum.ADMIN)
    public ResponseEntity<?> adminOnly() {
        return ResponseEntity.ok("Only accessible for admins");
    }

    @GetMapping("/ua")
    @ValidateToken({RoleEnum.USER,RoleEnum.ADMIN})
    public ResponseEntity<?> userAndAdmin() {
        return ResponseEntity.ok("Accessible for both users and admins");
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok("Accessible for unauthenticated users");
    }


}
