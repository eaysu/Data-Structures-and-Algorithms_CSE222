package hw7;

import java.util.ArrayList;


/**
 * # class QuickSort
 */
public class QuickSort {

    private MyMap originalMap;
    private MyMap sortedMap;
    private ArrayList<String> aux;


    /**
     * # constructor of QuickSort class
     * @param originalMap # it takes unsorted map from MyMap class
     */
    public QuickSort (MyMap originalMap) {
        this.originalMap = originalMap;
        this.sortedMap = new MyMap("");
        this.aux = new ArrayList<String>();

        Info[] values = valueToArray();
        getAux(); 
        sort(values, aux, 0, values.length - 1);
        fillSortedMap(values, aux);
    }

    
    /**
     * # quick sort function that selects a pivot element from the list 
     * # and partitions the other elements into two sub-arrays according to whether 
     * # they are less than or greater than the pivot. 
     * # the sub-arrays are then recursively sorted using the same process.
     * @param values # it takes map values.
     * @param aux # it takes map keys named aux.
     * @param first # first element on the array.
     * @param last # last element on the array.
     */
    private void sort(Info[] values, ArrayList<String> aux, int first, int last) {
        if (first < last) {
            int pivIndex = partition(values, aux, first, last);
            sort(values, aux, first, pivIndex - 1);
            sort(values, aux, pivIndex + 1, last);
        }
    }


    /**
     * # function that partities the list such that all elements smaller than the pivot are moved to its left.
     * # and all elements greater than the pivot are moved to its right. 
     * @param values # it takes map values.
     * @param aux # it takes map keys named aux.
     * @param first # first element on the array.
     * @param last # last element on the array.
     * @return # returns pivot's index
     */
    private int partition(Info[] values, ArrayList<String> aux, int first, int last) {
        Info pivot = values[last];
        int i = first - 1;
        for (int j = first;j < last;++j) {
            if (values[j].getCount() < pivot.getCount()) {
                i++;
                swap(values, aux, i, j);
            }
        }
        swap(values, aux, i + 1, last);
        return i + 1;
    }


    /**
     * # swap function that helps quick sort the aux and info values.
     * @param values # it takes map values.
     * @param aux # it takes map keys named aux.
     * @param i # index value.
     * @param j # index value.
     */
    private void swap(Info[] values, ArrayList<String> aux, int i, int j) {
        Info tempValue = values[i];
        values[i] = values[j];
        values[j] = tempValue;

        String tempAux = aux.get(i);
        aux.set(i, aux.get(j));
        aux.set(j, tempAux);
    }
    

    /**
     * # it storages map values to Info array.
     * @return # returns Info array.
     */
    private Info[] valueToArray() {
        Info[] valueArr = new Info[originalMap.getMapSize()];
        for(int i = 0;i < originalMap.getMapSize();i++) {
            valueArr[i] = originalMap.getValue(i);
        }
        return valueArr;
    }


    /**
     * # gets key values from unsorted array. 
     */
    private void getAux () {
        for (String key : originalMap.getMap().keySet()) {
            aux.add(key);
        }
    }


    /**
     * # the function that fills sorted map with sorted aux and values.
     * @param values # it takes values.
     * @param aux # it takes aux.
     */
    private void fillSortedMap(Info[] values, ArrayList<String> aux) {
        for(int i = 0;i < values.length;++i) {
            sortedMap.add(aux.get(i), values[i]); 
        }
    }


    /**
     * # prints sorted map.
     */
    public void printSortedMap() {
        System.out.println(sortedMap);
    }
    
}
