
### 04_Fa- és gráfalgoritmusos feladatok

# First Search: Shortest Reach feladatleírás // Hackerrank, közepes nehézség
Forrás: https://www.hackerrank.com/challenges/bfsshortreach/problem?isFullScreen=true
## Feladatleírás
Adott egy irányítás nélküli gráf, ahol minden élsúly 6 egység, a csúcsok számozása pedig 1-től n-ig értelmezendő.  
  
A feladat egy kapott élek listája alapján létrehozni egy gráfot, majd egy meghatározott kezdőcsúcsból megadni a többi csúcsba futó legrövidebb utak értékét, mindezt a Breadth-first search (BFS) (szélességi bejárás) algoritmus használatával.  
  
Amennyiben egy csúcs nem megközelíthető, annak esetében a visszatérési érték -1, minden más esetben a kezdőcsúcs és célcsúcs közötti távolság. (minden él 6 egység)
  
### Példa  
int n = 5 // csúcsok száma: 5  
int m = 3 // élek száma: 3  
List<List<Integer>> edges = [[1,2], [1,3], [3,4]] // élek  
int s = 1 // kezdőcsúcs: 1  
  
Kezdjünk el lépkedni az első csúcsból, a fenti élek figyelembevételével.  
2-es csúcsig a távolság: 6, mivel 1 és 2 közvetlen összeköttetésben vannak.  
3-as csúcsig a távolság: 6, mivel 1 és 3 közvetlen összeköttetésben vannak.
4-es csúcsig a távolság: 12, mivel a két csúcs között két él is található. (1-3 + 3-4)  
5-ös csúcsig a távolság: végtelen, mivel a két csúcs között nincs összeköttetés.  
  
**Eredmény:** return List<Integer> result = [6, 6, 12, -1];
  

### Megkötések
$1  \leq q(esetek szama) \leq 10$  
$2  \leq n \leq 1000$  
$1  \leq m \leq (n*(n-1))/2$  
$1  \leq u,v,s \leq n$  

  
### Bemenet
- int n: csúcsok száma
- int m: élek száma
- int edges[m][2]: egy élre vonatkozó csúcspontok listája
- int s: kezdő csúcspont (ahonnan a számolást értelmezzük)




  
### Kimenet/visszatérési érték  
Távolságokat tartalmazó lista:  
`return List<Integer> result`
