// LinkedList.java

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private Node head;

    private static class Node {
        int key;
        List<String> data;
        Node next;

        Node(int key, String data) {
            this.key = key;
            this.data = new ArrayList<>();
            this.data.add(data);
            this.next = null;
        }
    }

    
    public void insert(int key, String data) {
        if (head == null) {
            head = new Node(key, data);
        } else {
            Node current = head;
            while (current != null) {
                if (current.key == key) {
                    current.data.add(data);
                    return;
                }
                if (current.next == null) break;
                current = current.next;
            }
            current.next = new Node(key, data);
        }
    }

    
    public List<String> search(int key) {
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                return current.data;
            }
            current = current.next;
        }
        return null; 
    }
}


