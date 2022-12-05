package abb.interview.display;

import abb.interview.domain.Measurement;
import abb.interview.domain.MeasurementSample;
import abb.interview.domain.Measurements;
import abb.interview.domain.Power;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DeviceDisplayTest {

    @Test
    void computeTotalOfShouldReturnTheTotalOfTheSuppliedFunction() {
        List<Measurement> measurements = List.of(MeasurementSample.firstItem());
        double sumOfPowerMin = 131.49787350386032d; // should be dynamic

        double actual = DeviceDisplay.computeTotalOf(measurements, Power::getMin);
        Assertions.assertEquals(sumOfPowerMin, actual);
    }

    @Test
    void deviceFormatOneShouldTransformMeasurementsToDisplayAsFormatOne() {
        Measurements measurements = MeasurementSample.measurements();
        List<DeviceFormatOne> deviceFormatOnes = DeviceDisplay.buildDeviceFormatOne(measurements);

        Assertions.assertNotNull(deviceFormatOnes);
        Assertions.assertEquals(measurements.size(), deviceFormatOnes.size());

        // Should be dynamic
        Measurement expected = measurements.values().iterator().next();
        DeviceFormatOne actual = deviceFormatOnes.iterator().next();
        Assertions.assertEquals(expected.getDeviceGroup(), actual.getGroup());
        Assertions.assertEquals(expected.getDirection(), actual.getDirection());
        Assertions.assertEquals("131.4979", actual.getMin());
        Assertions.assertEquals("408.4770", actual.getMax());
        Assertions.assertEquals("269.9874", actual.getAvg());
    }

}
