package Integer;

import br.unicap.edi.dlld.*;
import java.util.Scanner;

public class IntegerList {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> integerLinked = new DoublyLinkedList<Integer>(20);
        Scanner s = new Scanner(System.in);
        int number;
        int op;
        do {
            System.out.println("Selecione a opção: ");
            options();
            op = Integer.parseInt(s.nextLine());
            switch (op) {
                case 1:
                System.out.println("Informe o inteiro: ");
                number = Integer.parseInt(s.nextLine());
                integerLinked.insertionSort(number);
                    break;
                case 2:
                System.out.println("Informe o inteiro: ");
                number = Integer.parseInt(s.nextLine());
                integerLinked.removeNode(number);
                    break;
                case 3:
                integerLinked.showAll();
                    break;
                case 4:
                integerLinked.reverseShowAll();
                    break;
                case 5:
                System.out.println("Informe o inteiro: ");
                number = Integer.parseInt(s.nextLine());
                integerLinked.searchContent(number);
                    break;
                case 0:
                System.out.println("Concluido!");
                    break;
                default:
                System.out.println("Opção inválida!");
                    break;

            }
        } while (op != 0);

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
