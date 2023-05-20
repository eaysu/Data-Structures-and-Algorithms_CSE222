package hw7;

import java.util.ArrayList;


/**
 * # class BubbleSort
 */
public class BubbleSort {
    
    private MyMap originalMap;
    private MyMap sortedMap;
    private ArrayList<String> aux;


    /**
     * # conctructor of BubbleSort class
     * @param originalMap # it takes unsorted map from MyMap class
     */
    public BubbleSort (MyMap originalMap) {
        this.originalMap = originalMap;
        this.sortedMap = new MyMap("");
        this.aux = new ArrayList<String>();

        Info[] values = valueToArray();
        getAux(); 
        sort(values, aux);
        fillSortedMap(values, aux);
    }

    
    /**
     * # bubble sort function that repeatedly swaps adjacent elements if they are in the wrong order. 
     * # gradually pushing the larger elements towards the end of the list. 
     * # this process is repeated until the entire list is sorted.
     * @param values # it takes map values.
     * @param aux # it takes map keys named aux.
     */
    private void sort(Info[] values, ArrayList<String> aux) {
        int n = values.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (values[j].getCount() > values[j + 1].getCount()) {
                    Info tempValue = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = tempValue;

                    String tempAux = aux.get(j);
                    aux.set(j, aux.get(j + 1));
                    aux.set(j + 1, tempAux);
                }
            }
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
