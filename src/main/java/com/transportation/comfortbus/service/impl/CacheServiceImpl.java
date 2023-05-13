package com.transportation.comfortbus.service.impl;

import com.transportation.comfortbus.exception.SystemException;
import com.transportation.comfortbus.exception.code.ServiceErrorCode;
import com.transportation.comfortbus.service.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CacheServiceImpl implements CacheService {

    private final CacheManager cacheManager;

    @Override
    public String clearCacheByCacheName(String cacheName) {
        Optional.ofNullable(cacheManager.getCache(cacheName))
                .orElseThrow(() -> new SystemException("Invalid cache name", ServiceErrorCode.BAD_REQUEST))
                .clear();
        return cacheName;
    }

}
