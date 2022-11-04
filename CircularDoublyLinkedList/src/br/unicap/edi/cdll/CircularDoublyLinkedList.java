package br.unicap.edi.cdll;

public class CircularDoublyLinkedList<T extends Comparable<T>> {
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;
    private int capacity;
    private int quantity;

    public boolean isEmpty() {
        if (this.quantity == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void insertFirst(T content) {
        DoublyLinkedNode<T> aNode = new DoublyLinkedNode<T>(content);
        if (this.isEmpty()) {
            this.head = aNode;
            this.tail = aNode;
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
            this.quantity++;
        } else {
            aNode.setNext(this.head);
            this.head.setPrevious(aNode);
            this.head = aNode;
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
            this.quantity++;
        }
    }

    public void insertLast(T content) {
        DoublyLinkedNode<T> aNode = new DoublyLinkedNode<T>(content);
        if (this.isEmpty()) {
            this.head = aNode;
            this.tail = aNode;
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
            this.quantity++;
        } else {
            this.tail.setNext(aNode);
            this.tail = aNode;
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
            this.quantity++;
        }
    }
}
