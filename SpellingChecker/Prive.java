package SpellingChecker;

public class Prive {
    public static void main(String[] args) {
        int min = 0;

        int x=1,y=2,z=3;

        if( x <= y && x<= z )
            min =  1+x;
        else if( y<=x && y<=z )
            min = 1+y;
        else if ( z<=x && z<= y)
            min = 1+z;

        System.out.println(min);
    }
}
