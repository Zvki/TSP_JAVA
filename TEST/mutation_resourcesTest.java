import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class mutation_resourcesTest {

    @Test
    void create_gnome() {

        Main.file_input();
        Main.distance();

        String result = mutation_resources.create_gnome();

        System.out.println(result);

        Assertions.assertEquals(11 , result.length());
    }

    @Test
    void calculate_fitness() {

        Main.file_input();
        Main.distance();

        double result = mutation_resources.calculate_fitness("014230");
        double result1 = mutation_resources.calculate_fitness("032410");

        Assertions.assertEquals(result, result1);

    }

    @Test
    void create_population() {

        Main.file_input();
        Main.distance();

       List<individual> result = mutation_resources.create_population(20);

       for (individual individual : result) {
           System.out.println(individual.gnome);
       }

       Assertions.assertEquals(20, result.size());
    }

    @Test
    void random_number_gen() {
        Integer result = mutation_resources.random_number_gen(1,20);
        System.out.println(result);
    }

    @Test
    void is_repeating() {

        boolean result = mutation_resources.is_repeating("0123", (char) (2 + 48));
        Assertions.assertTrue(result);
    }
}