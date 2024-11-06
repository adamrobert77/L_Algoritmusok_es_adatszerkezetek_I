import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // inputok:
        // 1.: ermek darabszama (int)
        // 2.: penzosszeg (kifizetendo) (int)
        // 3...n: ermek (int)
        // return: int szukseges_ermek_darabszama


        // standard inputrol olvassuk be az ertekeket
        Scanner scanner = new Scanner(System.in);

        // beolvassuk az ermek darabszamat es a penzosszeget
        int numberOfCoins = scanner.nextInt();
        int sumOfMoney = scanner.nextInt();

        // beolvassuk az ermek ertekeit
        int[] coins = new int[numberOfCoins];
        for (int i = 0; i < numberOfCoins; i++) {
            coins[i] = scanner.nextInt();
        }

        scanner.close();

        // inicializaljunk egy tarolot
        // mindegyik index legyen egyenlo a vizsgalando penzosszeggel - tehat a meret legyen sumOfMoney+1
        int[] resultContainer = new int[sumOfMoney + 1];

        // ertekek legyenek egyenloek sumOfMoney+1-gyel ---> ha valamire nincs megoldasunk, ez az ertek jelzi, ellenkezo esetben atirjuk a megfelelo darabszamra
        Arrays.fill(resultContainer, sumOfMoney+1);


        // sumOfMoney = 0 osszeget 0 ermebol tudjuk kirakni, ezt rogzitjuk
        resultContainer[0] = 0;

        // iteraljunk vegig 1-tol a vizsgalando penzosszegig, addig folyamatosan toltsuk a tarolonkat
        for (int i = 1; i <= sumOfMoney; i++) {

            // menjunk vegig az osszes ermen, vonjuk ki az osszegbol
            int j = 0;
            while(j < coins.length) {
              
                // ha a kivonas eredmenye nem negativ, megnezzuk melyik esetben kerul a legkevesebb ermebe a kifizetes
                // ha az osszeg amelyre visszaerkezunk nem fizetheto ki semmilyen erme kombinacioval, ugy a jelenleg vizsalt erteke is sumOfMoney+1 marad, nem rontjuk el az output-ot
                if (i - coins[j] >= 0) {
                    resultContainer[i] = Math.min(resultContainer[i], resultContainer[i - coins[j]] + 1);
                }
                j++;
            }
        }

        // nezzuk meg, hogy talaltunk-e megoldast, ha igen, adjuk vissza az ermek szamat, ellenkezo esetben adjunk vissza -1-et
        if(resultContainer[sumOfMoney] < sumOfMoney+1) {
            int result = resultContainer[sumOfMoney];
            System.out.println(result);
        } else {
            int result = -1;
            System.out.println(result);
        }
    }
}
