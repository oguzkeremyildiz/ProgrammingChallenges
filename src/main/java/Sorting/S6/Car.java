package Sorting.S6;/* Created by oguzkeremyildiz on 10.03.2020 */

public class Car {
    String name;
    int money;
    String status;
    int time;
    int hour;
    int kilometres;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getHour() {
        return hour;
    }

    public int getKilometres() {
        return kilometres;
    }

    public Car(String name, String status, int time, int hour, int kilometres, int money){
        this.name = name;
        this.money = money;
        this.status = status;
        this.time = time;
        this.hour = hour;
        this.kilometres = kilometres;
    }
}
