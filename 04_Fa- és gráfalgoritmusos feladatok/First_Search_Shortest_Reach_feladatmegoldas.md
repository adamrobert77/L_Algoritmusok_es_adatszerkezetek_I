
### 04_Fa- és gráfalgoritmusos feladatok

# First Search: Shortest Reach feladatleírás // Hackerrank, közepes nehézség
Forrás: https://www.hackerrank.com/challenges/bfsshortreach/problem?isFullScreen=true
## Feladatmegoldás
- Implementáljunk egy BFS algoritmust, amely fejléce fogadja az alábbiakat: `static int shortestRoute(int start, int destination, int numOfNodes, LinkedList<Integer>[] adjacentlist )`
  
Ahol:
- int start: kiindulási csúcs száma
- int destination: célcsúcs száma
- int numOfNodes: csúcsok száma
- LinkedList<Integer>[] adjacentList: gráf reprezentálása
  
Visszatérési érték  
A bemeneti gráf kiválasztott kezdőcsúcsa és célcsúcsa közötti távolsága, egész szám  
  
  
**(Megvalósítás részletesen kikommentelve Result.java file-ban)**

Ezt követően foglalkozzunk a feladat `bfs` elnevezésű függvényével  
- Hozzuk létre a kapott élek listájából a gráfot
1. Létrehozunk egy LinkedList tömböt, amely mérete az élek száma
```java
  LinkedList<Integer>[] adjacentList = new LinkedList[n]; // szomszedsagi lista
        
        for (int i = 0; i < n; i++) {
            adjacentList[i] = new LinkedList<>();
        }
   ```
2. Foreach ciklus segítségével töltsük meg a kapott élekkel, ahol ügyeljünk arra, hogy az élek irányitatlan élek, ezért mindkét irányt bele kell tegyük a tárolóba.
```java
  // tegyuk bele a szomszedsagi listaba az eleket adott indexeles alapjan
        for(List<Integer> edge : edges) {
            // ugyeljunk az indexeles konvenciora - minden node-bol vonjunk ki 1-et
            adjacentList[edge.get(0)-1].add(edge.get(1)-1); 
            adjacentList[edge.get(1)-1].add(edge.get(0)-1);
        }
   ```
3. Végigiterálunk a csúcsokon, mindegyikre meghívjuk a `shortestRoute` függvényt, elmentjük az eredményeket egy result változóba.
```java
        List<Integer> result = new ArrayList<>();
        
        // toltsuk meg a result valtozot adott inputokra vonatkozoan
        // itt szamoljuk ki, hogy adott start poziciotol milyen tavolsagra van X-Y pont
       for(int i = 1; i<=n; i++) {
           
           // a start poziciot nem kell ellenorizzuk "onmagara", csak azt nezzuk, hogy a tobbi pontba eljutva mennyi tavolsagot teszunk meg
           if(i != s) {
               // shortestRoute return erteke az adott tavolsag (1 vagy -1 ertek lehet az output)
               // itt is ugyeljunk az indexeles eltolasara
               int distanceToNode = shortestRoute(s-1, i-1, n, adjacentList);
               // a fgv egy egysegegre szamolja ki a tavolsagot, de a feladat egy tavolsagot 6-nak vesz
               result.add(distanceToNode != -1 ? distanceToNode*6 : distanceToNode);
           }
       }
        
        return result;
   ```
