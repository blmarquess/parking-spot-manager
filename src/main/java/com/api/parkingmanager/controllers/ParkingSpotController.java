package com.api.parkingmanager.controllers;

import com.api.parkingmanager.dtos.ParkingSpotDTO;
import com.api.parkingmanager.models.ParkingSpotModel;
import com.api.parkingmanager.services.ParkingSpotService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * The type Parking spot controller.
 */
@RestController
@CrossOrigin (origins = "*", maxAge = 3600)
@RequestMapping ("/parking-spot")
public class ParkingSpotController {

  /**
   * The Parking spot service.
   */
  final ParkingSpotService parkingSpotService;

  /**
   * Instantiates a new Parking spot controller.
   *
   * @param parkingSpotService the parking spot service
   */
  public ParkingSpotController(ParkingSpotService parkingSpotService) {
    this.parkingSpotService = parkingSpotService;
  }

  /**
   * Save parking spot response entity.
   *
   * @param parkingSpotDTO the parking spot dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {
    if (parkingSpotService.existsByLicensePlateCar(parkingSpotDTO.getLicensePlateCar())) {
      return ResponseEntity
          .status(HttpStatus.CONFLICT)
          .body("Conflict: License Plate Car is already in use!");
    }
    if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber())) {
      return ResponseEntity
          .status(HttpStatus.CONFLICT)
          .body("Conflict: Parking Spot is already in use!");
    }
    if (parkingSpotService
        .existsByApartmentAndBlock(parkingSpotDTO.getApartment(), parkingSpotDTO.getBlock())) {
      return ResponseEntity
          .status(HttpStatus.CONFLICT)
          .body("Conflict: Parking Spot already registered for this apartment/block!");
    }

    var parkingSpotModel = new ParkingSpotModel();
    BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
    parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
    return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
  }

  /**
   * Gets all parking spots.
   *
   * @param pageable the pageable
   * @return the all parking spots
   */
  @GetMapping
  public ResponseEntity<Page<ParkingSpotModel>> getAllParkingSpots(@PageableDefault (
      page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
    return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
  }

  /**
   * Gets one parking spot.
   *
   * @param id the id
   * @return the one parking spot
   */
  @GetMapping ("/{id}")
  public ResponseEntity<Object> getOneParkingSpot(@PathVariable (value = "id") UUID id) {
    Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
    return parkingSpotModelOptional.<ResponseEntity<Object>>map(
            parkingSpotModel -> ResponseEntity
                .status(HttpStatus.OK)
                .body(parkingSpotModel))
        .orElseGet(() -> ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Parking Spot not found."));
  }

  /**
   * Delete parking spot response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @DeleteMapping ("/{id}")
  public ResponseEntity<Object> deleteParkingSpot(@PathVariable (value = "id") UUID id) {
    Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
    if (parkingSpotModelOptional.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
    }
    parkingSpotService.delete(parkingSpotModelOptional.get());
    return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
  }

  /**
   * Update parking spot response entity.
   *
   * @param id             the id
   * @param parkingSpotDto the parking spot dto
   * @return the response entity
   */
  @PutMapping ("/{id}")
  public ResponseEntity<Object> updateParkingSpot(@PathVariable (value = "id") UUID id,
                                                  @RequestBody @Valid ParkingSpotDTO parkingSpotDto) {
    Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
    if (parkingSpotModelOptional.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
    }
    var parkingSpotModel = new ParkingSpotModel();
    BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
    parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
    parkingSpotModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());
    return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
  }
}
