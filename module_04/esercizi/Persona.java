package esercizi;

import java.util.Objects;

public class Persona {
    String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

}

class Studente extends  Persona{

    String matricola;

    public Studente(String nome, String n) {
        super(nome);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studente studente = (Studente) o;
        return Objects.equals(matricola, studente.matricola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricola);
    }
}