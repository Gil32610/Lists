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

    public void descendingRepeatedInsetionSort(T content) {
        DoublyLinkedNode<T> current;
        DoublyLinkedNode<T> node = new DoublyLinkedNode<>(content);
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
            this.quantity++;
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            System.out.println("Content added!");
        } else if (content.compareTo(this.head.getContent()) > 0) {
            this.head.setPrevious(node);
            node.setNext(this.head);
            this.head = node;
            this.quantity++;
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            System.out.println("Content added!");
        } else if (content.compareTo(this.tail.getContent()) < 0) {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            this.tail = node;
            this.quantity++;
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            System.out.println("Content added!");
        } else if (content.compareTo(this.head.getContent()) == 0) {
            node.setNext(this.head);
            this.head.setPrevious(node);
            node.setPrevious(this.tail);
            this.tail.setNext(node);
            this.head = node;
            this.quantity++;
        } else if (content.compareTo(this.tail.getContent()) == 0) {
            current = this.tail;
            while (current.getPrevious().getContent().compareTo(content) == 0) {
                current = current.getPrevious();
                if (current == this.head) {
                    break;
                }
            }
            node.setNext(current);
            node.setPrevious(current.getPrevious());
            current.setPrevious(node);
            current.getPrevious().setNext(node);
            this.quantity++;
        } else {
            current = this.head.getNext();
            while (current != this.head) {
                if (content.compareTo(current.getContent()) > 0) {
                    node.setNext(current);
                    node.setPrevious(current.getPrevious());
                    current.getPrevious().setNext(node);
                    current.setPrevious(node);
                    this.quantity++;
                    System.out.println("Content added!");
                    break;
                }
                if (content.compareTo(current.getContent()) == 0) {
                    node.setNext(current);
                    node.setPrevious(current.getPrevious());
                    current.setPrevious(node);
                    current.getPrevious().setNext(node);
                    this.quantity++;
                    break;
                } else {
                    current = current.getNext();
                }
            }
        }

    }

    public void descendingInsetionSort(T content) {
        DoublyLinkedNode<T> current;
        DoublyLinkedNode<T> node = new DoublyLinkedNode<>(content);
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
            this.quantity++;
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            System.out.println("Content added!");
        } else if (content.compareTo(this.head.getContent()) > 0) {
            this.head.setPrevious(node);
            node.setNext(this.head);
            this.head = node;
            this.quantity++;
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            System.out.println("Content added!");
        } else if (content.compareTo(this.tail.getContent()) < 0) {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            this.tail = node;
            this.quantity++;
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            System.out.println("Content added!");
        } else if (content.compareTo(this.head.getContent()) == 0) {
            System.out.println("Already exists");
        } else if (content.compareTo(this.tail.getContent()) == 0) {
            System.out.println("Already exists");
        } else {
            current = this.head.getNext();
            while (current != this.head) {
                if (content.compareTo(current.getContent()) > 0) {
                    node.setNext(current);
                    node.setPrevious(current.getPrevious());
                    current.getPrevious().setNext(node);
                    current.setPrevious(node);
                    this.quantity++;
                    System.out.println("Content added!");
                    break;
                }
                if (content.compareTo(current.getContent()) == 0) {
                    System.out.println("Already exists");
                    break;
                } else {
                    current = current.getNext();
                }
            }
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

    public DoublyLinkedNode<T> search(T content) {
        DoublyLinkedNode<T> current = new DoublyLinkedNode<T>(content);
        if (this.isEmpty()) {
            return null;
        } else if (this.head.getNext() == this.head) {
            if (content.compareTo(this.head.getContent()) == 0) {
                return this.head;
            } else {
                return null;
            }
        } else if (content.compareTo(this.head.getContent()) == 0) {
            return this.head;
        } else if (content.compareTo(this.tail.getContent()) == 0) {
            return this.tail;
        } else {
            DoublyLinkedNode<T> aNode = this.head.getNext();
            while (aNode != this.head) {
                if (content.compareTo(aNode.getContent()) == 0) {
                    return aNode;
                }
                aNode = aNode.getNext();
            }
        }
        return null;
    }

    public void showReverse() {
        DoublyLinkedNode<T> current;

        if (this.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            current = this.head;
            for (int i = 0; i < this.quantity; i++) {
                System.out.println(current.getContent() + " ");
                current = current.getNext();
            }
            System.out.println(" ");
        }
    }

    public void remove(T content) {
        if (this.isEmpty()) {
            System.out.println("No elements on the list!");
        } else if (this.head.getNext() == this.head) {
            if (content.compareTo(this.head.getContent()) == 0) {
                this.head = null;
                this.tail = null;
                this.quantity = 0;
                System.out.println("Element was removed!");
            } else {
                System.out.println("Was not added to the list!");
            }
        } else if (content.compareTo(this.head.getContent()) == 0) {
            this.head = this.head.getNext();
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            this.quantity--;
            System.out.println("The element remotion was on the head");
        } else if (content.compareTo(this.tail.getContent()) == 0) {
            this.tail = this.tail.getPrevious();
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
            this.quantity--;
            System.out.println("The element remotion was on the tail");
        } else {
            DoublyLinkedNode<T> current = search(content);
            if (current != null) {
                DoublyLinkedNode<T> previous = current.getPrevious();
                DoublyLinkedNode<T> next = current.getNext();
                previous.setNext(next);
                next.setPrevious(previous);
                System.out.println("removed!");
                this.quantity--;
            } else {
                System.out.println("Element not added to the list!");

            }

        }
    }
}
