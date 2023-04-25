import java.util.HashMap;
import java.util.Scanner;

class Main {

        public static void main(String[] args) {
                // Crear el diccionari amb les conversions
                HashMap<String, Integer> conversions = new HashMap<String, Integer>();
                conversions.put("XXS", 36);
                conversions.put("2XS", 36);
                conversions.put("XS", 38);
                conversions.put("S", 40);
                conversions.put("M", 42);
                conversions.put("L", 44);
                conversions.put("XL", 46);
                conversions.put("XXL", 48);
                conversions.put("2XL", 48);
                conversions.put("XXXL", 50);
                conversions.put("3XL", 50);

                // Llegir la talla a convertir de l'usuari
                Scanner scanner = new Scanner(System.in);
                System.out.println("Programa conversor de talles de roba");
                System.out.println("Exemple: XXL");
                System.out.print("Introduïu la talla internacional XXS, 2XS, XS, S, M, L, XL, XXL, 2XL, XXXL, 3XL: ");
                String talla = scanner.nextLine().toUpperCase();

                // Comprovar si la talla existeix al diccionari
                if (conversions.containsKey(talla)) {
                        // Mostrar la conversió
                        int tallaEspanyola = conversions.get(talla);
                        System.out.println("La talla " + talla + " es correspón amb la talla " + tallaEspanyola);
                } else {
                        // Mostrar un missatge d'error si la talla no existeix
                        System.out.println("Talla " + talla + " no reconeguda");
                        System.out.println("Només es reconeixen les talles:");
                        System.out.println(conversions.keySet());
                }
        }
}