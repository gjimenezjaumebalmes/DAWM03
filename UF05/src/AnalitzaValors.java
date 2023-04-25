// Importem la classe java.util per a poder utilitzar les llistes.
import java.util.*;


class Main {
    public static void analitzaValors(int[] v) {
        //Es crea crea una llista a partir dels valors de l'array
        List<Integer> llista = new ArrayList<>();
        for (int i = 0; i < v.length; i++) {
            llista.add(v[i]);
        }
        //Es crea mostra la llista original per pantalla
        System.out.println("Llista original: " + llista);

        //Es crea crea una llista ordenada a partir de la llista original i la mostra per pantalla
        List<Integer> llistaOrdenada = new LinkedList<>(llista);
        Collections.sort(llistaOrdenada);
        System.out.println("Llista ordenada: " + llistaOrdenada);

        //Es crea calcula la suma i la mitjana de la llista ordenada i les mostra per pantalla
        int sum = 0;
        for (int i : llistaOrdenada) {
            sum += i;
        }
        double avg = (double) sum / llistaOrdenada.size();
        System.out.println("Suma: " + sum);
        System.out.println("Mitjana: " + avg);

        //Es crea busca el valor mínim i màxim de la llista ordenada i els mostra per pantalla
        int min = Collections.min(llistaOrdenada);
        int max = Collections.max(llistaOrdenada);
        System.out.println("Valor mínim: " + min);
        System.out.println("Valor màxim: " + max);

        //Es crea un mapa a partir dels valors que apareixen a la llista ordenada i mostra el mapa per pantalla
        Map<Integer, Integer> mapa = new HashMap<>();
        for (int i = min; i <= max; i++) {
            mapa.put(i, Collections.frequency(llistaOrdenada, i));
        }
        System.out.println("Mapa: " + mapa);

        //Es crea una llista amb els valors que no apareixen a la llista original i la mostra per pantalla
        List<Integer> llistaNoApareixen = new LinkedList<>();
        for (int i = min; i <= max; i++) {
            if (!llista.contains(i)) {
                llistaNoApareixen.add(i);
            }
        }
        if (llistaNoApareixen.isEmpty()) {
            System.out.println("No hi ha valors que no apareguin a la llista.");
        } else {
            System.out.println("Valors que no apareixen a la llista: " + llistaNoApareixen);
        }

        // Es crea una llista que conté els valors que apareixen més vegades a la llista ordenada i la mostrem.
        int maxCount = 0;
        for (int i : llistaOrdenada) {
            int count = Collections.frequency(llistaOrdenada, i);
            if (count > maxCount) {
                maxCount = count;
            }
        }
        List<Integer> llistaMaxCount = new LinkedList<>();
        for (int i : llistaOrdenada) {
            if (Collections.frequency(llistaOrdenada, i) == maxCount) {
                llistaMaxCount.add(i);
            }
        }
        System.out.println("Valors que apareixen " + maxCount + " vegades: " + llistaMaxCount);

        // Es crea un conjunt de números enters a partir de la llista original sense duplicats.
        // Es recorre la llista original i es van afegint els elements al conjunt, això elimina els elements repetits.
        Set<Integer> conjunt = new HashSet<>();
        for (int i : llista) {
            conjunt.add(i);
        }
        System.out.println("Conjunt sense duplicats: " + conjunt);
    }

    public static void main(String[] args) {
//        int[] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 3, 3, 3, 6, 6, 6, 6, 9, 9, 12, 12, 12, 12, 12, 12, 12, 12};
//        int[] v = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20}
//        int[] v = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50}
        int[] v = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
//        int[] v = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30}
//        int[] v = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55}
        analitzaValors(v);
    }
}