package Integer;

import br.unicap.edi.dlld.*;
import java.util.Scanner;

public class IntegerList {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> integerLinked = new DoublyLinkedList<Integer>(20);
        Scanner s = new Scanner(System.in);
        int op;
        do{

        }while(op!= 0)

    }

    public static void options() {
        System.out.println("1 - Inserir inteiro na lista");
        System.out.println("2 - Remover inteiro da lista");
        System.out.println("3 - Exibir inteiros de forma decrescente");
        System.out.println("4 - Exibir inteiros de forma crescente");
        System.out.println("5 - Procurar e Exibir inteiro");
        System.out.println("0 - Encerrar");
    }
}
