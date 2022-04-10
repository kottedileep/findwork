package com.fwork.controllers;
import com.fwork.model.Freelancer;
import com.fwork.model.JwtRequest;
import com.fwork.model.JwtResponse;
import com.fwork.services.FreelancerService;
import com.fwork.services.UserService;
import com.fwork.utility.JWTUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    FreelancerService freelancerservice;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<Freelancer>  addFreelance(@RequestBody Freelancer freelance) {
	Freelancer user= freelancerservice.addFreelancer(freelance);
	 HttpHeaders headers=new HttpHeaders();
	 headers.add("desc", "Freelancer Added successfully");
	 return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(user);
}

    @PostMapping(value = "/login" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }
}
