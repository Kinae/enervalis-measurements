package abb.interview.reader;

import abb.interview.domain.Measurement;
import abb.interview.domain.Measurements;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MeasurementReader {

    private MeasurementReader() {
    }

    public static List<Measurement> readValue(final File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

        return objectMapper.readValue(file, new TypeReference<List<Measurement>>() {});
    }

    // What to do in case of duplicate ?
    public static void groupByKey(final Measurements measurements, List<Measurement> values) {
        for (Measurement value : values) {
            measurements.put(value.getKey(), value);
        }
    }


}
