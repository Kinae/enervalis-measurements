package abb.interview.display;

import abb.interview.domain.Direction;
import abb.interview.domain.Measurement;
import abb.interview.domain.MeasurementSample;
import abb.interview.domain.Measurements;
import abb.interview.domain.Power;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

// Change magic String into something more dynamic
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

        Measurement expected = measurements.values().iterator().next();
        DeviceFormatOne actual = deviceFormatOnes.iterator().next();
        Assertions.assertEquals(expected.getDeviceGroup(), actual.getGroup());
        Assertions.assertEquals(expected.getDirection(), actual.getDirection());
        Assertions.assertEquals("131.4979", actual.getMin());
        Assertions.assertEquals("408.4770", actual.getMax());
        Assertions.assertEquals("269.9874", actual.getAvg());
    }


    @Test
    void buildDeviceFormatTwoShouldTransformMeasurementsToDisplayAsFormatTwo() {
        Measurements measurements = MeasurementSample.measurements();
        List<DeviceFormatTwo> deviceFormatTwos = DeviceDisplay.buildDeviceFormatTwo(measurements);

        Assertions.assertNotNull(deviceFormatTwos);
        Assertions.assertEquals(measurements.size(), deviceFormatTwos.size());


        Measurement expected = measurements.values().iterator().next();
        DeviceFormatTwo actual = deviceFormatTwos.iterator().next();
        Assertions.assertEquals(DeviceIdFormatter.format(expected.getResourceId()), actual.getDeviceId());
        Assertions.assertEquals(expected.getDeviceGroup(), actual.getDeviceGroup());
        Assertions.assertEquals(expected.getDirection(), actual.getDirection());
        Assertions.assertEquals(DeviceDisplay.displayPowerOrderedByMaxAsc(expected), actual.getPowers());
    }

    @Test
    void displayDeviceIdShouldRemoveSpecialCharacterFromDeviceId() {
        Measurement measurement = MeasurementSample.firstItem();
        String deviceId = DeviceDisplay.displayDeviceId(measurement);
        Assertions.assertEquals("49e258fe9d4043b49a2931f82ad5ec15", deviceId);
    }

    @Test
    void displayDeviceGroupShouldReturnOriginalDeviceGroup() {
        Measurement measurement = MeasurementSample.firstItem();
        String deviceGroup = DeviceDisplay.displayDeviceGroup(measurement);
        Assertions.assertEquals(measurement.getDeviceGroup(), deviceGroup);
    }

    @Test
    void displayDirectionShouldReturnOriginalDirection() {
        Measurement measurement = MeasurementSample.firstItem();
        Direction direction = DeviceDisplay.displayDirection(measurement);
        Assertions.assertEquals(measurement.getDirection(), direction);
    }

    @Test
    void powerOrderedByMaxAscShouldReturnPowerOrdered() {
        double[] expectedPowerOrderedByAsc = new double[] {
                65.44317306454077, 71.02130954875403, 81.35525057376806, 90.90748071088007, 99.74979414798125};

        Measurement measurement = MeasurementSample.firstItem();
        List<Double> powerOrderedByMaxAsc = DeviceDisplay.powerOrderedByMaxAsc(measurement);
        for (int i = 0; i < expectedPowerOrderedByAsc.length; i++) {
            double expected = expectedPowerOrderedByAsc[i];
            Assertions.assertEquals(expected, powerOrderedByMaxAsc.get(i));
        }
    }

}
