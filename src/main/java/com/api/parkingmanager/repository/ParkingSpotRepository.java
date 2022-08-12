package com.api.parkingmanager.repository;

import com.api.parkingmanager.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * The interface Parking spot repository.
 */
@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

  /**
   * Exists by license plate car boolean.
   *
   * @param licensePlateCar the license plate car
   * @return the boolean
   */
  boolean existsByLicensePlateCar(String licensePlateCar);

  /**
   * Exists by parking spot number boolean.
   *
   * @param parkingSpotNumber the parking spot number
   * @return the boolean
   */
  boolean existsByParkingSpotNumber(String parkingSpotNumber);

  /**
   * Exists by apartment and block boolean.
   *
   * @param apartment the apartment
   * @param block     the block
   * @return the boolean
   */
  boolean existsByApartmentAndBlock(String apartment, String block);
}
