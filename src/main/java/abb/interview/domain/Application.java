package abb.interview.domain;

import abb.interview.display.DeviceDisplay;
import abb.interview.reader.MeasurementReader;

import java.io.File;
import java.io.IOException;

public class Application {

    private static final Measurements measurements = new Measurements();

    public static void main(String[] args) throws IOException {
        // read measurements.json into Measurements.
        // TODO deal with IOException
        MeasurementReader.readValueAndGroupByKey(measurements, new File("src/main/resources/measurements.json"));

        // print first
        DeviceDisplay.printDeviceFormatOne(measurements);

        System.out.println("------------------------------");

        // print second
        DeviceDisplay.printDeviceFormatTwo(measurements);



    }
}
