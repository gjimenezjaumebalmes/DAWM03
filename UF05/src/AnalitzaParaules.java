import java.util.*;

class Main {
    public static void main(String[] args) {
        // Definim la llista de paraules a analitzar
//        List<String> paraules = Arrays.asList("hola", "hol", "ohla", "adios", "idosa", "diosa");
//        List<String> paraules = Arrays.asList("gos", "gat", "ocell", "peix", "hamster");
        List<String> paraules = Arrays.asList("elefant", "girafa", "lleó", "zebra");
        analitzaParaules(paraules);
    }

    public static void analitzaParaules(List<String> s) {
        // Creem un mapa per emmagatzemar els conjunts de paraules
        Map<String, Set<String>> conjunts = new HashMap<>();

        // Recorrem totes les paraules de la llista
        for (String paraula : s) {
            // Generem la clau a partir de la paraula (les lletres ordenades)
            String clau = generateKey(paraula);

            // Si ja hi ha un conjunt amb aquesta clau, afegim la paraula
            // Si no, creem un nou conjunt amb la paraula
            if (conjunts.containsKey(clau)) {
                conjunts.get(clau).add(paraula);
            } else {
                Set<String> nouConjunt = new HashSet<>();
                nouConjunt.add(paraula);
                conjunts.put(clau, nouConjunt);
            }
        }

        // Recorrem tots els conjunts de paraules
        for (Map.Entry<String, Set<String>> entry : conjunts.entrySet()) {
            String clau = entry.getKey();
            Set<String> conjuntParaules = entry.getValue();

            // Mostrem el conjunt de paraules amb les mateixes lletres
            System.out.println("Conjunt de paraules amb les mateixes lletres per aquest conjunt:");
            System.out.println(conjuntParaules.toString());

            // Creem un mapa per emmagatzemar la quantitat de vegades que apareix cada lletra
            // en cada paraula del conjunt
            Map<Character, Integer>[] mapes = new Map[conjuntParaules.size()];
            int index = 0;
            for (String paraula : conjuntParaules) {
                Map<Character, Integer> mapa = new HashMap<>();
                for (char lletra : paraula.toCharArray()) {
                    if (mapa.containsKey(lletra)) {
                        mapa.put(lletra, mapa.get(lletra) + 1);
                    } else {
                        mapa.put(lletra, 1);
                    }
                }
                mapes[index++] = mapa;
            }

            // Mostrem el mapa per a cada paraula del conjunt
            for (int i = 0; i < mapes.length; i++) {
                System.out.println("Mapa per a la paraula " + conjuntParaules.toArray()[i] + ":");
                for (Map.Entry<Character, Integer> entryMapa : mapes[i].entrySet()) {
                    System.out.println(entryMapa.getKey() + ": " + entryMapa.getValue());
                }
            }
        }
    }

    // Funció auxiliar per generar la clau a partir d'una paraula (les lletres ordenades)
    private static String generateKey(String word) {
        // Convertim la cadena en un vector de caràcters
        char[] chars = word.toCharArray();

        // L'ordenem amb el mètode sort de la classe Arrays
        Arrays.sort(chars);
        return new String(chars);
    }

}

