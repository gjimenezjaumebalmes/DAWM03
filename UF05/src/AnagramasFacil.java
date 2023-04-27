import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/**
 * Ejemplo de programa para encontrar anagrams
 * @author      ChatGPT
 */
public class AnagramasFacil {
public static void main(String[] args) {
      String s;
      // Creamos una lista de cadenas de texto
      ArrayList<String> cadenas = new ArrayList<>();
      cadenas.add("car");
      cadenas.add("rac");
      cadenas.add("arc");
      cadenas.add("race");
      cadenas.add("care");
      cadenas.add("dog");
      cadenas.add("res");
      cadenas.add("god");
      // Creamos un mapa para almacenar las sub-listas de anagramas
      HashMap<String, ArrayList<String>> anagramas = new HashMap<>();
      // Buscamos las cadenas que son anagramas entre sí
      for (String cadena : cadenas) {
         // Convertimos la cadena en un arreglo de caracteres y lo ordenamos
         char[] caracteres = cadena.toCharArray();
         Arrays.sort(caracteres);
         String clave = new String(caracteres);
         
         // Si la clave ya está en el mapa, agregamos la cadena a la sub-lista correspondiente
         if (anagramas.containsKey(clave))
            anagramas.get(clave).add(cadena);
         // Si la clave no está en el mapa, creamos una nueva sub-lista y la agregamos al mapa
         else {
            ArrayList<String> sublista = new ArrayList<>();
            sublista.add(cadena);
            anagramas.put(clave, sublista);
         }
      }
      // Mostramos las sub-listas de anagramas por pantalla
      System.out.println("Las sub-listas de anagramas son:");
      for (ArrayList<String> sublista : anagramas.values())
         System.out.println(sublista);
   }  
}
