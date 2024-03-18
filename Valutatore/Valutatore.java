package Valutatore;

import com.sun.source.tree.TryTree;

import java.util.*;

public class Valutatore{

    ArrayList<String> aaa = new ArrayList<>();

    public static void main(String[] args) {

        Valutatore v = new Valutatore();
        String s = "(3*4)+(5+5)";
        System.out.println(v.valutaEspressione(new StringTokenizer(s,"+,-,*,/,%,^,(,)",true)));

    }

    public Valutatore() {
        String[] s ={ "+","-","*","/","%","^"};

        for (String string : s)
            aaa.add(string);
    }

    public double valutaEspressione( StringTokenizer st ) {
        Stack<Double> num = new Stack<>();
        Stack<String> op = new Stack<>();

        while (st.hasMoreTokens()) {
            String n = st.nextToken();

            if(aaa.contains(n)) {
                if(op.size()>=1 && num.size()>=2) {
                    if (aaa.indexOf(n) < aaa.indexOf(op.peek())) {
                        double n1 = num.pop(), n2 = num.pop();
                        switch (op.pop()){
                        case "+" : n2+=n1; break;
                        case "-" : n2-=n1; break;
                        case "*" : n2*=n1; break;
                        case "/" : n2/=n1; break;
                        case "^" : n2 = (Math.pow(n2,n1)); break;
                        case "%" : n2%=n1;break;
                            default: throw new IllegalArgumentException("Espressione Malformata");
                        }
                        num.add(n2);
                    }
                }
                op.add(n);
            }
            else
                if(n.equals("(")) num.add(valutaEspressione(st));
            else
                if(n.equals(")")) {

                    if (num.size() == 1)
                        return num.pop();

                } else num.add(Double.parseDouble(n));

        }

        while (op.size()>0) {
            if(num.size()<2) throw new IllegalArgumentException("Espressione Malformata");
            double n1 = num.pop(), n2 = num.pop();
                switch (op.pop()){
                    
                    case "+" : n2+=n1; break;
                    case "-" : n2-=n1; break;
                    case "*" : n2*=n1; break;
                    case "/" : n2/=n1; break;
                    case "^" : n2 = (Math.pow(n2,n1)); break;
                    case "%" : n2%=n1;break;

                    default:throw new IllegalArgumentException("Espressione malformata");
                }
                num.add(n2);
        }

        return num.peek();
    }
}
