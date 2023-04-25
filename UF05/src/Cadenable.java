/**
 * Interfície       Cadenable.java
 * Aquesta interfície, descriu el funcionament dels mètodes d'instància de la 
 * classe Cadena
 * @author José Javier Faro Rodríguez
 * @version 1.0 - Afegits comentaris de documentació de javadoc
 */

public interface Cadenable {
    /**
     * Retorna un nou objecte Cadena igual al referenciat (un altre objecte)
     * @return Cadena  - Nou objecte amb el mateix contingut
     */
    public Cadena clona();
    /**
     * Retorna true si la cadena té el mateix contingut que s
     * @param s  Cadena a comparar
     * @return   boolean de valor true si s i la cadena son iguals
     */
    public boolean equals(Cadena s);
    /**
     * Concatena a la cadena cad de l'objecte la cadena s que passem com a paràmetre
     * @param s  (Cadena) - Cadena per cocatenar a la cadena de l'objecte (per la dreta)
     */
    public void concat(Cadena s);
    /**
     * Concatena a la cadena cad de l'objecte la String s que passem com a paràmetre
     * @param s  (String) - Cadena per cocatenar a la cadena de l'objecte (per la dreta)
     */
    public void concat(String s);
    /**
     * Concatena a la cadena cad de l'objecte el caràcter c que passem com a paràmetre
     * @param c  (char) - Caràcter per cocatenar a la cadena de l'objecte (per la dreta)
     */
    public void concat(char c);
    /**
     * Insereix el caràcter c en la posició n de la Cadena
     * Si n es menor que 0 o major que cad.length(), retorna sense fer res 
     * @param c  Caràcter a inserir a la cadena
     * @param n  Desplaçament sobre la cadena on insertar c
     */
    public void insert(char c,int n);
    /**
     * Esborra de la cadena el caràcter en posició n
     * @param n  Desplaçament del caràcter a treure de la cadena
     */
    public void delete(int n);
    /**
     * Esborra en la cadena tots els caràcters iguals a c
     * @param c  Caràcter a eliminar de la cadena
     */
    public void deleteAll(char c);
    /**
     * Permuta els caràcters en posicions x e y de la cadena.
     * Si x o y no es troben dins de la cadena, retorna sense fer res
     * @param x  Posició en la cadena del primer caràcter a permutar
     * @param y  Posició en la cadena del segon caràcter a permutar
     */
    public void permuta(int x, int y);

    /**
     * Esborra la cadena (el resultat és que la longitu de la cadena es fa 0)
     */
    public void clear();

    /**
     * Retorna la longitud de la cadena
     * @return  int amb la longitud de la cadena
     */
    public int length();
}