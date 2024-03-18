package Appello12cfu;

import java.util.*;

public interface Cruciverba {
    int getNumeroRighe();
    int getNumeroColonne();
    boolean contains( String parola );
    List<String> paroleOrizzontali();
    List<String> paroleVerticali();

}
