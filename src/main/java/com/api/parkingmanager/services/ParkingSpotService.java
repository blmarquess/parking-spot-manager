package com.api.parkingmanager.services;

import com.api.parkingmanager.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {
  final ParkingSpotRepository parkingSpotRepository;

  public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    this.parkingSpotRepository = parkingSpotRepository;
  }


}
