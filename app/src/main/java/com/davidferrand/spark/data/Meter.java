package com.davidferrand.spark.data;

import io.realm.RealmObject;

public class Meter extends RealmObject {
    private String name;
    private String fuelType;
    private String paymentType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FuelType getFuelType() {
        return FuelType.valueOf(fuelType);
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType.name();
    }

    public PaymentType getPaymentType() {
        return PaymentType.valueOf(paymentType);
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType.name();
    }

    public enum FuelType {
        ELECTRICITY, GAS
    }

    public enum PaymentType {
        STANDARD, PREPAYMENT
    }
}
