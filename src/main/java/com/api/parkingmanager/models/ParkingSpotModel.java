package com.api.parkingmanager.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type Parking spot model.
 */
@Entity
@Table(name= "TB_PM_SPOT")
public class ParkingSpotModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private UUID id;
  @Column (nullable = false, unique = true, length = 10)
  private String parkingSpotNumber;
  @Column(nullable = false, unique = true, length = 7)
  private String licensePlateCar;
  @Column(nullable = false, length = 70)
  private String brandCar;
  @Column(nullable = false, length = 70)
  private String modelCar;
  @Column(nullable = false, length = 70)
  private String colorCar;
  @Column(nullable = false)
  private LocalDateTime registrationDate;
  @Column(nullable = false, length = 130)
  private String responsibleName;
  @Column(nullable = false, length = 30)
  private String apartment;
  @Column(nullable = false, length = 30)
  private String block;

  /**
   * Gets id.
   *
   * @return the id
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * Gets parking spot number.
   *
   * @return the parking spot number
   */
  public String getParkingSpotNumber() {
    return parkingSpotNumber;
  }

  /**
   * Sets parking spot number.
   *
   * @param parkingSpotNumber the parking spot number
   */
  public void setParkingSpotNumber(String parkingSpotNumber) {
    this.parkingSpotNumber = parkingSpotNumber;
  }

  /**
   * Gets license plate car.
   *
   * @return the license plate car
   */
  public String getLicensePlateCar() {
    return licensePlateCar;
  }

  /**
   * Sets license plate car.
   *
   * @param licensePlateCar the license plate car
   */
  public void setLicensePlateCar(String licensePlateCar) {
    this.licensePlateCar = licensePlateCar;
  }

  /**
   * Gets brand car.
   *
   * @return the brand car
   */
  public String getBrandCar() {
    return brandCar;
  }

  /**
   * Sets brand car.
   *
   * @param brandCar the brand car
   */
  public void setBrandCar(String brandCar) {
    this.brandCar = brandCar;
  }

  /**
   * Gets model car.
   *
   * @return the model car
   */
  public String getModelCar() {
    return modelCar;
  }

  /**
   * Sets model car.
   *
   * @param modelCar the model car
   */
  public void setModelCar(String modelCar) {
    this.modelCar = modelCar;
  }

  /**
   * Gets color car.
   *
   * @return the color car
   */
  public String getColorCar() {
    return colorCar;
  }

  /**
   * Sets color car.
   *
   * @param colorCar the color car
   */
  public void setColorCar(String colorCar) {
    this.colorCar = colorCar;
  }

  /**
   * Gets registration date.
   *
   * @return the registration date
   */
  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  /**
   * Sets registration date.
   *
   * @param registrationDate the registration date
   */
  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }

  /**
   * Gets responsible name.
   *
   * @return the responsible name
   */
  public String getResponsibleName() {
    return responsibleName;
  }

  /**
   * Sets responsible name.
   *
   * @param responsibleName the responsible name
   */
  public void setResponsibleName(String responsibleName) {
    this.responsibleName = responsibleName;
  }

  /**
   * Gets apartment.
   *
   * @return the apartment
   */
  public String getApartment() {
    return apartment;
  }

  /**
   * Sets apartment.
   *
   * @param apartment the apartment
   */
  public void setApartment(String apartment) {
    this.apartment = apartment;
  }

  /**
   * Gets block.
   *
   * @return the block
   */
  public String getBlock() {
    return block;
  }

  /**
   * Sets block.
   *
   * @param block the block
   */
  public void setBlock(String block) {
    this.block = block;
  }
}
