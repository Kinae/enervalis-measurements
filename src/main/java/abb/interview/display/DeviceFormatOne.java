package abb.interview.display;

import abb.interview.domain.Direction;

import java.util.StringJoiner;

// name is bad ^^
//
// Write a method that prints the totals for both groups for in and outgoing power.
//    group, direction, power
//    The power total must have 4 decimal digits
public class DeviceFormatOne {

    private final String group;
    private final Direction direction;
    private final String min;
    private final String max;
    private final String avg;

    public DeviceFormatOne(String group, Direction direction, String min, String max, String avg) {
        this.group = group;
        this.direction = direction;
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    public String getGroup() {
        return group;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public String getAvg() {
        return avg;
    }

    @Override
    public String toString() {
        return new StringJoiner(" | ", DeviceFormatOne.class.getSimpleName() + "[", "]")
                .add("group='" + group + "'")
                .add("direction=" + direction)
                .add("min='" + min + "'")
                .add("max='" + max + "'")
                .add("avg='" + avg + "'")
                .toString();
    }
}
