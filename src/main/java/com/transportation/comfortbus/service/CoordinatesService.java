package com.transportation.comfortbus.service;

import java.util.UUID;

public interface CoordinatesService {

    String getCoordinatesByRideId(final UUID rideId);

}
