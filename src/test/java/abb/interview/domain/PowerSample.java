package abb.interview.domain;

import java.util.List;

public class PowerSample {

    // Should not use it like that in production, should use fake data
    static List<Power> firstItems() {
        return List.of(
                power(29.163184452205893, 65.44317306454077, 47.303178758373335, 1626300000),
                power(13.620455434219808, 99.74979414798125, 56.68512479110053, 1626300900),
                power(23.37824512445404, 90.90748071088007, 57.14286291766705, 1626302700),
                power(37.46771591669314, 81.35525057376806, 59.4114832452306, 1626305400),
                power(27.868272576287424, 71.02130954875403, 49.44479106252073, 1626309000)
        );
    }

    private static Power power(double min, double max, double avg, long timestamp) {
        Power power = new Power();
        power.setMin(min);
        power.setMax(max);
        power.setAvg(avg);
        power.setTimestamp(timestamp);
        return power;
    }

}
