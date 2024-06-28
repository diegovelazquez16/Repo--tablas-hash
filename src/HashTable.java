// HashTable.java

import java.util.List;

public class HashTable {
    private int size;
    private LinkedList[] table;
    private int hashType; 

    public HashTable(int size, int hashType) {
        this.size = size;
        this.hashType = hashType;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList();
        }
    }


    private int hashDivision(int key) {
        return key % size;
    }

   
    private int hashMultiplicative(int key) {
        double A = 0.618; 
        double temp = key * A;
        return (int) (size * (temp - Math.floor(temp)));
    }

  
    private int getHashIndex(int key) {
        if (hashType == 0) {
            return hashDivision(key);
        } else {
            return hashMultiplicative(key);
        }
    }

   
    public void insert(int key, String data) {
        int index = getHashIndex(key);
        table[index].insert(key, data);
    }

   
    public List<String> search(int key) {
        int index = getHashIndex(key);
        return table[index].search(key);
    }
}


