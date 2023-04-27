import java.io.*; // importem classes per a l'entrada/sortida de dades
import java.util.ArrayList; // importem la classe ArrayList del paquet java.util
import java.util.Arrays; // importem la classe Arrays del paquet java.util
import java.util.HashMap; // importem la classe HashMap del paquet java.util
import java.nio.file.Files; // importem la classe Files del paquet java.nio.file
import java.nio.file.StandardCopyOption; // importem la classe StandardCopyOption del paquet java.nio.file


class Anagramas {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Ha de passar al programa el nom d'un fitxer de text amb les paraules del diccionari (una per línia)");
            System.exit(-1);
        }

        String nomFitxer = args[0]; // agafem el primer argument com a nom de fitxer
        String nomFitxerBackup = nomFitxer + ".backup";
        File fitxer = new File(nomFitxer);

        try { // comencem un bloc try-catch per gestionar possibles excepcions
            BufferedReader br = new BufferedReader(new FileReader(fitxer)); // creem un objecte BufferedReader per llegir el fitxer
            ArrayList<String> cadenas = new ArrayList<>(); // creem un ArrayList buit per emmagatzemar les cadenes

            String line; // definim una variable per guardar la línia llegida
            while ((line = br.readLine()) != null) {
                cadenas.add(line);
            }
            br.close();

            // Creem un backup del fitxer original
            File fitxerBackup = new File(nomFitxerBackup); // creem un objecte File per al fitxer de backup
            Files.copy(fitxer.toPath(), fitxerBackup.toPath(), StandardCopyOption.REPLACE_EXISTING);
            // fem una còpia del fitxer original al fitxer de backup, sobreescribint-lo si ja existeix

            // Creem un mapa per emmagatzemar les subllistes d'anagrames
            HashMap<String, ArrayList<String>> anagramas = new HashMap<>();  // creem un HashMap buit per emmagatzemar les subllistes d'anagrames

            // Busquem les cadenes que són anagrames entre si
            for (String cadena : cadenas) {
                // Convertim la cadena en un array de caràcters i els ordenem
                char[] caracteres = cadena.toLowerCase().toCharArray();
                Arrays.sort(caracteres);
                String clau = new String(caracteres);

                // Si la clau ja està en el mapa, afegim la cadena a la subllista corresponent
                if (anagramas.containsKey(clau))
                    anagramas.get(clau).add(cadena);
                    // Si la clau no està en el mapa, creem una nova subllista i l'afegim al mapa
                else {
                    ArrayList<String> subllista = new ArrayList<>();
                    subllista.add(cadena);
                    anagramas.put(clau, subllista);
                }
            }

            // Escrivim els anagrames al fitxer original
            BufferedWriter bw = new BufferedWriter(new FileWriter(fitxer));
            int numAnagramas = 0;
            for (ArrayList<String> subllista : anagramas.values()) {
                if (subllista.size() > 1) { // Si hi ha més d'una paraula, són anagrames
                    for (String anagrama : subllista) {
                        bw.write(anagrama + " ");
                    }
                    bw.newLine();
                    numAnagramas++;
                }
            }
            bw.close();

            System.out.println("Llegides " + cadenas.size() + " paraules del diccionari");
            System.out.println("S'han escrit els " + numAnagramas + " anagrames trobats al fitxer de partida");
            System.out.println("Té una còpia de seguretat del fitxer original al fitxer:");
            System.out.println(nomFitxerBackup);
        } catch (FileNotFoundException e) {
            System.err.println("No s'ha trobat el fitxer: " + nomFitxer);
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Error llegint/escribint el fitxer");
            e.printStackTrace();
            System.exit(-1);
        }
    }

}