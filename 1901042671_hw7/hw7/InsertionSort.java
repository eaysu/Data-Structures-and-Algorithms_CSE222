package hw7;

import java.util.ArrayList;


/**
 * # class InsertSort
 */
public class InsertionSort {
    
    private MyMap originalMap;
    private MyMap sortedMap;
    private ArrayList<String> aux;


    /**
     * # conctructor of InsertionSort class
     * @param originalMap # it takes unsorted map from MyMap class
     */
    public InsertionSort (MyMap originalMap) {
        this.originalMap = originalMap;
        this.sortedMap = new MyMap("");
        this.aux = new ArrayList<String>();

        Info[] values = valueToArray();
        getAux(); 
        sort(values, aux);
        fillSortedMap(values, aux);
    }

    
    /**
     * # insertion sort function that builds the final sorted array one element at a time. 
     * # dividing the input list into two parts as sortad and unsorted part. 
     * # the algorithm iterates over the unsorted part and repeatedly inserts 
     * # the current element into its correct position in the sorted part.
     * @param values # it takes map values.
     * @param aux # it takes map keys named aux.
     */
    private void sort (Info[] values, ArrayList<String> aux) {
        int n = values.length;
        for (int nextPos = 1;nextPos < n;++nextPos) {
            insert(values, aux, nextPos);
        }
    }


    /**
     * # insert function continues...
     * @param values # it takes map values.
     * @param aux # it takes map keys named aux.
     * @param nextPos # it takes index.
     */
    private void insert (Info[] values, ArrayList<String> aux, int nextPos) {
        Info key = values[nextPos];
        String auxKey = aux.get(nextPos);
        nextPos = nextPos - 1;
        while (nextPos >= 0 && values[nextPos].getCount() > key.getCount()) {
            values[nextPos + 1] = values[nextPos];
            aux.set(nextPos + 1, aux.get(nextPos));
            nextPos--;
        }
        values[nextPos + 1] = key;
        aux.set(nextPos + 1, auxKey);
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