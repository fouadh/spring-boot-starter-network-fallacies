package com.example.springamqp.sync;

import com.example.springamqp.common.ExternalService;
import com.example.springamqp.common.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SyncService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SyncService.class);
    private final Repository repository;
    private final ExternalService externalService;

    public SyncService(Repository repository, ExternalService externalService) {
        this.repository = repository;
        this.externalService = externalService;
    }

    public void save(final String id, final String value) {
        LOGGER.info(">> save {}, {}", id, value);
        this.repository.save(id, value);
        this.externalService.save(id, value);
    }
}
