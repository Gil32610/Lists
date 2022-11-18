package Turma;

import CircularDoublyLinkedList.br.unicap.edi.cdll.*;
import Aluno.*;

public class Turma {

    private CircularDoublyLinkedList<Aluno> turma;
    private String discipline;

    public Turma(String discipline) {
        this.discipline = discipline;
        turma = new CircularDoublyLinkedList<Aluno>();
    }

    public CircularDoublyLinkedList<Aluno> getTurma() {
        return this.turma;
    }

    public void setTurma(CircularDoublyLinkedList<Aluno> turma) {
        this.turma = turma;
    }

    public String getDiscipline() {
        return this.discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Turma [discipline=" + discipline + "]";
    }

}
