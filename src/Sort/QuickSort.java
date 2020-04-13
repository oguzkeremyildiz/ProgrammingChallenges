package Sort;/* Created by oguzkeremyildiz on 12.04.2020 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class QuickSort<Symbol>  {
    private Comparator<Symbol> comparator;

    public QuickSort(ArrayList<Symbol> list, Comparator<Symbol> comparator) {
        this.comparator = comparator;
        quickSort(list, 0, list.size() - 1);
    }
    public QuickSort(LinkedList<Symbol> list, Comparator<Symbol> comparator) {
        this.comparator = comparator;
        quickSort(list, 0, list.size() - 1);
    }
    private void swap(ArrayList<Symbol> list, int i, int j){
        Symbol tmp;
        tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
    private int partition(ArrayList<Symbol> list, int first, int last){
        Symbol x = list.get(last);
        int i = first - 1, j;
        for (j = first; j < last; j++){
            if (comparator.compare(list.get(j), x) < 0){
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, last);
        return i + 1;
    }
    private void quickSort(ArrayList<Symbol> list, int first, int last){
        int pivot;
        if (first < last){
            pivot = partition(list, first, last);
            quickSort(list, first, pivot - 1);
            quickSort(list, pivot + 1, last);
        }
    }

    private void swap(LinkedList<Symbol> list, int i, int j){
        Symbol tmp;
        tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
    private int partition(LinkedList<Symbol> list, int first, int last){
        Symbol x = list.get(last);
        int i = first - 1, j;
        for (j = first; j < last; j++){
            if (comparator.compare(list.get(j), x) < 0){
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, last);
        return i + 1;
    }
    private void quickSort(LinkedList<Symbol> list, int first, int last){
        int pivot;
        if (first < last){
            pivot = partition(list, first, last);
            quickSort(list, first, pivot - 1);
            quickSort(list, pivot + 1, last);
        }
    }
}
