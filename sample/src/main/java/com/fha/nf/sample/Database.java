package com.fha.nf.sample;

import com.fha.nf.NetworkFailure;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class Database {
  private final Map<String, String> store = new HashMap<>();

  public String findById(final String id) {
    return store.get(id);
  }

  @NetworkFailure(odds = 2)
  public void save(String id, String value) {
    store.put(id, value);
  }
}
