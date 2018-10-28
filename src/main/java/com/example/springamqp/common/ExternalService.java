package com.example.springamqp.common;

import com.fha.nf.NetworkFailure;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExternalService {
    private final Map<String, String> store = new HashMap<>();

    public String findById(final String id) {
        return store.get(id);
    }

    //@NetworkFailure(odds = 2)
    public void save(String id, String value) {
        store.put(id, "crem-" + value);
    }
}
