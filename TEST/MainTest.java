import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void distance() {

        Main.file_input();
        Main.distance();

        for(List<Double> distance : Main.distances) {
            System.out.println(distance);
        }

    }

    @Test
    void file_input() {
        Main.file_input();

        for(Map.Entry<Integer, double[]> entry : Main.cities.entrySet()){
            int key = entry.getKey();
            double[] values = entry.getValue();
            System.out.printf("%d\t%.2f\t%.2f\n", key, values[0], values[1]);
        }
    }
}