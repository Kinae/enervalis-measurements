package abb.interview.reader;

import abb.interview.domain.Measurement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class MeasurementReaderTest {

    @Test
    void readFileShouldMatchTheMeasurementObjectStructure() {
        // read file into list
        List<Measurement> result = MeasurementReader.readValue(new File("src/test/resources/measurements.json"));

        Assertions.assertNotNull(result);
        Assertions.assertNotEquals(0, result.size());

        // assert measurement structure is correct

        // assert power structure is correct
    }

}
