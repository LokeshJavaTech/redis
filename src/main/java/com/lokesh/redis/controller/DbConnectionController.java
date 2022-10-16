package com.lokesh.redis.controller;

import com.lokesh.redis.entity.DbConnection;
import com.lokesh.redis.model.DbConnectionWrapper;
import com.lokesh.redis.service.DbConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dbConnection")
public class DbConnectionController {

    @Autowired
    private DbConnectionService dbConnectionService;

    @PostMapping
    public DbConnectionWrapper create(@RequestBody DbConnection dbConnection) {
        return DbConnectionWrapper.builder()
                .dbConnection(dbConnectionService.create(dbConnection))
                .build();
    }

    @GetMapping("/{name}")
    public DbConnectionWrapper getByName(@PathVariable("name") String name) {
        return DbConnectionWrapper.builder()
                .dbConnections(dbConnectionService.getByName(name))
                .build();
    }

}