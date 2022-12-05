package abb.interview.reader;

import abb.interview.domain.Measurement;
import abb.interview.domain.Measurements;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MeasurementReader {

    private MeasurementReader() {
    }

    public static void readValueAndGroupByKey(final Measurements measurements, File file) throws IOException {
        groupByKey(measurements, readValue(file));
    }

    public static List<Measurement> readValue(final File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(); // should be a global variable
        return objectMapper.readValue(file, new TypeReference<List<Measurement>>() {});
    }

    // What to do in case of duplicate ?
    static void groupByKey(final Measurements measurements, List<Measurement> values) {
        for (Measurement value : values) {
            measurements.put(value.getKey(), value);
        }
    }
}
