
### 01_Rekurzióval megoldható feladatok

# Password cracker feladatleírás // Hackerrank, közepes nehézség
Forrás: [https://www.hackerrank.com/challenges/password-cracker/problem?isFullScreen=true](https://www.hackerrank.com/challenges/password-cracker/problem?isFullScreen=true)
## Feladatleírás
Adott egy weboldal, amely esetében "Yu" talált egy kiskaput a jelszó-ellenőrző rendszerben, ahol, mint kiderült a rendszer elfogad olyan jelszót is, amely a többi jelszónak véletlenszerűen összefűzött mása.  
  
Bármely jelszó megjelenhet ezen string-ben 0, vagy több alkalommal is.  

Adott egy **n darab jelszóból álló tömb** és egy **loginAttempt elnevezésű string.** Döntsük el, hogy ki tudjuk-e rakni a **loginAttempt-ben** található karaktersorozatot a rendelkezésünkre álló, jelszavakat tartalmazó stringek összefűzésével.  
  
Amennyiben igen, akkor adott sorrendben, szóközzel ellválasztva adjuk vissza ezeket a string-eket.  
  
Ellenkező esetben adjuk vissza a "WRONG PASSWORD" string-et visszatérési értékben.  
  
### Példa  
stringTömb: [abra, ka, dabra]  
loginAttempt: "abrakadabra"    
Visszatérési érték: "abra ka dabra"  

stringTömb: [ab, ba]  
logintAttempt: "aba"  
Visszatérési érték: "WRONG PASSWORD"  
  
### Függvény leírás  
Bemenet:
- string-eket "jelszavakat" tároló tömb / collection
- loginAttempt string  
  
Kimenet:
- result String, ahol vagy "WRONG PASSWORD"-ot adunk vissza, vagy a fentebb megadott módon összefűzött string-eket

### Megkötések
1 <= t <= 10  
1 <= n <= 10  
passwords[i] != passwords[j], 1 <= i <= j <= N  
1 <= abs(passwords[i]) <= 10, i eleme [1,n]  
1 < abs(loginAttempt) <= 2000  
  
**Részletesebben a hackerrank felületen.**
