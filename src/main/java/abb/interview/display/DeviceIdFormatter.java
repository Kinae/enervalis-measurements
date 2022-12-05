package abb.interview.display;

public class DeviceIdFormatter {

    public static final String CHAR_TO_REMOVE = "-";

    private DeviceIdFormatter() {
    }

    public static String format(String deviceId) {
        if(deviceId == null) return null;
        return deviceId.replace(CHAR_TO_REMOVE, "");
    }

}
