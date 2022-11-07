package Pessoa;

public class Pessoa {
    private String nome;
    private String RG;

    public Pessoa(String nome, String RG) {
        this.nome = nome;
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String rG) {
        RG = rG;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", RG=" + RG + "]";
    }
    

}
