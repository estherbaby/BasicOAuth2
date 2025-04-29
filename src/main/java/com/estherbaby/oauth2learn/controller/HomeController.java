package com.estherbaby.oauth2learn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal OAuth2User principal) {
    	//This is defensive programming: rarely needed, because Spring Security usually 
    	//ensures the user is authenticated before injecting OAuth2User.
        if (principal != null) {
            return "Hello, " + principal.getAttribute("name");
        } else {
            return "Hello, Guest!";
        }
    }
    

    @GetMapping("/secured")
    public String secured() {
        return "This is a secured page. You are authenticated!";
    }
    
    @GetMapping("/logout-link")
    public String logoutLink() {
        return "<a href='/logout'>Logout</a>";
    }
    
    @GetMapping("/whoami")
    public ResponseEntity<String> whoami(
    	    @AuthenticationPrincipal OAuth2User principal,
    	    HttpServletRequest request
    	) {
    	    // optional: redirect if "?continue" is present
    	    if (request.getQueryString() != null && request.getQueryString().contains("continue")) {
    	        return ResponseEntity.status(HttpStatus.FOUND)
    	            .header("Location", "/whoami")
    	            .build();
    	    }

    	    return ResponseEntity.ok(
    	        principal == null ? "You are logged out!" : "Logged in as: " + principal.getAttribute("name")
    	    );
    	}

}
