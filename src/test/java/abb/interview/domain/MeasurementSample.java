package abb.interview.domain;

public class MeasurementSample {

    // Should not use it like that in production, should use fake data
    public static Measurement firstItem() {
        Measurement measurement = new Measurement();
        measurement.setResourceId("49e258fe-9d40-43b4-9a29-31f82ad5ec15");
        measurement.setDeviceName("device_1");
        measurement.setDeviceGroup("group_a");
        measurement.setDirection(Direction.OUT);
        measurement.setPower(PowerSample.firstItems());
        return measurement;
    }

}
