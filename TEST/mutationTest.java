import org.junit.jupiter.api.Test;

class mutationTest {

    @Test
    void testTSP() {
    }

    @Test
    void testMutation_of_gnome() {

        Main.file_input();
        Main.distance();

        String result = mutation.mutation_of_gnome("012340");

        System.out.println(result);

    }

    @Test
    void testMutation_of_population() {
    }
}