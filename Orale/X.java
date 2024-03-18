package Orale;

public class X {
    String s = "45 13 12 26 7 8 9 ";
    String regex = "((3[6-9])+)";

    public static void main(String[] args) {
        String s = "33 34 3";
        String regex = "^([1-9]|[1-2][0-9]|3[0-5])(\\s+([1-9]|[1-2][0-9]|3[0-5]))*$";
        String INTERO = "^([\\-\\+][\\d]+)(\\s+([\\-\\+][\\d]+))*$";
        String REALE = "(\\-?[\\d]+|([0-9]+)?\\.[\\d]+)([Ee][\\-\\+]?[0-9]{1,3})/[FfDd]?";

        String s2 = "+2 +3 -6";
        if(!s.matches(regex)) System.out.println("no");
        if(s2.matches(INTERO)) System.out.println("sbrugna");
        if(s2.matches(REALE)) System.out.println("GATTI");
    }

}
