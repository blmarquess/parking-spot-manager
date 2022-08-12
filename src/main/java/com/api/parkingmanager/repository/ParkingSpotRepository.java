package com.api.parkingmanager.repository;

import com.api.parkingmanager.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

  boolean existsByLicensePlateCar(String licensePlateCar);
  boolean existsByParkingSpotNumber(String parkingSpotNumber);
  boolean existsByApartmentAndBlock(String apartment, String block);
}
