import java.util.Iterator;
/**
 * Classe principal per provar l'iterador de la classe Cadena i els seus mètodes
 * estàtics
 * @author ----------- Guillem Jimenez Agullo ---------------
 * @version  1.0.0
 */
public class IterarCadena {
    public static void main(String[] args) {
        System.out.println("Construïm la cadena s amb el constructor public Cadena(String s)");
        // Cridem al constructor passant una cadena
        Cadena s = new Cadena("no hace sol en Barcelona aún");
        System.out.println("Cadena creada:      s = \"no hace sol en Barcelona aún\"");
        // Podem recòrrer la cadena creada amb el bucle for-each
        System.out.println("Recorregut i escriptura de la cadena amb un bucle for-each");
        for (Character c: s)
            System.out.print(c);
        System.out.println();
        // I també amb l'iterador
        System.out.println("Recorregut amb l'iterador i esborrament de les 'n' de la cadena");
        Iterator <Character> it = s.iterator();
        while (it.hasNext()){
            Character c = it.next();    // Ens quedem amb el caràcter següent
            System.out.print(c);
            if (c == 'n')               // Si el caràcter és una n, el traiem de la cadena
                it.remove();
        }
        System.out.println();
        // Escrivim la cadena, hem esborrat totes les 'n' d'aquesta
        System.out.println("Cadena s resultant sense les 'n'");
        System.out.println(s);
        System.out.println("\nJoc de proves dels mètodes estàtics de la classe Cadena");
        System.out.println("=======================================================");
        // Codi per provar els mètodes estàtics de la classe cadena
        // Creem un objecte Cadena a partir de la cadena s
        System.out.println("Creem un altre objecte Cadena sx amb el mètode Cadena.clone()");
        Cadena sx = Cadena.clone(s);
        // Comprovem que el seu contingut és el mateix que el de s
        System.out.println("Comparem amb la cadena s:   Cadena.equals(s,sx) =  " + Cadena.equals(s,sx));
        System.out.println("Cadena sx = " + sx + "  Longitud = " + Cadena.length(sx));
        System.out.println("hashCode de la cadena sx:     sx.hashCode() = " + sx.hashCode());
        System.out.println("Esborrem l'element de índex 5 de sx:  Cadena.delete(sx,5)");
        Cadena.delete(sx,5);    // Esborra l'element 5 de sx, es modifica sx
        System.out.println("Cadena sx = " + sx + "   Longitud = " + Cadena.length(sx));
        System.out.println("El codi hash de la cadena, un cop esborrat l'element ho ha canviat");
        System.out.println("sx.hashCode() = " + sx.hashCode());
        System.out.println("Creem la cadena sy, esborrant tots els caràcters 'e' de la cadena sx");
        Cadena sy = Cadena.deleteAll(sx,'e');   // sy Tindrà un hashCode diferent a sx
        System.out.println("Cadena sy = Cadena.deleteAll(sx,'e');   sy = " + sy);
        System.out.println("Esborrem tots els caràcters 'e' de la cadena sx també");
        Cadena.deleteAll('e',sx);   // El hashCode de sx no canviarà (és el mateix objecte
        System.out.println("Cadena.deleteAll('e',sx);   sx = " + sx);
        System.out.println("El hashCode de sx no ha canviat, és el mateix objecte, sy és un altre");
        System.out.println("sx.hashCode() = " + sx.hashCode() + "   sy.hashCode = " + sy.hashCode());
        System.out.println("Escrivim les cadenes sx i sy i les seves longituds");
        System.out.println("Cadena sx = " + sx + "   Longitud = " + Cadena.length(sx));
        System.out.println("Cadena sx = " + sy + "   Longitud = " + Cadena.length(sy));
        System.out.println("Executem:   Cadena.insert(sx,'$',5)");
        Cadena.insert(sx,'$',5);
        System.out.println("Cadena sx = " + sx + "   Longitud = " + Cadena.length(sx));
        System.out.println("Els mètodes concat, retornen una nova cadena (podrien no fer-ho també)");
        System.out.println("Cadena.concat(sy,\" hola\") =              " + Cadena.concat(sy," hola"));
        System.out.println("Cadena.concat(sx,new Cadena(\" adios\") =  " + Cadena.concat(sx," adios"));
        System.out.println("Cadena.concat(sx,'&') =  " + Cadena.concat(sx,'&'));
    }
}