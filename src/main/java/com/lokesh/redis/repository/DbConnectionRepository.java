package com.lokesh.redis.repository;

import com.lokesh.redis.entity.DbConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DbConnectionRepository extends JpaRepository<DbConnection, Long> {

    @Query("FROM DbConnection WHERE name = :name")
    Optional<DbConnection> getByName(@Param("name") String name);

}
