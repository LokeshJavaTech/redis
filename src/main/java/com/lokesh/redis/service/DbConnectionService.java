package com.lokesh.redis.service;

import com.lokesh.redis.entity.DbConnection;
import com.lokesh.redis.repository.DbConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*
@CacheConfig(cacheNames = {"Cache-Connection"})
For logical separation within caching mechanism. All key names of this class with be like: Cache-Connection::key
*/
public class DbConnectionService {

    @Autowired
    private DbConnectionRepository dbConnectionRepository;

    public DbConnection create(DbConnection dbConnection) {
        return dbConnectionRepository.save(dbConnection);
    }

    /*
    * It will generate key : for id 5 :     Cache-Connection::Connection_5
    * Check all keys                  :     keys *
    * Get value of above key          :     get Cache-Connection::Connection_5
    *
    * Don't cache key whose results.name value is test
    */

    @Cacheable( key = "'Connection_'+#id",
                value = "Cache-Connection",
                unless = "#result.name == 'test'"
    )
    public DbConnection getById(Long id) {
        System.out.println("Hitting DB to get by id.");
        return dbConnectionRepository.getById(id);
    }

    public List<DbConnection> getAll() {
        return dbConnectionRepository.findAll();
    }

    /*
    * Delete key from cache as it is delete from my database
    */

    @CacheEvict( key = "'Connection_'+#id",
                value = "Cache-Connection"
    )
    public void deleteById(Long id) {
        dbConnectionRepository.deleteById(id);
    }
}
