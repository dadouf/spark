package com.davidferrand.spark.data;

import java.util.Date;

import io.realm.RealmObject;

public class MeterReading extends RealmObject {
    private Meter meter;
    private Date readingDate;

    /**
     * Value (in kWh) read on the meter. Increases with time.
     */
    private Float meterValueReading;

    /**
     * Credit value read on the meter. Decreases with time.
     * Used only with a {@link PaymentType#PREPAYMENT} meter.
     */
    private Float meterCreditReading;
}
