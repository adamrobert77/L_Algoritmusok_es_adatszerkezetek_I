
### 03_Dinamikus programozással megoldható feladatok

# Fibonacci Modified feladatleírás // Hackerrank, közepes nehézség
Forrás: https://www.hackerrank.com/challenges/fibonacci-modified/problem?isFullScreen=true
## Feladatleírás
Implementálj egy módosított Fibonacci sorozatot, amely definíciója az alábbi  
  
$t[n] = t[n-2] + (t[n-1])^2$   
  
Tehát a sorozat n-edik tagja az előző tag négyzetének és az előző előtti tag összege.
  
### Példa  
$t[1] = 0$  
$t[2] = 1$  
$t[n] = ?$  

**Legyen:**
$n = 5$  
  
$t[3] = 0 + 1^2 = 1$  
$t[4] = 1 + 1^2 = 2$  
$t[5] = 1 + 2^2 = 5$  

  
  

### Megkötések
$0  \leq t[1], t[2] \leq 2$  
$3  \leq n \leq 20$  
t[n] mérete akár egy 64 bites integernél is nagyobb lehet   
  
### Bemenet
- int t1, egész szám (fenti megkötések alapján)
- int t2, egész szám (fenti megkötések alapján)
- int n, egész szám (fenti megkötések alapján)
  
### Kimenet/visszatérési érték
- BigInteger típusú változó ( méret > 64 bit miatt)
