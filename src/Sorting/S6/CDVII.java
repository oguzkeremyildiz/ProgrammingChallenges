package Sorting.S6;/* Created by oguzkeremyildiz on 10.03.2020 */

import java.io.File;
import java.util.*;

public class CDVII {
    private static void sort(HashMap<Integer, Integer> map, Car car, ArrayList<Integer> numbers, ArrayList<Integer> hours){
        car.setMoney(car.getMoney() + (map.size() / 2) * 100);
        ArrayList<Integer> keys = new ArrayList<>();
        keys.addAll(map.keySet());
        Collections.sort(keys);
        int t = -1;
        for (int i = 0; i < map.size(); i++) {
            if (i % 2 == 0){
                t++;
                int total = map.get(keys.get(i + 1)) - map.get(keys.get(i));
                car.setMoney(car.getMoney() + numbers.get(hours.get(t)) * total);
            }
        }
        System.out.println(car.getName() + " " + car.getMoney());
    }
    private static void print(Cars cars, ArrayList<Integer> numbers){
        ArrayList<Integer> hours = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<String> names = new HashSet<>();
        for (int i = 0; i < cars.size(); i++) {
            if (!names.contains(cars.getCar(i).getName())){
                map.put(cars.getCar(i).getHour(), cars.getCar(i).getKilometres());
                if (cars.getCar(i).getStatus().equals("enter")){
                    hours.add(cars.getCar(i).getHour());
                }
                for (int j = 0; j < cars.size(); j++) {
                    if (i != j){
                        if (cars.getCar(i).getName().equals(cars.getCar(j).getName())){
                            map.put(cars.getCar(j).getHour(), cars.getCar(j).getKilometres());
                            if (cars.getCar(j).getStatus().equals("enter")){
                                hours.add(cars.getCar(j).getHour());
                            }
                        }
                    }
                }
            }
            if (!names.contains(cars.getCar(i).getName())){
                names.add(cars.getCar(i).getName());
                sort(map, cars.getCar(i), numbers, hours);
                hours.clear();
                map.clear();
            }
        }
    }
    private static void addCar(Cars cars, ArrayList<String> features){
        int time;
        String timeString = "";
        String[] split;
        split = features.get(1).split(":");
        for (String s : split) {
            timeString += s;
        }
        int hour = Integer.parseInt(split[2]);
        time = Integer.parseInt(timeString);
        cars.addCar(new Car(features.get(0), features.get(2), time, hour, Integer.parseInt(features.get(3)), 200));
    }
    public static void main(String[]args){
        try {
            String times;
            String line;
            int convert;
            String[] split1;
            String[] split2;
            Cars cars = new Cars();
            ArrayList<Integer> numbers = new ArrayList<>();
            ArrayList<String> features = new ArrayList<>();
            Scanner source = new Scanner(new File("CDVII.txt"));
            times = source.nextLine();
            convert = Integer.parseInt(times);
            for (int i = 0; i < convert; i++){
                line = source.nextLine();
                split1 = line.split(" ");
                for (String s : split1) {
                    numbers.add(Integer.parseInt(s));
                }
                while (source.hasNext()){
                    line = source.nextLine();
                    split2 = line.split(" ");
                    features.addAll(Arrays.asList(split2));
                    addCar(cars, features);
                    features.clear();
                }
                print(cars, numbers);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
