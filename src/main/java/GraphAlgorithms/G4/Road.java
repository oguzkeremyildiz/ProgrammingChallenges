package GraphAlgorithms.G4;/* Created by oguzkeremyildiz on 22.05.2020 */

public class Road {

    private String name;
    private int hour;

    public Road(String name, int hour) {
        this.name = name;
        this.hour = hour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
