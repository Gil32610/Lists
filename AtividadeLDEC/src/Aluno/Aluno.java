package Aluno;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private String matricula;
    private double media;
    private int faltas;

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public Aluno(String nome, String matricula, double media, int faltas) {
        this.nome = nome;
        this.matricula = matricula;
        this.media = media;
        this.faltas = faltas;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getMedia() {
        return this.media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public int getFaltas() {
        return this.faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", matricula=" + matricula + ", media=" + media + ", faltas=" + faltas + "]";
    }

    @Override
    public int compareTo(Aluno a) {
        int result;
        result = this.matricula.compareTo(a.matricula);
        return result;
    }

}
