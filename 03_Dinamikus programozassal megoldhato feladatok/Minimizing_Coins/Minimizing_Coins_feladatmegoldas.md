### 03_Dinamikus programozással megoldható feladatok

# Minimizing Coins feladatleírás // CSES, közepes nehézség
Forrás: https://cses.fi/problemset/task/1634/
Teszt: https://cses.fi/problemset/submit/1634/ (bejelentkezést igényel, Main.java feltöltésével 18 teszteset fut le)
## Feladatmegoldás
1. Olvassuk be std input-ról az összes változót.
2. A feladat megoldását dinamikus programozással kell megoldani, ezért hozzunk létre egy tömböt a már kiszámolt eredmények tárolására. A tömb index számai a pénzösszeget reprezentálják, és a 0 összeget is értelmezzük, ezért a tömb mérete: `pénzösszeg + 1`, ahol `index = 0 <--> pénzösszeg = 0  index = 1 <--> pénzösszeg = 1 és a felső határ index = pénzösszeg`.  ---->`int[] resultContainer = new int[sumOfMoney + 1];`
3. Rögzítjük a kiindulási esetet, amely: `resultContainer[0] = 0`, hiszen 0 pénzösszeg kifizetéséhez 0 érme szükséges.
4. Végigiterálunk `index=1-től index=pénzösszeg-ig` a teljes tömbön, mindegyik pénzösszegre megvizsgáljuk, hogy hány érmével fizethető ki, rögzítjük a feltételeknek megfelelő esetet.

```java
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
```

Az algoritmus megnézi, hogy, ha adott érmét kivonunk az összegből, az nem negatív-e, ha az igaz, akkor az eredménytárolónkba elmentjük a darabszámot az alábbi feltétel alapján: ` resultContainer[i] = Math.min(resultContainer[i], resultContainer[i - coins[j]] + 1);`  
  
- Amennyiben olyan pénzösszegre "léptünk vissza", amely kifizethető "x" érméből, akkor az eredmény tároló eredménye ezen összeg darabszáma+1.
- Ha a többi iterációban találunk olyan kombinációt, amely ennél kisebb, úgy felülírjuk a legutóbbi eredményt.
- Amennyiben minden esetben olyan összegre lépünk vissza, amelyet nem tudtunk semmilyen kombinációval kifizetni, úgy ezt sem tudjuk, marad az előre rögzített érték (pénzösszeg+1)

5. Amennyiben elkészült minden iteráció, megnézzük, hogy az általunk vizsgált pénzösszeg kifizethető-e a pénzérmékből, ha igen, akkor írjuk ki az érmék darabszámát, ellenkező esetben -1-et.
