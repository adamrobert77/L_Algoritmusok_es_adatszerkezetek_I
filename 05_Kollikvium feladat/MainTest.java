import java.util.*;

public class MainTest {

    public static void main(String[] args) {
        List<String[]> testCases = new ArrayList<>();

        // SPOJ tesztek
        testCases.add(new String[]{"a", "b", "c", "d"});
        testCases.add(new String[]{"d", "c", "b", "a"});
        testCases.add(new String[]{"mrsmith"});
        testCases.add(new String[]{"a", "aaaaaa", "aaaaa", "aaaa", "b", "bb"});
        // egyeni tesztek
        testCases.add(new String[]{"zing", "mcdonalds", "simonsburger", "mackoburger"});
        testCases.add(new String[]{"macbook", "desktopPC", "linux", "casioFX570es"});
        testCases.add(new String[]{"paradicsom", "szalami", "uborka", "sajt", "vaj"});
        testCases.add(new String[]{"sz", "e", "g", "e", "d", "i", "t", "t", "i", "k"});

        System.out.println();
        System.out.println("/// Tesztesetek alabb ///");
        System.out.println("-------------------------");
        assertTestResult(new String[]{"a", "b", "c", "d"}, 1);
        assertTestResult(new String[]{"d", "c", "b", "a"}, 24);
        assertTestResult(new String[]{"mrsmith"}, 1);
        assertTestResult(new String[]{"a", "aaaaaa", "aaaaa", "aaaa", "b", "bb"}, 55);
        assertTestResult(new String[]{"zing", "mcdonalds", "simonsburger", "mackoburger"},22 );
        assertTestResult(new String[]{"macbook", "desktopPC", "linux", "casioFX570es"}, 22);
        assertTestResult(new String[]{"paradicsom", "szalami", "uborka", "sajt", "vaj"}, 9);
        assertTestResult(new String[]{"sz", "e", "g", "e", "d", "i", "t", "t", "i", "k"}, 325271);
    }

    private static void assertTestResult(String[] testCase, int expected) {
        TreeSet<String> variationCollector = new TreeSet<>();
        Main.generateAllVariations(variationCollector, testCase, 0);

        String searchedString = String.join(" ", testCase);
        List<String> sortedVariations = new ArrayList<>(variationCollector);
        int position = sortedVariations.indexOf(searchedString) + 1;

        if (position == expected) {
            System.out.println("Teszteset sikeres: " + Arrays.toString(testCase) + " --- Elvart pozicio: " + expected + " --- Kalkulalt pozicio: " + position);
        } else {
            System.out.println("Teszteset sikertelen:  " + Arrays.toString(testCase) + " --- Elvart pozicio: " + expected + " --- Kalkulalt pozicio: " + position);
        }
    }
}
