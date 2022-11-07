package Acesso;

import br.unicap.edi.dll.*;
import Pessoa.Pessoa;

public class AdvogadosSA {
    private DoublyLinkedList<Pessoa> acesso;

    public AdvogadosSA() {
        this.acesso = new DoublyLinkedList<Pessoa>(500);
    }

    public void cadastrar(Pessoa p) {
        if (this.acesso.isEmpty()) {
            this.acesso.insertLast(p);
        } else {
            DoublyLinkedNode<Pessoa> search = this.acesso.search(p);
            if (search == null) {
                this.acesso.insertLast(p);
            } else {
                System.out.println("Já cadastrado!");
            }
        }
    }

    public void cancelar() {
        if (this.acesso.isEmpty()) {
            System.out.println("Nenhum cadastro realizado!");
        } else {
            this.acesso.removeLast();
        }
    }

    public void exibir() {
        this.acesso.reverseShowAll();
    }

    public void verificar(String RG) {
        Pessoa p = new Pessoa(RG);
        DoublyLinkedNode<Pessoa> search = this.acesso.search(p);
        if (search != null) {
            System.out.println(search.getContent() + " está no prédio!");
        } else {
            System.out.println("Não está no prédio!");
        }
    }

    public void quantidade() {
        System.out.println("Há " + this.acesso.getQuantity() + " pessoa(s) no prédio.");
    }

    public void remover(String RG) {
        Pessoa p = new Pessoa(RG);
        this.acesso.removeNode(p);
        System.out.println("Operação concluída!");
    }
}
