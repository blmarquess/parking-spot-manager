package com.api.parkingmanager.services;

import com.api.parkingmanager.models.ParkingSpotModel;
import com.api.parkingmanager.repository.ParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

/**
 * The type Parking spot service.
 */
@Service
public class ParkingSpotService {
  /**
   * The Parking spot repository.
   */
  final ParkingSpotRepository parkingSpotRepository;

  /**
   * Instantiates a new Parking spot service.
   *
   * @param parkingSpotRepository the parking spot repository
   */
  public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    this.parkingSpotRepository = parkingSpotRepository;
  }

  /**
   * Save parking spot model.
   *
   * @param parkingSpotModel the parking spot model
   * @return the parking spot model
   */
  @Transactional
  public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
    return parkingSpotRepository.save(parkingSpotModel);
  }

  /**
   * Exists by license plate car boolean.
   *
   * @param licensePlateCar the license plate car
   * @return the boolean
   */
  public boolean existsByLicensePlateCar(String licensePlateCar) {
    return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
  }

  /**
   * Exists by parking spot number boolean.
   *
   * @param parkingSpotNumber the parking spot number
   * @return the boolean
   */
  public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
    return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
  }

  /**
   * Exists by apartment and block boolean.
   *
   * @param apartment the apartment
   * @param block     the block
   * @return the boolean
   */
  public boolean existsByApartmentAndBlock(String apartment, String block) {
    return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
  }

  /**
   * Find all page.
   *
   * @param pageable the pageable
   * @return the page
   */
  public Page<ParkingSpotModel> findAll(Pageable pageable) {
    return parkingSpotRepository.findAll(pageable);
  }

  /**
   * Find by id optional.
   *
   * @param id the id
   * @return the optional
   */
  public Optional<ParkingSpotModel> findById(UUID id) {
    return parkingSpotRepository.findById(id);
  }

  /**
   * Delete.
   *
   * @param parkingSpotModel the parking spot model
   */
  @Transactional
  public void delete(ParkingSpotModel parkingSpotModel) {
    parkingSpotRepository.delete(parkingSpotModel);
  }
}
