package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LogoutController {

	@PostMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false); // non creare una nuova sessione

        if (session != null) {
            session.invalidate(); // invalida la sessione
        }

        return "Logout eseguito e sessione invalidata";
    }
}