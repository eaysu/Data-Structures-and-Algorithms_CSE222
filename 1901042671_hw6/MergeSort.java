import java.util.ArrayList;


/**
 * # class MergeSort
 */
public class MergeSort {
    
    private MyMap originalMap;
    private MyMap sortedMap;
    private ArrayList<String> aux;


    /**
     * # conctructor of MergeSort class
     * @param originalMap # it takes unsorted map from MyMap class
     */
    public MergeSort (MyMap originalMap) {
        this.originalMap = originalMap;
        this.sortedMap = new MyMap("");
        this.aux = new ArrayList<String>();

        Info[] values = valueToArray();
        getAux(); 
        sort(values, aux);
        fillSortedMap(values, aux);
    }

    
    /**
     * # classic merge sort algortihm. it compares two elements and sorts it. in this function
     * # both sorts count values and key values called aux.
     * @param outputSequence # sorted value.
     * @param leftSequence # unsorted left value.
     * @param rightSequence # unsorted right value.
     * @param oSequence # sorted aux.
     * @param lSequence # unsorted left aux.
     * @param rSequence # unsorted right aux.
     */
    private void merge(Info[] outputSequence, Info[] leftSequence, Info[] rightSequence,
                       ArrayList<String> oSequence, ArrayList<String> lSequence, ArrayList<String> rSequence) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSequence.length && j < rightSequence.length) {
            if (leftSequence[i].getCount() < rightSequence[j].getCount() || 
                leftSequence[i].getCount() == rightSequence[j].getCount()) {
                
                oSequence.set(k, lSequence.get(i));
                outputSequence[k++] = leftSequence[i++];
            } 

            else {
                oSequence.set(k, rSequence.get(j));
                outputSequence[k++] = rightSequence[j++];
            } 
        }
    
        while (i < leftSequence.length) {
            oSequence.set(k, lSequence.get(i));
            outputSequence[k++] = leftSequence[i++];
        }

        while (j < rightSequence.length) {
            oSequence.set(k, rSequence.get(j));
            outputSequence[k++] = rightSequence[j++];
        }
    }   


    /**
     * # sort recursive function that first seperates the Info array and aux arraylists to right and left.
     * # and puts these right and left parts to merge sort.
     * # it does this operation until right and left parts reach 1 element length.
     * @param values # it takes map values.
     * @param aux # it takes map keys named aux.
     */
    private void sort(Info[] values, ArrayList<String> aux) { 
        if (values.length > 1) {
            int halfSize = values.length / 2;

            Info[] leftTable = new Info[halfSize];
            Info[] rightTable = new Info[values.length - halfSize]; 

            System.arraycopy(values, 0, leftTable, 0, halfSize); 
            System.arraycopy(values, halfSize, rightTable, 0, values.length - halfSize);

            ArrayList<String> lTable = new ArrayList<>();
            ArrayList<String> rTable = new ArrayList<>(); 

            for(int i = 0;i < halfSize;++i) {
                lTable.add(aux.get(i));
            }

            for(int i = halfSize;i < values.length;++i) {
                rTable.add(aux.get(i));
            }

            sort(leftTable, lTable); 
            sort(rightTable, rTable);
    
            merge(values, leftTable, rightTable, aux, lTable, rTable);
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