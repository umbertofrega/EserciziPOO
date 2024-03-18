package Labirinto;

import java.util.Objects;

public class Persona {
    private String nome;
    private int telefono;


    public static void main(String[] args) {
        Persona p = new Persona("Anna",34);
        Persona p2 = new Persona("Antonio",3);
        System.out.println(p.compareTo(p2));
    }

    public String getNome() {
        return nome;
    }

    public int getTelefono() {
        return telefono;
    }

    public Persona(String s, int n){
        this.nome=s;
        this.telefono=n;
    }

    public int compareTo(Persona p){
        if(p.nome.equals(nome)) return 0;

        if(nome.charAt(0)>p.nome.charAt(0))
            return 1;

        else if(nome.charAt(0)<p.nome.charAt(0))
            return -1;


        String nome1 = nome.substring(0,nome.length()-1).toLowerCase();
        String nome2 = p.nome.substring(0,p.nome.length()-1).toLowerCase();

        for(;;) {

            if(nome.length() == 0 )
                return -1;

            if(nome2.length()==0)
                return 1;

            if(nome1.charAt(0)<nome2.charAt(0))
                return 1;

            else if(nome1.charAt(0)>nome2.charAt(0))
                return -1;

            nome1 = nome1.substring(1,nome1.length());
            nome2 = nome2.substring(1,nome2.length());

        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return telefono == persona.telefono && Objects.equals(nome, persona.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefono);
    }
}
