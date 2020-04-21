package Sorting.S6;/* Created by oguzkeremyildiz on 10.03.2020 */

import java.util.ArrayList;

public class Cars {
    ArrayList<Car> cars = new ArrayList<>();
    public Cars(){
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public Car getCar(int index){
        return cars.get(index);
    }
    public int size(){
        return cars.size();
    }
}
