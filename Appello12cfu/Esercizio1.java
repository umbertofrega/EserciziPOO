package Appello12cfu;

import java.util.Stack;

public class Esercizio1 {

    String regex = "[0-9]+ [\s]+ [\\+,\\*,\\-,\\/]+";
    Stack<Nodo> nodoStack = new Stack<Nodo>();

    public static void main(String[] args) {

        Esercizio1 e = new Esercizio1();
        e.build("3 3 /");

    }

    void build(String rpn){



    }

    record Nodo(int info){


        @Override
        public String toString() {
            return info+"";
        }

    }


}
