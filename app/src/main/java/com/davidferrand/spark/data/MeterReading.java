package com.davidferrand.spark.data;

import java.util.Date;

import io.realm.RealmObject;

public class MeterReading extends RealmObject {
    private Date sampleDate;
    private Float meterValueReading;
    private Float meterCreditReading;
}
