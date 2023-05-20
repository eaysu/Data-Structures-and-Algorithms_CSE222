package hw7;

import java.util.ArrayList;


/**
 * # class SelectionSort
 */
public class SelectionSort {
    
    private MyMap originalMap;
    private MyMap sortedMap;
    private ArrayList<String> aux;


    /**
     * # conctructor of SelectionSort class
     * @param originalMap # it takes unsorted map from MyMap class
     */
    public SelectionSort (MyMap originalMap) {
        this.originalMap = originalMap;
        this.sortedMap = new MyMap("");
        this.aux = new ArrayList<String>();

        Info[] values = valueToArray();
        getAux(); 
        sort(values, aux);
        fillSortedMap(values, aux);
    }

    
    /**
     * # selection sort function that divides the input list into two parts and 
     * # repeatedly selects the smallest (or largest) element from the unsorted part
     * # and swaps it with the leftmost element of the unsorted part.
     * @param values # it takes map values.
     * @param aux # it takes map keys named aux.
     */
    private void sort(Info[] values, ArrayList<String> aux) {
        int n = values.length;
        for (int fill = 0;fill < n - 1;++fill) {
            int posMin = fill;
            for (int next = fill + 1; next < n;++next) {
                if (values[next].getCount() < values[posMin].getCount()) {
                    posMin = next;
                }
            }

            Info tempValue = values[fill];
            values[fill] = values[posMin];
            values[posMin] = tempValue;

            String tempAux = aux.get(fill);
            aux.set(fill, aux.get(posMin));
            aux.set(posMin, tempAux);
        }
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