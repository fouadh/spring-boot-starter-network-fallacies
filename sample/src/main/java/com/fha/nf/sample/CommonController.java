package com.fha.nf.sample;

import com.fha.nf.NetworkFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class CommonController {
  private final Database repository;

  public CommonController(Database repository) {
    this.repository = repository;
  }

  @GetMapping("/{id}")
  public String findById(@PathVariable final String id) {
    return repository.findById(id);
  }

  @PutMapping("/{id}")
  public void save(@PathVariable final String id, @RequestParam final String value) {
    repository.save(id, value);
  }

  @ExceptionHandler(NetworkFailureException.class)
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  public String onNetworkFailure() {
    return "NETWORK FAILURE";
  }
}
