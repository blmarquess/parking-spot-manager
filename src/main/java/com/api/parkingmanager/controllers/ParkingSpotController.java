package com.api.parkingmanager.controllers;

import com.api.parkingmanager.dtos.ParkingSpotDTO;
import com.api.parkingmanager.models.ParkingSpotModel;
import com.api.parkingmanager.services.ParkingSpotService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin (origins = "*", maxAge = 3600)
@RequestMapping ("/parking-spot")
public class ParkingSpotController {

  final ParkingSpotService parkingSpotService;

  public ParkingSpotController(ParkingSpotService parkingSpotService) {
    this.parkingSpotService = parkingSpotService;
  }

  @PostMapping
  public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {
    if (parkingSpotService.existsByLicensePlateCar(parkingSpotDTO.getLicensePlateCar())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
    }
    if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
    }
    if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDTO.getApartment(), parkingSpotDTO.getBlock())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
    }

    var parkingSpotModel = new ParkingSpotModel();
    BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
    parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
    return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
  }
}
