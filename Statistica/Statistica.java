package Statistica;

import java.io.FileNotFoundException;

public interface Statistica extends Iterable<String>{
    void arrivo( String p );
    int frequenza( String p );
    String moda();
    String mediana();
}//Statistica

