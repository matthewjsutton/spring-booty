package com.carlsonwagonlit.linedef;


/**
 * AutoValue class that represents one LineDef
 */
public class LineDef {
    private String topGuid;
    private String subGuid;
    private String travelerType;
    private String airfareReasonCode;
    private String lowestFare;
    private String costCenter;
    private String travelReason;
    private String hotelReasonCode;
    private String carReasonCode;
    private String authorizerEmail;
    private String travelerEmail;
    private String arrangerEmail;
    private String airfareAuthorization;
    private String carRate;
    private String hotelRate;

    public String getTopGuid() {
        return topGuid;
    }

    public void setTopGuid(String topGuid) {
        this.topGuid = topGuid;
    }

    public String getSubGuid() {
        return subGuid;
    }

    public void setSubGuid(String subGuid) {
        this.subGuid = subGuid;
    }

    public String getTravelerType() {
        return travelerType;
    }

    public void setTravelerType(String travelerType) {
        this.travelerType = travelerType;
    }

    public String getAirfareReasonCode() {
        return airfareReasonCode;
    }

    public void setAirfareReasonCode(String airfareReasonCode) {
        this.airfareReasonCode = airfareReasonCode;
    }

    public String getLowestFare() {
        return lowestFare;
    }

    public void setLowestFare(String lowestFare) {
        this.lowestFare = lowestFare;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getTravelReason() {
        return travelReason;
    }

    public void setTravelReason(String travelReason) {
        this.travelReason = travelReason;
    }

    public String getHotelReasonCode() {
        return hotelReasonCode;
    }

    public void setHotelReasonCode(String hotelReasonCode) {
        this.hotelReasonCode = hotelReasonCode;
    }

    public String getCarReasonCode() {
        return carReasonCode;
    }

    public void setCarReasonCode(String carReasonCode) {
        this.carReasonCode = carReasonCode;
    }

    public String getAuthorizerEmail() {
        return authorizerEmail;
    }

    public void setAuthorizerEmail(String authorizerEmail) {
        this.authorizerEmail = authorizerEmail;
    }

    public String getTravelerEmail() {
        return travelerEmail;
    }

    public void setTravelerEmail(String travelerEmail) {
        this.travelerEmail = travelerEmail;
    }

    public String getArrangerEmail() {
        return arrangerEmail;
    }

    public void setArrangerEmail(String arrangerEmail) {
        this.arrangerEmail = arrangerEmail;
    }

    public String getAirfareAuthorization() {
        return airfareAuthorization;
    }

    public void setAirfareAuthorization(String airfareAuthorization) {
        this.airfareAuthorization = airfareAuthorization;
    }

    public String getCarRate() {
        return carRate;
    }

    public void setCarRate(String carRate) {
        this.carRate = carRate;
    }

    public String getHotelRate() {
        return hotelRate;
    }

    public void setHotelRate(String hotelRate) {
        this.hotelRate = hotelRate;
    }
}
