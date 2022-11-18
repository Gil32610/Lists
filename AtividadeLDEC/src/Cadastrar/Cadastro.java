package Cadastrar;

import Turma.Turma;
import java.util.Scanner;
import Aluno.Aluno;
import CircularDoublyLinkedList.br.unicap.edi.cdll.*;

public class Cadastro {

    public static void cadastrarAluno(Turma t) {
        Scanner s = new Scanner(System.in);
        Aluno a;
        String nome, matricula;
        System.out.println("Informe o nome:");
        nome = s.nextLine();
        System.out.println("Informe a matrícula:");
        matricula = s.nextLine();
        a = new Aluno(nome, matricula);
        t.getTurma().insertLast(a);
        System.out.println("Aluno adicionado a turma!");
    }

    public static void listar(Turma t) {
        t.getTurma().showAll();
    }

    private static Aluno consultar(Turma t) {
        Scanner s = new Scanner(System.in);
        String matricula;
        Aluno a;
        DoublyLinkedNode<Aluno> search;
        System.out.println("Informe a matricula:");
        matricula = s.nextLine();
        a = new Aluno(matricula);
        search = t.getTurma().search(a);
        if (search == null) {
            return null;
        } else {
            return search.getContent();
        }

    }

    public static void alterarMedia(Turma t) {
        double media;
        Aluno a = consultar(t);
        Scanner s = new Scanner(System.in);
        if (a == null) {
            System.out.println("Não foi possivel realizar a operação pois a matrícula não existe no cadastro!");
        } else {
            System.out.println("Informe a nova média do aluno:");
            media = Double.parseDouble(s.nextLine());
            a.setMedia(media);
            System.out.println("Media alterada!");
        }

    }

    public static void alterarFaltas(Turma t) {
        Scanner s = new Scanner(System.in);

        Aluno a = consultar(t);
        int faltas;
        if (a == null) {
            System.out.println("Não foi possivel realizar a operação pois a matrícula não existe no cadastro!");
        } else {
            System.out.println("Informe a quantidade de faltas do aluno");
            faltas = Integer.parseInt(s.nextLine());
            a.setFaltas(faltas);
            System.out.println("Número de faltas acrescido ou abonado!");
        }
    }

    public static void exibirDados(Turma t) {
        Scanner s = new Scanner(System.in);
        DoublyLinkedNode<Aluno> search;
        String matricula;
        Aluno a = consultar(t);
        if (a == null) {
            System.out.println("Não foi possivel encontrar o aluno no cadastro!");
        } else {
            System.out.println(a);
        }
    }

    public static void remover(Turma t) {
        Scanner s = new Scanner(System.in);
        DoublyLinkedNode<Aluno> search;
        String matricula;
        Aluno a;
        System.out.println("Informe a matricula:");
        matricula = s.nextLine();
        a = new Aluno(matricula);
        search = t.getTurma().search(a);
        if (search == null) {
            System.out.println("Não foi possivel encontrar o aluno no cadastro!");
        } else {
            a = search.getContent();
            t.getTurma().remove(a);
            System.out.println("Aluno removido!");
        }
    }
}
