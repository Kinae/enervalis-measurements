package abb.interview.display;

import abb.interview.domain.Direction;
import abb.interview.domain.Measurement;
import abb.interview.domain.Measurements;
import abb.interview.domain.Power;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class DeviceDisplay {

    private DeviceDisplay() {
    }

    public static void printDeviceFormatOne(final Measurements measurements) {
        List<DeviceFormatOne> deviceFormatOnes = buildDeviceFormatOne(measurements);
        deviceFormatOnes.forEach(System.out::println);
    }

    static List<DeviceFormatOne> buildDeviceFormatOne(final Measurements measurements) {
        // Group devices by Group and Direction
        Map<DeviceGroupAndDirectionKey, List<Measurement>> measurementGroupDeviceGroup = measurements.values().stream()
                .collect(Collectors.groupingBy(it -> new DeviceGroupAndDirectionKey(it.getDeviceGroup(), it.getDirection())));

        return measurementGroupDeviceGroup.entrySet().stream()
                .map(it -> new DeviceFormatOne(
                        it.getKey().getDeviceGroup(),
                        it.getKey().getDirection(),
                        PowerFormatter.format(computeTotalOf(it.getValue(), Power::getMin)),
                        PowerFormatter.format(computeTotalOf(it.getValue(), Power::getMax)),
                        PowerFormatter.format(computeTotalOf(it.getValue(), Power::getAvg))
                ))
                .collect(Collectors.toList());

    }

    static double computeTotalOf(List<Measurement> measurements, ToDoubleFunction<? super Power> function) {
        return measurements.stream().flatMapToDouble(it -> it.getPower().stream().mapToDouble(function)).sum();
    }


    public static void printDeviceFormatTwo(final Measurements measurements) {
        List<DeviceFormatTwo> deviceFormatTwos = buildDeviceFormatTwo(measurements);
        deviceFormatTwos.forEach(System.out::println);
    }

    static List<DeviceFormatTwo> buildDeviceFormatTwo(final Measurements measurements) {
        Comparator<Measurement> comparator = Comparator.comparing(Measurement::getDeviceGroup).thenComparing(Measurement::getDirection);
        return measurements.values().stream().sorted(comparator)
                .map(it -> new DeviceFormatTwo(
                        displayDeviceId(it),
                        displayDeviceGroup(it),
                        displayDirection(it),
                        displayPowerOrderedByMaxAsc(it)
                ))
                .collect(Collectors.toList());
    }

    static String displayDeviceId(Measurement measurement) {
        return DeviceIdFormatter.format(measurement.getResourceId());
    }

    static String displayDeviceGroup(Measurement measurement) {
        return measurement.getDeviceGroup();
    }

    static Direction displayDirection(Measurement measurement) {
        return measurement.getDirection();
    }

    static String displayPowerOrderedByMaxAsc(Measurement measurement) {
        return Arrays.toString(
                powerOrderedByMaxAsc(measurement).stream()
                        .map(PowerFormatter::format)
                        .toArray()
        );
    }

    static List<Double> powerOrderedByMaxAsc(Measurement measurement) {
        return measurement.getPower().stream().map(Power::getMax)
                .sorted(Comparator.comparingDouble(it -> it))
                .collect(Collectors.toList());
    }

}
