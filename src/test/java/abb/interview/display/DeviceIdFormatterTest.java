package abb.interview.display;

import abb.interview.domain.Measurement;
import abb.interview.domain.MeasurementSample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeviceIdFormatterTest {

    @Test
    void formatShouldRemoveAllSpecialCharacter() {
        // assert that null does not throw nullPtrException
        Assertions.assertDoesNotThrow(() -> DeviceIdFormatter.format(null));

        Measurement measurement = MeasurementSample.firstItem();
        String actual = DeviceIdFormatter.format(measurement.getResourceId());
        Assertions.assertFalse(actual.contains(DeviceIdFormatter.CHAR_TO_REMOVE));
    }

}
