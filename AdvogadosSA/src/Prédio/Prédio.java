package Prédio;

import java.util.Scanner;

import Pessoa.Pessoa;
import Acesso.*;

public class Prédio {
    public static void main(String[] args) {
        int op;
        String nome, RG;
        AdvogadosSA adv = new AdvogadosSA();
        Scanner s = new Scanner(System.in);
        Pessoa p;

        do {
            System.out.println("Selecione a operação: ");
            options();
            op = Integer.parseInt(s.nextLine());
            switch (op) {
                case 1:
                    System.out.println("Informe o nome: ");
                    nome = s.nextLine();
                    System.out.println("Informe o RG:");
                    RG = s.nextLine();
                    p = new Pessoa(nome, RG);
                    adv.cadastrar(p);
                    System.out.println("Deseja cancelar a operação?");
                    System.out.println("1- sim\n" + "2 - não");
                    op = Integer.parseInt(s.nextLine());
                    if (op == 1) {
                        adv.cancelar();
                    }

                    break;
                case 2:
                    adv.exibir();
                    break;
                case 3:
                    System.out.println("Informe o RG da pessoa: ");
                    RG = s.nextLine();
                    adv.verificar(RG);
                    break;
                case 4:
                    adv.quantidade();
                    break;
                case 5:
                    System.out.println("Informe o RG da pessoa: ");
                    RG = s.nextLine();
                    adv.remover(RG);
                    break;
                case 0:
                    System.out.println("Concluído!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 0);

    }

    public static void options() {
        System.out.println("1 - Fazer checkin\n" + "2 - Exibir pessoas no prédio\n" + "3 - Verificar pessoa\n"
                + "4 - Quantidade de pessoas no prédio\n" + "5 - Fazer checkout\n" + "0 - Encerrar");
    }
}
