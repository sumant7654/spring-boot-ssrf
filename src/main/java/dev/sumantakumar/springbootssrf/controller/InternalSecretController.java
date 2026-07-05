package dev.sumantakumar.springbootssrf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InternalSecretController {
    // Assume -> Spring Security is implemented for this API to prevent direct access
    @GetMapping("/internal/secrets")
    public Map<String, String> secrets(){
        return Map.of(
                "gcp_access_key", "GCP_TEST_ACCESS_KEY",
                "db_password", "DB_TEST_PASSWORD"
        );
    }
}
