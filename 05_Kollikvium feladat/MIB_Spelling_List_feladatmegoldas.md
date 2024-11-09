
### 05_Kollikvium feladat (SPOJ/OKTV)

# MIB Spelling List: SPOJ (concept: easy, implementation: medium)
![image](https://github.com/user-attachments/assets/593ddde1-7364-414f-a76c-792bc2a78501)
Forrás: https://www.spoj.com/problems/MIB/
## Feladatmegoldás (tesztesetek MainTest.java-ban)
1. Olvassuk be az adatokat a feladatleírásban megadott feltételek értelmében. Implementáció: `public static List<String[]> readInputs()` (mindegyik szón végigiterálunk, 
2. Iteráljunk végig az összes teszteseten egyenként.
3. Hozzunk létre egy TreeSet tárolót, kihasználva azt a tulajdonságát, hogy minden elemet rendezve tárol magában
4. Hívjuk meg a `generateAllVariations` függvényt a létrehozott TreeSet-re, a vizsgálandó szóra, és a 0. indexre (legutóbbi a rekurzív implentáció miatt szükséges)
5. A TreeSet-ből hozzunk létre egy ArrayList-et, majd az indexOf függvény használatával keressük meg, hogy az adott szó hanyadik a listában. Hozzáadva +1-et megkapjuk, hogy az adott bemeneti szó, hanyadik variáció egy ABC sorrendbe rendezett listában. Az eredményt elmentjük egy tárolóban `results.add(sortedVariations.indexOf(searchedString) + 1);`
  

### generateAllVariations függvény

```java
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
```

1. A függvény első elágazásában vizsgáljuk, hogy a bemeneti index egyenlő-e a szótagok tömb hosszával. Ha igen, akkor eljutottunk a rekurzió legmélyebb pontjába, fűzzük össze a kapott szavakat, tegyük bele a `variationCollector` tárolóba, majd térjünk vissza.
2. Amennyiben bemeneti index kisebb, mint a szótagok tömb hossza, úgy `int i = index`-től iteráljunk végig minden szótag pozíción. A ciklusváltozó `int i = index` és a bemeneti index `int index` segítségével cseréljünk fel a bemeneti szótagok tömbben `String[] wordParts`-ban kettő szótagot.
3. Cserét követően hívjuk meg rekurzívan a függvényt a módosított szótagok tömbbel, és növelt bemeneti index-szel.
4. Ezt követően állítsuk vissza a bemeneti szótagok tömbb rekurzió előtti sorrendjét.

Az implementált rekurzív függvény lehetővé teszi, hogy minden lehetséges variációt megkapjunk.
