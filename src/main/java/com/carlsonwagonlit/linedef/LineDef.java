package com.carlsonwagonlit.linedef;

import com.google.auto.value.AutoValue;

/**
 * AutoValue class that represents one LineDef
 */
@AutoValue
public abstract class LineDef {


    public abstract String topGuid();

    public abstract String travelerType();

    public abstract String lowestFare();

    public abstract String costCenter();

    public abstract String travelReason();

    public abstract String hotelReasonCode();

    public abstract String carReasonCode();

    public abstract String authorizerEmail();

    public abstract String travelerEmail();

    public abstract String arrangerEmail();

    public abstract String airfareAuthorization();

    public abstract String carRate();

    public abstract String hotelRate();

    public static Builder builder() {
        return new AutoValue_LineDef.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder topGuid(String topGuid);

        public abstract Builder travelerType(String travelerType);

        public abstract Builder lowestFare(String lowestFare);

        public abstract Builder costCenter(String costCenter);

        public abstract Builder travelReason(String travelReason);

        public abstract Builder hotelReasonCode(String hotelReasonCode);

        public abstract Builder carReasonCode(String carReasonCode);

        public abstract Builder authorizerEmail(String authorizerEmail);

        public abstract Builder travelerEmail(String travelerEmail);

        public abstract Builder arrangerEmail(String arrangerEmail);

        public abstract Builder airfareAuthorization(String airfareAuthorization);

        public abstract Builder carRate(String carRate);

        public abstract Builder hotelRate(String hotelRate);

        public abstract LineDef build();
    }
}
