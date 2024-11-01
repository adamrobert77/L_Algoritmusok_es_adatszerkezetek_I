
### 01_Rekurzióval megoldható feladatok

# Password cracker feladatleírás // Hackerrank, közepes nehézség
Forrás: [https://www.hackerrank.com/challenges/password-cracker/problem?isFullScreen=true](https://www.hackerrank.com/challenges/password-cracker/problem?isFullScreen=true)
## Feladatmegoldás
A feladatleírás alapján azt kell vizsgáljuk, hogy a kapott `loginAttempt` string kirakható-e a `passwords tároló`-ban található string-ekből, és milyen sorrendben.  
  
**Megközelítésem az alábbi**  
- Iteráljunk végig a kapott `passwords list`-en, és keressük meg, hogy bármelyik string-gel kezdődik-e a `loginAttempt` string.
- Ha az éppen vizsgált igen, akkor tegyük bele azt egy result String változóba valamilyen módon.
- Vágjuk le a `loginAttempt` string elejéből azt a string-et, amit találtunk, és folytassuk a keresést, amíg el nem fogy teljesen a `loginAttempts` subString.
- Ha a kapott `passwords list` tartalmából nem rakható ki a `logintAttempt`, térjünk vissza "WRONG PASSWORD"-del.

**Kivitelezés**  
- Amennyiben a `loginAttempt` a vizsgált string-gel kezdődik, úgy hívja meg önmagát a függvény, a redukált `loginAttempt` string-gel (kitöröljük az elejéről a talált string-et
- Ha a kapott visszatérési érték a "WRONG PASSWORD" string, akkor térjen vissza a külső függvény is "WRONG PASSWORD"-dal
- Amennyiben a visszatérési érték ettől eltérő, fűzzük hozzá azt a jelenleg vizsgált string-hez, és térjünk vele vissza, az alábbi feltételekkel: ha a visszatérési érték üres string volt, akkor szóköz hozzáfűzése nélkül visszaadjuk a jelenleg vizsgált string-et // amennyiben nem üres, úgy a jelenleg vizsgált string-et, és a visszatérési értéket összefűzzük, köztük egy szóközzel
- Általános: ha a `loginAttempt` string üres, akkor üres string-et adunk vissza
- Optimalizáció: minden futás elején a kapott `passwords list`-ből másoljuk ki azokat a string-eket, amelyek benne vannak a `loginAttempts` string-ben. Ezzel hívjuk meg rekurzívan a függvényt, ezáltal redukálva a futási időt, memória igényt.
  
### Szükséges változók
1. `String result` ebben tároljuk a részmegoldásokat  
2. `List<String> validPasswords` ebben tároljuk azokat a string-eket, amelyek megtalálhatóak a `loginAttempt` válotozóban, ezzel eltávolítva a redundáns iterációkat
