package Main;

import Cadastrar.Cadastro;
import java.util.Scanner;
import Aluno.Aluno;
import Turma.Turma;

public class Main {
    public static void main(String[] args) {
        Turma t1 = new Turma("Biologia");
        Turma t2 = new Turma("Matemática");
        Turma t3 = new Turma("Física");
        Turma t4 = new Turma("Educação física");

        Scanner s = new Scanner(System.in);
        int op;
        do {
            Turma t;
            System.out.println("Informe qual a turma:");
            pickTurma();
            op = Integer.parseInt(s.nextLine());
            switch (op) {
                case 1:
                    t = t1;
                    operateClass(t);
                    break;
                case 2:
                    t = t2;
                    operateClass(t);
                    break;
                case 3:
                    t = t3;
                    operateClass(t);
                    break;
                case 4:
                    t = t4;
                    operateClass(t);
                    break;
                default:
                    break;
            }
        } while (op != 0);

    }

    public static void pickTurma() {
        System.out.println("1 - Turma de biologia");
        System.out.println("2 - turma de matemática");
        System.out.println("3 - turma de física");
        System.out.println("4 - turma de educação física");
        System.out.println("0 - sair");
    }

    public static void turmaOptions() {
        System.out.println("1 - cadastrar novo aluno");
        System.out.println("2 - Lista de alunos");
        System.out.println("3 - consultar aluno");
        System.out.println("4 - Alterar média");
        System.out.println("5 - Alterar quantidade de faltas");
        System.out.println("6 - exibir dados de um aluno");
        System.out.println("7 - remover um aluno da turma");
        System.out.println("0 - encerrar");
    }

    public static void operateClass(Turma t) {
        Scanner s = new Scanner(System.in);
        int op;
        do {
            System.out.println("Selecione a opção:");
            turmaOptions();
            op = Integer.parseInt(s.nextLine());
            switch (op) {
                case 1:
                    Cadastro.cadastrarAluno(t);
                    break;
                case 2:
                    Cadastro.listar(t);
                    break;
                case 3:
                    Aluno a = Cadastro.consultar(t);
                    if (a != null) {
                        System.out.println(a);
                    } else {
                        System.out.println("Não cadastrado");
                    }
                    break;
                case 4:
                    Cadastro.alterarMedia(t);
                    break;
                case 5:
                    Cadastro.alterarFaltas(t);
                    break;
                case 6:
                    Cadastro.exibirDados(t);
                    break;
                case 7:
                    Cadastro.remover(t);
                    break;
                case 0:
                    System.out.println("Até mais!");
                    break;
                default:
                    break;
            }

        } while (op != 0);
    }
}
