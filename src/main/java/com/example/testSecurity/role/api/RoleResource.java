package com.example.testSecurity.role.api;

import com.example.testSecurity.role.domain.Role;
import com.example.testSecurity.user.domain.User;
import com.example.testSecurity.user.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoleResource {
    private final UserService userService;

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveUser(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
         userService.addRoleToUser(form.getUserName(),form.getRoleName());
         return ResponseEntity.ok().build();
    }
    @GetMapping("/role/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response){
        String authorizationHeader = request.getHeader(AUTHORIZATION);
    }

    @Data
    class RoleToUserForm{
        String userName;
        String roleName;
    }
}
