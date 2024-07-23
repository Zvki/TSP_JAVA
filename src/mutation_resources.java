import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class mutation_resources {

    public static String create_gnome(){
        String gnome = "0";

        while(true){
            if(gnome.length() == Main.distances.size()){
                gnome += "0";
                break;
            }
            int temporary_city = random_number_gen(1, Main.distances.size());
            if(!is_repeating(gnome, (char) (temporary_city + 48))){
                gnome += (char)(temporary_city + 48);
            }
        }
        return gnome;
    }

    public static Double calculate_fitness(String gnome){
        double fitness = 0;
        for(int i = 0; i < gnome.length() - 1; i++){
            fitness += Main.distances.get(gnome.charAt(i) - 48).get(gnome.charAt(i + 1) - 48);
        }
        return fitness;
    }

    public static List<individual> create_population(Integer size_of_population){
        List<individual> population = new ArrayList<individual>();

        for (int i = 0; i < size_of_population; i++) {
            individual temporary_route = new individual();
            temporary_route.gnome = mutation_resources.create_gnome();
            temporary_route.fitness = mutation_resources.calculate_fitness(temporary_route.gnome);
            population.add(temporary_route);
        }



        population.sort((i1, i2)-> Double.compare(i1.fitness, i2.fitness));
        mutation.MVP_individual = population.getFirst();
        return population;
    }



    public static Integer random_number_gen(Integer start, Integer end){
        Random rand = new Random();
        int range = end - start;
        return start + rand.nextInt(range);
    }

    public static boolean is_repeating(String route, Character city_number){
        for(Character ch : route.toCharArray()){
            if(ch.equals(city_number)){
                return true;
            }
        }
        return false;
    }

}
