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
            aNode.setPrevious(this.tail);
            this.tail = aNode;
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
            this.quantity++;
        }
    }

    public void showAll() {
        int i = 0;
        DoublyLinkedNode<T> current = this.head;
        while (i != this.quantity) {
            System.out.println(current.getContent());
            current = current.getNext();
            i++;
        }
    }

    // public void showAll() {
    // DoublyLinkedNode<T> current;
    // if (this.isEmpty()) {
    // System.out.println("Empty list");
    // } else {
    // while (true) {
    // if (current == this.head) {
    // break;
    // }
    // current = this.head;
    // System.out.println(current.getContent());
    // current = current.getNext();

    // }
    // }

    // }

    public void removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Empty list");
        } else if (this.head.getNext() == this.head) {
            this.head = null;
            this.tail = null;
            this.quantity = 0;
        } else {
            this.head = this.head.getNext();
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            this.quantity--;
        }
    }

    public void removeLast() {
        if (this.isEmpty()) {
            System.out.println("Empty list");
        } else if (this.head.getNext() == this.head) {
            this.head = null;
            this.tail = null;
            this.quantity = 0;
        } else {
            this.tail = this.tail.getPrevious();
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
            this.quantity--;
        }
    }
}
