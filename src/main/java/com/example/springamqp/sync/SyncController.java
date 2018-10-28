package com.example.springamqp.sync;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sync")
public class SyncController {
    private final SyncService syncService;

    public SyncController(final SyncService syncService) {
        this.syncService = syncService;
    }

    @PutMapping("/{id}")
    public void save(@PathVariable final String id, @RequestParam final String value) {
        syncService.save(id, value);
    }
}
