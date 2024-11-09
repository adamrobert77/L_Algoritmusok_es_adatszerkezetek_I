import java.util.*;

public class Main {
    public static void main(String[] args) {


        // olvassuk be az inputokat (beolvasast kulon fuggvenyeben implementalva)
        List<String[]> allStringInputs = new ArrayList<>(readInputs());
        List<Integer> results = new ArrayList<>();

        // iteraljunk vegig az osszes teszten, hivjuk meg az egyikre az implementalt fuggvenyt
        for( String[] cases : allStringInputs) {
            TreeSet<String> variationCollector = new TreeSet<>();
            generateAllVariations(variationCollector, cases, 0);

            // rakjuk ossze az input szot, amelynek a poziciojat keressuk
            String searchedString = String.join(" ", cases);

            // tegyuk at egy ArrayList-be a halmaz tartalmat, es keressuk meg hanyadik a keresett szo
            List<String> sortedVariations = new ArrayList<>(variationCollector);
            // taroljuk el a poziciot
            results.add(sortedVariations.indexOf(searchedString) + 1);
        }

        // irjuk ki az eredmenyeket

        for(Integer result : results) {
            System.out.println(result);
        }
    }



    // generaljuk le rekurzivan az osszes variaciot
    // treeset-et alkalmazunk variaciok tarolasara, ezaltal eleve abc sorrendbe rendezve azokat
    public static void generateAllVariations(TreeSet<String> variationCollector, String[] wordParts, int index) {

        // amennyiben elertunk a legmelyebb szintet, kossuk ossze a szavakat/betuket az adott sorrendben, es taroljuk el a treesetben
        if (index == wordParts.length) {
            variationCollector.add(String.join(" ", wordParts));
            return;
        }

        // minden iteracioban csereljunk fel ketto szot, hivjuk meg a tombbel a fuggvenyt a kovetkezo indexnel
        for (int i = index; i < wordParts.length; i++) {
            swapWords(wordParts, index, i);
            generateAllVariations(variationCollector, wordParts, index + 1);
            // tegyuk vissza az eredeti poziciora a ket felcserelt szot, ezaltal biztosan megtalalva minden megoldast
            swapWords(wordParts, index, i);
        }
    }


    // implementaljuk a szavak felcsereleset
    public static void swapWords(String[] array, int i, int j) {
        if(i != j) {
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }


    // implementaljuk a beolvassast
    public static List<String[]> readInputs() {
        Scanner sc = new Scanner(System.in);

        // nezzuk meg, hogy hany esetunk van
        int numberOfLists = sc.nextInt();

        List<String[]> allStringInputs = new ArrayList<>();

        for(int i = 0; i<numberOfLists; i++) {
            int numberOfChars = sc.nextInt(); // beolvassuk, hogy az adott iteracioban hany db string-et kell beolvasni
            sc.nextLine(); // ugorjunk a kovetkezo sorra

            String inputString = sc.nextLine(); // ovlassuk be a komplett sort
            String[] splittedStrings = inputString.split(" "); // a szokozok menten felbontjuk a beolvasott sort

            allStringInputs.add(splittedStrings); // tegyuk be az osszes esetunk koze

            if(numberOfChars != splittedStrings.length) { // ha valami nem lett beolvasva, irjunk ki hibat
                System.out.println("Olvasasi hiba ---> bemeneti karakterek szama " + numberOfChars + " beolvasott karakterek szama: " + splittedStrings.length);
            }
        }
        sc.close();

        /*
        // beolvasott tetelek kiiratasa
        for(int i = 0; i<numberOfLists; i++) {
            String[] output = allStringInputs.get(i);
            for(int j = 0; j<output.length; j++) {
                System.out.print("j: " + j + " string: " + output[j] + " ");
            }
            System.out.println();
        }
        */


        return allStringInputs;
    }
}

