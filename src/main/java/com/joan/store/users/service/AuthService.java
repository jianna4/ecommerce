package com.joan.store.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.joan.store.users.authdto.AuthResponseDto;
import com.joan.store.users.authdto.LoginRequestDto;
import com.joan.store.users.authdto.LoginResponceDto;
import com.joan.store.users.authdto.RegisterRequestDto;
import com.joan.store.users.entity.Role;
import com.joan.store.users.entity.User;
import com.joan.store.users.repository.RoleRepository;
import com.joan.store.users.repository.UserRepository;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    AuthService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public AuthResponseDto register(RegisterRequestDto registerRequestDto){

        if (userRepository.existsByEmail(registerRequestDto.getEmail())) {
         throw new RuntimeException("Email already exists");
        }
        
        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(()-> new RuntimeException("role not found"));
        User user = new User();
        user.getRoles().add(role);
        user.setFirstName(registerRequestDto.getFirstName());
        user.setLastName(registerRequestDto.getLastName());
        user.setEmail(registerRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode( registerRequestDto.getPassword()));
       
        userRepository.save(user);
        
        AuthResponseDto response = new AuthResponseDto();

        response.setToken(null);
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setRole(role.getName());
        response.setUserId(user.getId());

        return response;
    }

   
    public LoginResponceDto Login(LoginRequestDto loginRequestDto){

    }

    public void Logout(){
        
    }

}
