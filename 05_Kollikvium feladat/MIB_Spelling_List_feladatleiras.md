
### 05_Kollikvium feladat (SPOJ/OKTV)

# MIB Spelling List: SPOJ (concept: easy, implementation: medium)
![image](https://github.com/user-attachments/assets/593ddde1-7364-414f-a76c-792bc2a78501)
Forrás: https://www.spoj.com/problems/MIB/
## Feladatleírás
Adott egy szó, amelyet n darab szótagokra darabolunk, megtartva az eredeti sorrendet, ezekből a szótagokból n faktoriális darab variációt tudunk kirakni.  
  
A feladat meghatározni, hogy, ha ABC sorrendbe rendeznénk ezeket a lehetséges variációkat, akkor hanyadik variáció lenne a sorban az eredeti, meghatározott szótagokból kirakott szó.  

### Bemenet
- int n: az első sorban egy szám van, amely meghatározza, hogy hány szó esetében kell elvégeznünk az eljárásokat
- ezt követi 2*n darab sor, ahol minden páratlan a szótagok számát jelzi, a páros sorok pedig a szótagokat tartalmazzák, szóközzel elválasztva `n*(int wordParts.length, String[] wordParts)`

### Kimenet
- külön sorokban ki kell írni, hogy adott vizsgált szó abc sorrendben hanyadik elem a lehetséges variációk sorozatában


