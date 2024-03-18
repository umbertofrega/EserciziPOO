package matrice_sparsa;

public abstract class MatriceSparsaAbs implements MatriceSparsa{

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nr_colonne()+nr_righe());
        sb.append("[[");
        for (int i = 0; i < nr_righe(); i++) {
            if(i!=0) sb.append("\n[");
            for (int j = 0; j < nr_colonne(); j++) {
                sb.append(get(i,j));
                sb.append(", ");
            }
            sb.delete(sb.length()-2,sb.length());
            sb.append("]");
            sb.append(",");
        }

        sb.delete(sb.length()-1,sb.length());
        sb.append("]");

        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 33;

        for (int i = 0; i < nr_righe(); i++)
            for (int j = 0; j < nr_colonne(); j++)
                hashCode*=Double.valueOf(get(i,j)).hashCode();

        return hashCode;
    }
}
