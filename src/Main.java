import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static Map<Integer, double[]> cities = new HashMap<>();
    public static List<List<Double>> distances = new ArrayList<>();
    public static Integer number_of_generations = 0, size_of_population = 0;

    public static void main(String[] args) {

        System.out.println("Enter the number of generations: ");
        Scanner input = new Scanner(System.in);
        number_of_generations= input.nextInt();
        System.out.println("Enter the population size: ");
        size_of_population = input.nextInt();

        file_input();
        distance();
        mutation.TSP();

    }

    public static void file_input(){

        int city;
        double  city_x, city_y;
        String file_input = "D:\\JAVA.PROJECTS\\TSP_NO_GUI\\src\\cities.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(file_input))) {
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split("\\s+");
                city = Integer.parseInt(parts[0]);
                city_x = Double.parseDouble(parts[1]);
                city_y = Double.parseDouble(parts[2]);

                cities.put(city, new double[]{city_x, city_y});
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void distance (){
        double distance;

        for(Map.Entry<Integer, double[]> entry : cities.entrySet()){
            List<Double> point_distances = new ArrayList<>();
            for(Map.Entry<Integer,double[]> entry2 : cities.entrySet()){
                distance = Math.sqrt(Math.abs(Math.pow(entry.getValue()[0] - entry2.getValue()[0],2) + Math.pow(entry.getValue()[1] - entry2.getValue()[1],2)));
                point_distances.add(distance);
            }
            distances.add(point_distances);
        }
    }
}