package Azienda;

import java.util.Objects;

public class Persona implements Comparable<Persona>{
    private String nome;
    private String cognome;

    public static void main(String[] args) {
        Persona p = new Persona("Antonietta","Frega");
        Persona p1 = new Persona("Antonie","Frega");
        System.out.println(p.compareTo(p1));
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public Persona(String nome, String cognome ){
        if(nome==null || cognome==null) throw new IllegalArgumentException();
        
        this.nome=nome.strip().toLowerCase();
        this.cognome=cognome.strip().toLowerCase();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return Objects.equals(getNome(), persona.getNome()) && Objects.equals(getCognome(), persona.getCognome());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", cognome='").append(cognome).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCognome());
    }

    @Override
    public int compareTo(Persona o) {

        if(o.equals(this)) return 0;

        int c = comp(o.cognome.charAt(0),cognome.charAt(0));

        if( c != 0 ) return c;

        int i = 1;

        while(c==0){
            if(o.cognome.equals(cognome)) break;

            if(i>=o.cognome.length()) return -1;
            if(i>=cognome.length()) return 1;

            c = comp(o.cognome.charAt(i),o.cognome.charAt(i));
            if( c != 0 ) return c;
            i++;
        }

        i = 0;
        while(c==0){

            if(i>=o.nome.length()) return -1;
            if(i>=nome.length()) return 1;

            c = comp(o.nome.charAt(i),nome.charAt(i));
            if( c != 0 ) return c;
            i++;
        }

        return 0;

    }

    private int comp(char s1, char s2 ) {

        if(s1>s2) return 1;
        else if(s1<s2) return -1;
        return 0;

    }


}

