package com.api.parkingmanager.repository;

import com.api.parkingmanager.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public class ParkingSpotRepository implements JpaRepository<ParkingSpotModel, UUID> {

}
