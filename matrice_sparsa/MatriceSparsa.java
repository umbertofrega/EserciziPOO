package matrice_sparsa;

public interface MatriceSparsa{
    int nr_righe();
    int nr_colonne();
    double get( int i, int j ); //restituisce il valore dell’elemento <i,j>
    void set( int i, int j, double v ); //assegna v all’elemento <i,j>. Attne se v=0.

    default MatriceSparsa add( MatriceSparsa ms ){
        if(ms.nr_righe()!=nr_righe() || ms.nr_colonne()!=nr_colonne()) throw new IllegalArgumentException();

        MatriceSparsa s = factory(nr_righe(),nr_colonne());
        for (int i = 0; i < nr_righe(); i++)
            for (int j = 0; j < nr_colonne(); j++) {
                double ps = ((this.get(i, j)) + ms.get(nr_righe(), nr_colonne()));
                if(ps!=0) s.set(i,j,ps);
            }
        return s;
    } //crea e ritorna una nuova matrice this+ms

    default MatriceSparsa mul( MatriceSparsa ms ){
        if(ms.nr_colonne()!=nr_righe() || nr_colonne()!=ms.nr_righe() ) throw new IllegalArgumentException();
        MatriceSparsa s = factory(nr_righe(),nr_colonne());

        for (int i = 0; i < nr_righe(); i++) {

        }

        return s;
    } //crea e ritorna una nuova matrice this*ms

    default MatriceSparsa mul( double scalare ){
        if(scalare == 0) return null;

        MatriceSparsa s = factory(nr_righe(),nr_colonne());
        for (int i = 0; i < nr_righe(); i++)
            for (int j = 0; j < nr_colonne(); j++) {
                double ps = (this.get(i,j))*scalare;
                if( ps!=0 ) s.set(i,j,ps);
            }

        return s;
    } //crea e ritorna una nuova matrice this*scalare

    MatriceSparsa factory( int nr_righe, int nr_colonne );

    default MatriceSparsa copia(){
        MatriceSparsa s = factory(nr_righe(),nr_colonne());
        for (int i = 0; i < nr_righe(); i++)
            for (int j = 0; j < nr_colonne(); j++)
                s.set(i,j,this.get(i,j));

        return s;
    } //crea e ritorna una copia della matrice sparsa this

    default double determinanteG(){
        if(nr_righe()!=nr_colonne()) throw new IllegalArgumentException();

        MatriceSparsa s = copia();
        double det = 0;


        for (int i = 1; i < i+1; i++) {
            for (int j = 0; j < nr_colonne(); j++) {
                if(i!=j && get(i,j)!=0){

                }
            }
        }

        return det;
    }


    static double determinanteL(MatriceSparsa a) {
        if(a.nr_righe()!=a.nr_colonne()) throw new IllegalArgumentException();
        int k = a.nr_righe() - 1;
        int h = a.nr_colonne() - 1;

        if(a.nr_righe()==2) return determinante4(a);

        double det = determinanteL(minore(a,k,h));

        for (int i = 0; i < a.nr_righe(); i++)
            det += Math.pow(-1,0+i)*a.get(0,i)*determinanteL(minore(a,k,h));

        return det;

    }

    //oppure
    static MatriceSparsa minore(MatriceSparsa a, int i, int j) {
        MatriceSparsa s = a.factory(a.nr_righe()-1,a.nr_colonne()-1);

        for (int k = 0; k < s.nr_colonne(); k++) {
            if(k==i) continue;
            for (int l = 0; l < s.nr_colonne(); l++) {
                if(l==j) continue;
                s.set(i,j,a.get(i,j));
            }
        }

        return s;
    }

    static double determinante4(MatriceSparsa a) {
        if(a.nr_righe()!=2 || a.nr_colonne()!=2) throw new IllegalArgumentException();

        return (a.get(0,0)*a.get(1,1))-(a.get(0,1)*a.get(1,0));

    }


}//MatriceSparsa

