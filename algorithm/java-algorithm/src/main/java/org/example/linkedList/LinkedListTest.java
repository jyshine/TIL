package org.example.linkedList;

//class Node {
//    int data;
//    Node next = null;
//
//    public Node(int data) {
//        this.data = data;
//    }
//
//    void append(int data){
//        Node end = new Node(data);
//        Node n = this;
//        while(n.next != null){
//            n = n.next;
//        }
//        n.next = end;
//    }
//
//    void delete(int d) {
//        Node n = this;
//        while (n.next != null) {
//            if (n.next.data == d) {
//                n.next = n.next.next;
//            }else {
//                n = n.next;
//            }
//        }
//    }
//    void retrieve() {
//        Node n = this;
//        while (n.next != null) {
//            System.out.print(n.data + " -> ");
//            n = n.next;
//        }
//        System.out.println(n.data);
//    }
//
//}

class LinkedList {
    Node header;

    static class Node{
        int data;
        Node next = null;
    }

    LinkedList() {
        header = new Node();
    }
    void append(int data){
        Node end = new Node();
        end.data = data;
        Node n = header;

        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    void delete(int d) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
            }else {
                n = n.next;
            }
        }
    }
    void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    void removeDups(){
        Node n = header;
        while(n != null && n.next != null){
            Node r = n;
            while(r.next != null){
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }


    }
}
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(2);
        ll.append(4);
        ll.retrieve();
        ll.removeDups();
        ll.retrieve();
    }
}
