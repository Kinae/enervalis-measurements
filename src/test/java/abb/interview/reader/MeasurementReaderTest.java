package abb.interview.reader;

import abb.interview.domain.Measurement;
import abb.interview.domain.MeasurementSample;
import abb.interview.domain.Power;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MeasurementReaderTest {

    @Test
    void readFileShouldMatchTheMeasurementObjectStructure() throws IOException {
        // read file into list
        List<Measurement> result = MeasurementReader.readValue(new File("src/test/resources/measurements.json"));

        // null is not acceptable
        Assertions.assertNotNull(result);

        // Size is a known value, remove magic number and use proper count when we produce the file
        Assertions.assertEquals(40, result.size());

        // Testing only 1 object, we should produce a dynamic file and test all objects.
        // We are only testing that the Object Measurement and the file measurements.json have the same data structure
        Measurement expectedMeasurement = MeasurementSample.firstItem();
        Measurement actualMeasurement = result.iterator().next();

        // We could implement Equals and Hashcode in Measurement, but it could be a bad idea if used in a Set
        assertAll("measurement",
                () -> assertEquals(expectedMeasurement.getResourceId(), actualMeasurement.getResourceId()),
                () -> assertEquals(expectedMeasurement.getDeviceName(), actualMeasurement.getDeviceName()),
                () -> assertEquals(expectedMeasurement.getDeviceGroup(), actualMeasurement.getDeviceGroup()),
                () -> assertEquals(expectedMeasurement.getDirection(), actualMeasurement.getDirection())
        );

        List<Power> expectedPowers = expectedMeasurement.getPower();
        List<Power> actualPowers = actualMeasurement.getPower();

        for (int i = 0; i < actualPowers.size(); i++) {
            Power expectedPower = expectedPowers.get(i);
            Power actualPower = actualPowers.get(i);

            // We could implement Equals and Hashcode in Power, but it could be a bad idea if used in a Set
            assertAll("power",
                    () -> assertEquals(expectedPower.getMin(), actualPower.getMin()),
                    () -> assertEquals(expectedPower.getMax(), actualPower.getMax()),
                    () -> assertEquals(expectedPower.getAvg(), actualPower.getAvg()),
                    () -> assertEquals(expectedPower.getTimestamp(), actualPower.getTimestamp())
            );
        }
    }

}
