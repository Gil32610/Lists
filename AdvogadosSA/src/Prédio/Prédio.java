package Prédio;

import java.util.Scanner;
import Pessoa.Pessoa;
import Acesso.*;

public class Prédio {
    public static void main(String[] args) {
        int op;
        String nome, RG;
        AdvogadosSA adv = new AdvogadosSA();

    }

    public static void options() {
        System.out.println("1 - Fazer checkin\n" + "2 - Exibir pessoas no prédio\n" + "3 - Verificar pessoa\n"
                + "4 - Quantidade de pessoas no prédio\n" + "5 - Fazer checkout\n" + "0 - Encerrar");
    }
}
