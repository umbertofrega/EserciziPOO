package Appello12cfu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Schema implements Cruciverba{

    char[][] schema;

    public Schema(char[][] schema ){

        this.schema=schema;

    }

    public static void main(String[] args) {
        char[] c = {'p','i','z','z','a'};
        char[] c1= {'c','i','a','o','o'};

        char[][] aa = {c,c1};
        Schema s = new Schema(aa);

        System.out.println(s.paroleOrizzontali());
        System.out.println(s.paroleVerticali());
    }

    @Override
    public int getNumeroRighe() {
        return schema.length;
    }

    @Override
    public int getNumeroColonne() {
        return schema[0].length;
    }

    @Override
    public boolean contains(String parola) {
        return (paroleOrizzontali().contains(parola) || paroleVerticali().contains(parola));
    }

    @Override
    public List<String> paroleOrizzontali() {
        List<String> o = new LinkedList<>();
        for (int i = 0; i < schema.length; i++) {
            String s = "";
            for (int j = 0; j < schema[i].length; j++) {
                s+=schema[i][j];
            }
            o.add(s);
        }
        o.sort(this::compareTo);
        return o;
    }

    private int compareTo(String s, String s1) {

        if(s.equals(s1)) return 0;

        if(s.length()>s1.length())
            return 1;
        if(s.length()<s1.length())
            return -1;

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i)>s1.charAt(i))
                return 1;
            if(s.charAt(i)<s1.charAt(i))
                return -1;

        }

        return 0;
    }

    @Override
    public List<String> paroleVerticali() {
        List<String> o = new LinkedList<>();

        for (int i = 0; i < schema[0].length; i++) {
            String s = "";
            for (int j = 0; j < schema.length; j++) {
                s += schema[j][i];
            }
            o.add(s);
        }
        o.sort(this::compareTo);
        return o;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Schema{");
        sb.append("schema=").append(Arrays.toString(schema));
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schema)) return false;
        Schema schema1 = (Schema) o;
        return Arrays.equals(schema, schema1.schema);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(schema);
    }
}
