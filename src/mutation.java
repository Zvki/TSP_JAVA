import java.util.*;

public class mutation {

    public static List<individual> population;
    public static individual MVP_individual = new individual();
    public static double end_condition = 10000;


    public static void TSP (){

        int generation_number = 0;


        population = mutation_resources.create_population(Main.size_of_population);

        while(generation_number < Main.number_of_generations){

            List<individual> new_population = mutation.mutation_of_population();


           if(new_population.getFirst().fitness < MVP_individual.fitness) {
              System.out.println(new_population.getFirst().gnome + " " + new_population.getFirst().fitness + " Gen number " + generation_number);
              MVP_individual = new_population.getFirst();
              end_condition = (int) (0.95 * end_condition);
               generation_number++;
           }

            if(new_population.getFirst().fitness == MVP_individual.fitness){
                generation_number++;
            }

           population = new_population;

        }
    }

    public static String mutation_of_gnome(String gnome){

        while(true){
            int random_number = mutation_resources.random_number_gen(1, gnome.length()),  random_number2 = mutation_resources.random_number_gen(1, gnome.length());
            if(random_number != random_number2){
                char temporary_city = gnome.charAt(random_number);
                gnome = gnome.substring(0, random_number) + gnome.charAt(random_number2) + gnome.substring( random_number + 1);
                gnome = gnome.substring(0, random_number2) + temporary_city + gnome.substring( random_number2 + 1);
                break;
            }
        }

        return gnome;
    }

    public static List<individual> mutation_of_population(){
        List<individual> new_population = new ArrayList<individual>();

        for (individual temporary_individual : population) {
            while (true) {
                individual mutated_individual = new individual();
                mutated_individual.gnome = mutation_of_gnome(temporary_individual.gnome);
                mutated_individual.fitness = mutation_resources.calculate_fitness(mutated_individual.gnome);

                if (mutated_individual.fitness <= temporary_individual.fitness) {
                    new_population.add(mutated_individual);
                    break;
                } else {
                    double probability = Math.pow(2.7, -(mutated_individual.fitness - temporary_individual.fitness) / end_condition);
                    if (probability > 0.9) {
                        new_population.add(mutated_individual);
                        break;
                    }
                }
            }
        }

        new_population.sort((i1, i2)-> Double.compare(i1.fitness, i2.fitness));
        return new_population;
    }
}
