package abb.interview.display;

import abb.interview.domain.Direction;

import java.util.StringJoiner;

// name is bad ^^
//
// Write a method that outputs a list of all devices, and their max power, ordered by group, direction and power(ascending):
//    Device: deviceId, group, direction, power.max
//    The deviceId must be the UUID without '-'
//    The max power must have 4 decimal digits
public class DeviceFormatTwo {

    private final String deviceId;
    private final String deviceGroup;
    private final Direction direction;
    private final String powers;

    public DeviceFormatTwo(String deviceId, String deviceGroup, Direction direction, String powers) {
        this.deviceId = deviceId;
        this.deviceGroup = deviceGroup;
        this.direction = direction;
        this.powers = powers;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceGroup() {
        return deviceGroup;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getPowers() {
        return powers;
    }

    @Override
    public String toString() {
        return new StringJoiner(" | ", DeviceFormatTwo.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("deviceGroup='" + deviceGroup + "'")
                .add("direction=" + direction)
                .add("powers='" + powers + "'")
                .toString();
    }
}

