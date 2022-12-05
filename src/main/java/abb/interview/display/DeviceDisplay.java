package abb.interview.display;

import abb.interview.domain.Measurement;
import abb.interview.domain.Measurements;
import abb.interview.domain.Power;

import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class DeviceDisplay {

    private DeviceDisplay() {
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

}
