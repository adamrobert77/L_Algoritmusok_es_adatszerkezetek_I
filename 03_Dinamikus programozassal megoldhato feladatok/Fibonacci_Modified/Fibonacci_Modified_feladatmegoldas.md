### 03_Dinamikus programozással megoldható feladatok

# Fibonacci Modified feladatleírás // Hackerrank, közepes nehézség
Forrás: https://www.hackerrank.com/challenges/fibonacci-modified/problem?isFullScreen=true
## Feladatmegoldás  
Értelmezzük a feladatban megadott definíciót, vizsgáljuk miként tudjuk algoritmizálni, implementálni.  

1. Vegyük észre a megkötések esetében, hogy a `t[n]-edik` elem értéke meghaladhatja a 64-es bitszélességet is, így az implementációhoz szükségünk lesz a BigInteger osztályra. A visszatérési értékünk és a kalkulációk végrehajtása is ezen típus segítségével valósul meg.
2. Hozzunk létre egy tárolót, amelyben a kapott, illetve kalkulált sorozat tagokat el tudjuk helyezni adott sorozat szerinti sorrendben. Az első két elem minden esetben: `t[0]=t1` `t[1]=t2`
3. Iteráljunk végig 2-től (n-1)-ig, és minden iteráción belül számítsuk ki az adott indexhez tartozó értéket a definícióba foglaltak szerint: `BigInteger result = i_minus_two.add(i_minus_one.pow(2))` A kalkulált értéket adjuk hozzá a tárolóhoz `calculatedNumbers.add(result)`.
4.  Definíció szerint adjuk vissza a bemenet szerinti `int n` indexű tagját a sorozatnak. A tárolóban ez az (n-1)-edik elem lesz.




