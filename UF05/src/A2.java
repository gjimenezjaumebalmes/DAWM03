import java.util.*; // Importem la classe java.util per a poder utilitzar les llistes.

class Main {

    private static boolean resultat(List<String> veins) {
        // Creem la funció privada resultat que retorna un valor boolean i rep una llista de strings anomenada veins com a paràmetre.
        if (veins.get(4).equals("Adam") || veins.indexOf("Adam") != 4) {
            // Si el valor a l'índex 4 de veins és "Adam" o bé "Adam" no està a la posició 4, retornem false.
            return false;
        }
        if (veins.get(0).equals("Bill") || veins.indexOf("Bill") != 0) {
            // Si el valor a l'índex 0 de veins és "Bill" o bé "Bill" no està a la posició 0, retornem false.
            return false;
        }
        if (veins.get(0).equals("Cora") || veins.get(4).equals("Cora")) {
            // Si el valor a l'índex 0 de veins és "Cora" o bé el valor a l'índex 4 de veins és "Cora", retornem false.
            return false;
        }
        if (veins.indexOf("Dale") <= veins.indexOf("Bill")) {
            // Si l'índex de "Dale" és menor o igual a l'índex de "Bill" a veins, retornem false.
            return false;
        }
        int indexCora = veins.indexOf("Cora"); // Creem una variable entera anomenada indexCora que conté l'índex de "Cora" a veins.
        int indexErin = veins.indexOf("Erin"); // Creem una variable entera anomenada indexErin que conté l'índex de "Erin" a veins.
        if (Math.abs(indexCora - indexErin) == 1) {
            // Si el valor absolut de la diferència entre indexCora i indexErin és igual a 1, retornem false.
            return false;
        }
        if (Math.abs(indexCora - indexErin) == 3) {
            // Si el valor absolut de la diferència entre indexCora i indexErin és igual a 3, retornem false.
            return false;
        }
        if (Math.abs(indexCora - indexErin) == 4) {
            // Si el valor absolut de la diferència entre indexCora i indexErin és igual a 4, retornem false.
            return false;
        }
        return true;
        // Si no es compleix cap de les condicions anteriors, retornem true.
    }


    public static void main(String[] args) {
        // Es crea una llista de strings i la inicialitza amb els noms "Adam", "Bill", "Cora", "Dale" i "Erin"
        List<String> veins = Arrays.asList("Adam", "Bill", "Cora", "Dale", "Erin");
        // Escriu per pantalla el tipus de la llista
        System.out.println("Tipus de la llista: " + veins.getClass().getName());
        // Escriu per pantalla el contingut de la llista
        System.out.println("Contingut de la llista: " + veins);
        // Es barrejan els elements de la llista fins que satisfa la condició de la funció "resultat"
        Collections.shuffle(veins);
        while (!resultat(veins)) {
            Collections.shuffle(veins);
        }
        System.out.println("Solució: " + veins);
    }
}
