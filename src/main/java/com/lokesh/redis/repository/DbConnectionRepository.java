package com.lokesh.redis.repository;

import com.lokesh.redis.entity.DbConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface DbConnectionRepository extends JpaRepository<DbConnection, Long> {

    @Query("FROM DbConnection WHERE id = :id")
    DbConnection getById(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM DbConnection WHERE id = :id")
    void deleteById(@Param("id") Long id);

}
