package com.lopan.hiscoreApi.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class HealthCheckController {

    @GetMapping
    public String checkIfItsUp() {
        return "I'm still alive...";
    }

}
