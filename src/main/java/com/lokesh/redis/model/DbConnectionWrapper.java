package com.lokesh.redis.model;

import com.lokesh.redis.entity.DbConnection;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class DbConnectionWrapper {
    private DbConnection dbConnection;
    private List<DbConnection> dbConnections;
}
