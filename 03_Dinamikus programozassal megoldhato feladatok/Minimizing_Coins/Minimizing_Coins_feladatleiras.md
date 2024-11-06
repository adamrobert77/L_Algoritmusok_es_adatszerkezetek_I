
### 03_Dinamikus programozással megoldható feladatok

# Minimizing Coins feladatleírás // CSES, közepes nehézség
Forrás: https://cses.fi/problemset/task/1634/
## Feladatleírás
Vegyünk egy n érméből álló pénzrendszert, ahol mindegyik érme pozitív egész értékkel bír. A feladat kiszámolni, hogy adott összeget mennyi legkevesebb érméből lehet kifizetni.


  
### Példa  
Érmék: {1, 5, 7}  
Pénzösszeg: 11  

Megoldás: 3  
Mert: 5+5+1 = 11.  
  
  

### Megkötések
$1  \leq n \leq 100$  
$1  \leq x \leq 10^6$  
$1  \leq c(n) \leq 10^6$  
  
### Bemenet
- int n: érmék száma
- int x: pénzösszeg száma
- int coin: **n darab** pénzérme
  
### Kimenet/visszatérési érték
- Ha az adott összeg kirakható a kapott érmékből, írjunk ki std output-ra a fenti feltételekkel meghatározott érme darabszámot, ellenkező esetben -1-et.
