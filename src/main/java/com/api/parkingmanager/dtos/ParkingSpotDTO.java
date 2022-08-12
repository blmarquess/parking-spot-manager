package com.api.parkingmanager.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * The type Parking spot dto.
 */
public class ParkingSpotDTO {

  @NotBlank
  private String parkingSpotNumber;
  @NotBlank
  @Size(max = 7)
  private String licensePlateCar;
  @NotBlank
  private String brandCar;
  @NotBlank
  private String modelCar;
  @NotBlank
  private String colorCar;
  @NotBlank
  private String responsibleName;
  @NotBlank
  private String apartment;
  @NotBlank
  private String block;

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
