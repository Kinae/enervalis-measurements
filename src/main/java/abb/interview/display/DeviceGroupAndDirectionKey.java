package abb.interview.display;

import abb.interview.domain.Direction;

import java.util.Objects;

public class DeviceGroupAndDirectionKey {

    private final String deviceGroup;
    private final Direction direction;

    public DeviceGroupAndDirectionKey(String deviceGroup, Direction direction) {
        this.deviceGroup = deviceGroup;
        this.direction = direction;
    }

    public String getDeviceGroup() {
        return deviceGroup;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceGroupAndDirectionKey that = (DeviceGroupAndDirectionKey) o;
        return Objects.equals(deviceGroup, that.deviceGroup) && direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceGroup, direction);
    }
}
