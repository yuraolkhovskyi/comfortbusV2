package com.transportation.comfortbus.service.impl;

import com.transportation.comfortbus.service.CoordinatesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class CoordinatesServiceImpl implements CoordinatesService {

    @Override
    public String getCoordinatesByRideId(UUID rideId) {
        return "51.17147515070316, 23.12486648718846";
    }
}
