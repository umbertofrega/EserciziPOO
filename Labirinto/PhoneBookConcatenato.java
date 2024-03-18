package Labirinto;

import java.util.*;

public class PhoneBookConcatenato extends AbstractPhoneBook{
    private Nodo testa = null;
    private int size = 0;

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBookConcatenato();
        pb.add(new Persona("Gianni",56));
        pb.add(new Persona("Pippo",34));
        pb.add(new Persona("A",34));
        System.out.println(pb.size());
        System.out.println(pb);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(size == 0 ) return "[]";

        Iterator pb = new PBIterator();
        StringBuilder sb = new StringBuilder(size);
        sb.append("[");
        while(pb.hasNext()){
            sb.append(pb.next());
            sb.append(";");
        }
        sb.trimToSize();
        sb.delete(sb.length()-1,sb.length());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void clear() {
        PBIterator pb = new PBIterator();
        while (pb.hasNext()){
            pb.next();
            pb.remove();
        }
        size = 0;
    }

    @Override
    public void resort(Comparator<Persona> c) {
                
    }

    @Override
    public void add(Persona p) {
        PBIterator pb = new PBIterator();
        pb.add(p);

    }

    @Override
    public Iterator<Persona> iterator() {
        return new PBIterator();
    }

    private class PBIterator implements Iterator<Persona> {
        Nodo curr;
        Nodo pre;

        @Override
        public boolean hasNext() {

            if (curr == null) return testa != null;
            return curr.succ != null;

        }

        @Override
        public Persona next() {
            if(!hasNext()) throw new NoSuchElementException();

            if(curr == null)
                curr = testa;
            else {
                pre = curr;
                curr = curr.succ;
            }

            return curr.info;

        }

        @Override
        public void remove() {

            if(curr == null) throw new ConcurrentModificationException();
            if( curr == pre ) throw new ConcurrentModificationException();

            if(curr == testa) {
                testa = testa.succ;
                pre = null;
            }else {
                pre.succ = curr.succ;
            }
            curr = pre;
            size--;
        }

        public void add(Persona x) {
            Nodo n = new Nodo();
            n.info = x;
            n.succ = null;
            if (testa == null || testa.info.compareTo(x) > 0) {//primi due casi
                //n va aggiunto in testa
                n.succ = testa; //cosi collochiamo n prima della testa o capolista
                testa = n;
            } else {//x va inserito dopo il primo elemento
                //troviamo la posizione del primo elemento >= ad x
                Nodo pre = testa, cor = testa.succ; //assegnazioni "furbe"
                while (cor != null && cor.info.compareTo(x) < 0) {
                    //avanziamo di una posizione sulla lista
                    pre = cor;
                    cor = cor.succ;
                }
                //ultimi due casi: inserimento intermedio o dopo l'ultimo
                //entrambi i casi sono gestiti inserendo n tra pre e cor
                n.succ = cor; //n va prima di cor
                //sicuramente pre!=null
                pre.succ = n;
            }
            size++;
        }

    }

    private class Nodo{

        private Persona info;
        private Nodo succ;

        public Nodo(Persona p){
            this.info = p;
            this.succ= null;
        }

        public Nodo(){

            this.info = null;
            this.succ = null;

        }

        public Nodo copyOf(Nodo n){
            if(n==null) return null;

            Nodo n2 = new Nodo();

            n2.info = new Persona(n.info.getNome(),n.info.getTelefono());

            n2.succ = n.copyOf(n);

            return n2;
        }


        @Override
        public String toString() {
            return info.toString();
        }
    }
}
