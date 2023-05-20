package hw7;

import java.util.LinkedHashMap;
import java.util.Set;


/**
 * # class MyMap.
 */
public class MyMap {

    private LinkedHashMap <String, Info> map;
    private int mapSize;
    private String str;


    /**
     * # constructor of MyMap class.
     * @param preprocessed # it takes preprocessed input from main.
     */
    public MyMap (String preprocessed) {
        this.map = new LinkedHashMap <String, Info>();
        this.mapSize = 0;
        this.str = preprocessed;

        fillMap();
    }


    /**
     * # it used in merge sort algorithm for sorted map. inserts keys and values to map.
     * @param key # it takes keys.
     * @param value # it takes values.
     */
    public void add(String key, Info value) {
        map.put(key, value);
    }


    /**
     * # gets size of map.
     * @return # returns map size.
     */
    public int getMapSize() {
        return mapSize;
    }


    /**
     * # it used for obtain key elements and insert to aux arraylist.
     * @return # returns map.
     */
    public LinkedHashMap<String, Info> getMap() {
        return map;
    }


    /**
     * # it converts the string sentence to word form.
     * @return # returns new form.
     */
    private String[] stringToWord () {
        return str.split("\\s+");
    }


    /**
     * # the fillMap function that inserts the letters of the words to keys. 
     * # also insterts the words to values that contains mentioned letters. 
     */
    private void fillMap () {
        
        String words[] = stringToWord();

        for(int i = 0;i < words.length;++i) {
            String newWord = words[i];
            
            for(int j = 0; j < newWord.length();++j) {
                String character = Character.toString(newWord.charAt(j));
                
                if (!map.containsKey(character)) {
                    Info info = new Info();
                    info.push(newWord);
                    map.put(character, info);
                    mapSize++;
                }

                else {
                    map.get(character).push(newWord);
                }
            }
        }
    }


    /**
     * # it used in merge algorithm for obtain values of map.
     * @param index # to obtain specific value.
     * @return # if gets value returns value, otherwise returns null.
     */
    public Info getValue (int index) {
        int i = 0;
        for (String key : map.keySet()) {
            if (i == index) {
                return map.get(key);
            }
            i++;
        }
        return null;
    }
    

    /**
     * # prints unsorted map.
     */
    @Override
    public String toString () {
        String str = "";
        Set<String> keySet = map.keySet();
        for(String key : keySet) {
            Info value = map.get(key);
            System.out.println("Letter: " + key + " - " + value);
        }
        return str;
    }
}