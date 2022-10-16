package com.lokesh.redis.service;

import com.lokesh.redis.entity.DbConnection;
import com.lokesh.redis.repository.DbConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbConnectionService {

    @Autowired
    private DbConnectionRepository dbConnectionRepository;

    public DbConnection create(DbConnection dbConnection) {
        return dbConnectionRepository.save(dbConnection);
    }

    public DbConnection getByName(String name) {
        return dbConnectionRepository.getByName(name)
                .orElse(null);
    }

}
