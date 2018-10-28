package com.example.springamqp.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stores")
public class CommonController {
    private final ExternalService externalService;
    private final Repository repository;

    public CommonController(ExternalService externalService, Repository repository) {
        this.externalService = externalService;
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Map<String, String> findById(@PathVariable final String id) {
        Map<String, String> values = new HashMap<>();
        values.put("repository", repository.findById(id));
        values.put("external-service", externalService.findById(id));

        return values;
    }
}
