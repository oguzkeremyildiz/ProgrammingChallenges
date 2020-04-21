package Sorting.S5;/* Created by oguzkeremyildiz on 7.03.2020 */

public class Shoe {
    int time;
    int cent;
    final double ratio;
    int index;

    public Shoe(int time, int cent, int index){
        this.time = time;
        this.cent = cent;
        this.index = index;
        this.ratio = (double)this.cent / (double)this.time;
    }

    public int getIndex(){
        return index;
    }

    public int getCent() {
        return cent;
    }

    public int getTime() {
        return time;
    }

    public double getRatio(){
        return ratio;
    }
}
