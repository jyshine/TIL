package org.example.queue;
class Queue<T> {
    class Node<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add (T item) {
        Node<T> t = new Node<>(item);

        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }
}
public class QueueTest {
}
