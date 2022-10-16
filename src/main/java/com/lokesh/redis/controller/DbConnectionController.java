package com.lokesh.redis.controller;

import com.lokesh.redis.entity.DbConnection;
import com.lokesh.redis.model.DbConnectionWrapper;
import com.lokesh.redis.service.DbConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dbConnection")
@EnableCaching
public class DbConnectionController {

    @Autowired
    private DbConnectionService dbConnectionService;

    @PostMapping
    public DbConnectionWrapper create(@RequestBody DbConnection dbConnection) {
        return DbConnectionWrapper.builder()
                .dbConnection(dbConnectionService.create(dbConnection))
                .build();
    }

    @GetMapping("/{id}")
    public DbConnectionWrapper getById(@PathVariable("id") Long id) {
        return DbConnectionWrapper.builder()
                .dbConnection(dbConnectionService.getById(id))
                .build();
    }

    @GetMapping
    public DbConnectionWrapper getAll() {
        return DbConnectionWrapper.builder()
                .dbConnections(dbConnectionService.getAll())
                .build();
    }

    @DeleteMapping("/{id}")
    public DbConnectionWrapper deleteById(@PathVariable("id") Long id) {
        dbConnectionService.deleteById(id);
        return DbConnectionWrapper.builder()
                .dbConnections(dbConnectionService.getAll())
                .build();
    }

}