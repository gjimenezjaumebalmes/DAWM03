// Importem la classe Scanner per llegir l'entrada de l'usuari
import java.util.Scanner;

// Creem una classe ProvaStringBuilder
class MainA1 {

    // Creem el mètode principal
    public static void main(String[] args) {

        // Creem un objecte Scanner per llegir l'entrada de l'usuari
        Scanner scanejat = new Scanner(System.in);

        // Declarem i inicialitzem la variable valorBuscat a 0
        int valorBuscat = 0;

        // Fem un bucle per assegurar-nos que l'usuari introdueix un valor vàlid
        do {
            System.out.print("Introdueix el valor a buscar a la següencia [1-10000000]: ");
            try {
                // Llegim el valor introduït per l'usuari i el transformem a un enter
                valorBuscat = Integer.parseInt(scanejat.nextLine());

                // Si el valor introduït no està dins el rang permès, mostrem un missatge d'error
                if (valorBuscat < 1 || valorBuscat > 10000000) {
                    System.out.println("El valor introduït ha d'estar entre 1 i 10000000");
                }
            } catch (NumberFormatException e) {
                // Si el valor introduït no és un enter, mostrem un missatge d'error
                System.out.println("El valor introduït ha de ser un nombre enter");
            }
        } while (valorBuscat < 1 || valorBuscat > 10000000);

        // Guardem el temps d'inici del càlcul amb StringBuilder
        // He utilizat System.nanoTime() en vers System.currentTimeMillis() per que System.nanoTime() es mes precis ja que mesura el temps en nanosegons en vers a milisegons
        long startTime = System.nanoTime();

        // Creem un objecte StringBuilder i afegim una seqüència de caràcters numèrics del 1 al 10000000
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 1; i <= 10000000; i++) {
            sbuilder.append(i);
        }

        // Convertim el StringBuilder a un String per poder buscar el valor introduït per l'usuari
        String sequencia = sbuilder.toString();
        int posicio = sequencia.indexOf(String.valueOf(valorBuscat));

        // Guardem el temps final del càlcul amb StringBuilder i calculem el temps que ha tardat
        long endTime = System.nanoTime();
        double temps = (endTime - startTime) / 1000000000.0;

        // Mostrem la longitud de la cadena generada
        System.out.println("\nLongitud de la cadena generada: " + sequencia.length() + "\n");

        // Mostrem la posició del valor introduït per l'usuari si apareix a la seqüència generada
        if (posicio != -1) {
            System.out.println("El valor " + valorBuscat + " apareix per primer cop a la següència\n");
            System.out.println("en posició : " + posicio + "\n");
        } else {
            System.out.println("El valor " + valorBuscat + " no apareix a la següència generada\n");
        }

        // Mostrem el temps que ha tardat el càlcul amb StringBuilder
        System.out.println("Temps en fer el càlcul amb StringBuilder : " + temps + " segons\n");

        // Guardem el temps d'inici del càlcul amb l'operador
        startTime = System.nanoTime();

        // Creem una cadena de caràcter usant l'operador "+"
        String sequencia2 = "";
        for (int i = 1; i <= 10000000; i++) {
            sequencia2 += i;
        }
        // Busquem la posició del valor introduït per l'usuari a la cadena generada amb l'operador "+"
        int posicio2 = sequencia2.indexOf(String.valueOf(valorBuscat));

        // Guardem el temps final del càlcul amb l'operador i calculem el temps que ha tardat
                endTime = System.nanoTime();
        temps = (endTime - startTime) / 1000000000.0;

        // Mostrem la longitud de la cadena generada amb l'operador "+"
        System.out.println("\nLongitud de la cadena generada: " + sequencia2.length() + "\n");
        // Mostrem la posició del valor introduït per l'usuari si apareix a la seqüència generada amb l'operador "+"
        if (posicio2 != -1) {
            System.out.println("El valor " + valorBuscat + " apareix per primer cop a la següència\n");
            System.out.println("en posició : " + posicio2 + "\n");
        } else {
            System.out.println("El valor " + valorBuscat + " no apareix a la següència generada\n");
        }

        // Mostrem el temps que ha tardat el càlcul amb l'operador +
        System.out.println("Temps en fer el càlcul amb l'operador + : " + temps + " segons.");

    }

}