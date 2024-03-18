package Secondatraccia2012.uno;
import java.util.Scanner;
import java.util.Stack;

import Secondatraccia2012.uno.*;
public class RPN {
    String exp;
    LinkedDeQueue<Character> operatori = new LinkedDeQueue<>();

    public RPN( String exp ) {
        this.exp=exp;
        operatori.offer('+');operatori.offer('*');operatori.offer('-');operatori.offer('/');
    }

    public RPN ( ) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Inserisci l'espressione mi raccomando premi invio");
        exp = sc.nextLine();
        operatori.offer('+');operatori.offer('*');operatori.offer('-');operatori.offer('/');
    }

    @Override
    public String toString() {
        return exp;
    }

    private LinkedDeQueue<Character> trovaOperatori( int i ) {
        LinkedDeQueue<Character> op = new LinkedDeQueue<>();
        for (; i < exp.length(); i++) {
            char el = exp.charAt(i);
            if(el!=' ');
            op.push(el);
        }
        return op;
    }


    public String valuta() {
        boolean b=false;

        LinkedDeQueue<Character> op = new LinkedDeQueue<>();
        Stack<Integer> num = new Stack<>();
        String a = "";

        for (int i = 0; i <exp.length(); i++) {
            char el = exp.charAt(i);

            if (operatori.contains(el)) { op = trovaOperatori(i); break; }

            if (el!=' ')
                a += el;

            else{
                num.push(Integer.parseInt(String.valueOf(a)));
                a="";
            }

        }

        if ( op.size()>=num.size()) throw new RuntimeException("Espressione Malformata");

        for (char o : op ){
            int n1 = num.pop();
            int n2 = num.pop();

            switch (o) {
                case '+' : n2+=n1; break;
                case '-' : n2-=n1; break;
                case '*' : n2*=n1; break;
                case '/' : n2/=n1; break;
                default : throw new RuntimeException("Espressione Malformata");
            }

            num.push(n2);

        }

        if(num.size()>1) throw new RuntimeException("Espresssione Malformata");
        return Integer.toString(num.peek());

    }

    public static void main(String[] args) {
        RPN rp = new RPN();
        System.out.println(rp.valuta());
    }

}

