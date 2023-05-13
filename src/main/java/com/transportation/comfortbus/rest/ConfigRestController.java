package com.transportation.comfortbus.rest;

import com.transportation.comfortbus.service.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/config")
public class ConfigRestController {

    private final CacheService cacheService;

    //admin
    @PostMapping(value = "/cache/{cacheName}/clear")
    public String clearCacheByCacheName(@PathVariable(value = "cacheName") String cacheName) {
        return cacheService.clearCacheByCacheName(cacheName);
    }

}
