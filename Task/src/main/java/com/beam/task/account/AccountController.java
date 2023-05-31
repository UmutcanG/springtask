package com.beam.task.account;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/signup")
    public String signup(@RequestBody Account account,
                         HttpSession session) {
        if (account != null) {
            session.setAttribute("account",account);
        }
        assert account != null;
        accountService.signup(account);
        return "Signed";
    }


    @PostMapping("/login")
    public Account login(@RequestBody Account account,
                        HttpServletResponse response) {
        Account acc = accountService.login(account);
        Cookie cookie = new Cookie("cookie", acc.getId());
        response.addCookie(cookie);
        return acc;
    }
    @GetMapping("/allUser")
    public List<Account> getAllUser() {
        return accountService.getAllUser();
    }
}