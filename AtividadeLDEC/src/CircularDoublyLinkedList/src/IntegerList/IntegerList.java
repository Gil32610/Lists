package IntegerList;

import br.unicap.edi.cdll.CircularDoublyLinkedList;

public class IntegerList {
    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> numList = new CircularDoublyLinkedList<>();
        for (int i = 0; i < 21; i++) {
            numList.insertLast(i);
        }
        System.out.println("Lista 1 original:");
        numList.showAll();
        CircularDoublyLinkedList<Integer> numList1 = numList.dividir();
        System.out.println("Lista 2");
        numList1.showAll();
        System.out.println("Lista 1:");
        numList.showAll();

        numList.concatenar(numList1);
        System.out.println("Lista 1 concatenada:");
        numList.showAll();
        System.out.println("Lista 2 atualmente:");
        numList1.showAll();
    }
}
