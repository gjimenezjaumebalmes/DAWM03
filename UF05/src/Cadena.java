import java.util.Iterator;

public class Cadena implements Cadenable, Iterable<Character>, Cloneable {
    private String cadena;

    public Cadena() {
        cadena = "";
    }

    public Cadena(String s) {
        cadena = s;
    }

    @Override
    public String toString() {
        return cadena;
    }

    public void remove(char c) {
        Iterator<Character> it = iterator();
        while (it.hasNext()) {
            char currentChar = it.next();
            if (currentChar == c) {
                it.remove();
            }
        }
    }

    @Override
    public Iterator<Character> iterator() {
        return new CadenaIterator();
    }

    @Override
    public Cadena clone() {
        return new Cadena(cadena);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cadena) {
            Cadena other = (Cadena) obj;
            return cadena.equals(other.cadena);
        }
        return false;
    }

    public int length() {
        return cadena.length();
    }

    public void delete(int index) {
        StringBuilder sb = new StringBuilder(cadena);
        sb.deleteCharAt(index);
        cadena = sb.toString();
    }

    public static void deleteAll(char c, Cadena s) {
        StringBuilder sb = new StringBuilder(s.cadena);
        int index = 0;
        while (index < sb.length()) {
            if (sb.charAt(index) == c) {
                sb.deleteCharAt(index);
            } else {
                index++;
            }
        }
        s.cadena = sb.toString();
    }

    private class CadenaIterator implements Iterator<Character> {
        private int index = 0;
        private boolean canRemove = false;

        @Override
        public boolean hasNext() {
            return index < cadena.length();
        }

        @Override
        public Character next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            char c = cadena.charAt(index);
            index++;
            canRemove = true;
            return c;
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException();
            }
            StringBuilder sb = new StringBuilder(cadena);
            sb.deleteCharAt(index - 1);
            cadena = sb.toString();
            index--;
            canRemove = false;
        }
    }

}
