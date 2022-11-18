package CircularDoublyLinkedList.br.unicap.edi.cdll;

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
        if (this.isEmpty()) {
            System.out.println("Lista vazia!");
        } else {
            int i = 0;
            DoublyLinkedNode<T> current = this.head;
            while (i != this.quantity) {
                System.out.println(current.getContent());
                current = current.getNext();
                i++;
            }
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

    public void concatenar(CircularDoublyLinkedList<T> lista2) {
        if (lista2.isEmpty()) {
            System.out.println("Lista 2 está vazia");
        } else {
            if (lista2.head.getNext() == lista2.head) {
                this.insertLast(lista2.head.getContent());
                lista2.removeFirst();

            } else {
                DoublyLinkedNode<T> current = lista2.head;
                while (!lista2.isEmpty()) {
                    this.insertLast(current.getContent());
                    current = current.getNext();
                    lista2.removeFirst();
                }

            }
        }
    }

    public CircularDoublyLinkedList<T> dividir() {
        CircularDoublyLinkedList<T> aList;
        if (this.isEmpty()) {
            return this;
        }
        aList = new CircularDoublyLinkedList<>();
        int split = this.quantity / 2;
        DoublyLinkedNode<T> current = this.tail;
        for (int i = 0; i < split; i++) {
            aList.insertFirst(current.getContent());
            current = current.getPrevious();
            this.removeLast();
        }
        return aList;
    }

    public void ascendingInsetionSort(T content) {
        DoublyLinkedNode<T> current;
        DoublyLinkedNode<T> node = new DoublyLinkedNode<>(content);
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
            this.quantity++;
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            System.out.println("Content added!");
        } else if (content.compareTo(this.head.getContent()) < 0) {
            this.head.setPrevious(node);
            node.setNext(this.head);
            this.head = node;
            this.quantity++;
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            System.out.println("Content added!");
        } else if (content.compareTo(this.tail.getContent()) > 0) {
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

}
