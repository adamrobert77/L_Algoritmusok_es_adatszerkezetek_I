### 01_Mohó stratégia

# Greedy Florist feladatleírás // Hackerrank, közepes nehézség
Forrás: https://www.hackerrank.com/challenges/greedy-florist/problem?isFullScreen=true
## Feladatmegoldás  
A feladatleírásban megtalálható, hogy adott példa inputra milyen lépések alapján kapjuk a kívánt outputot, azokat figyelembevéve keressük a megoldást.

1.  __Szükséges változók, tárolók meghatározása__  
  
A függvényhez szükségünk van egy bemeneti tömbre, amely tartalmazza az adott virágok listaárait, ennek a tömbnek a hossza lesz a virágok száma.  
  
`int c[] --> virágok listaárai // fgv. input`  
`c.length --> virágok száma`  
  
Rögzítsük, hogy a társaságból hány személy szeretne virágot vásárolni.  
`int k --> vásárlók száma // fgv. input`  
  
Az eladási árakat el kell tároljuk, erre hozzunk létre egy egészek tárolására alkalmas változót.  
`int eredmeny // kezdeti érték = 0`  
  
Végül pedig tároljuk egy tömbben, hogy adott személy eddig összesen hány virágot vásárolt.  
`int[] ennyi_viragot_vett --> index = személy, érték = vásárolt virágok száma // vásárlók számával azonos méretű, nullákra inicializált tömb`
    
  
2.  __Feladat megértése__

A példa input esetében látunk egy rendezett tömböt ("virágok árai"), és a legdrágább virággal kezdve, csökkenő sorrendben mindegyiket hozzárendeljük ("eladjuk") egy adott vásárlóhoz.  

Ügyelnünk kell arra, hogy minden esetben azt a vásárlót szolgáljuk ki, akinél más még nem vásárolt kevesebb virágot, kétszer egymás után ugyanazt a vásárlót nem szolgálhatjuk ki.  

3.  __Megoldás lépései__

-  Inicializáljuk a szükséges tárolóinkat:  `int[] ennyi_viragot_vett = new int[k]` `int eredmeny = 0`
-  Rendezzük a kapott tömböt növekvő sorrendben, nem bízhatjuk a felhasználóra a rendezést `Arrays.sort(c)`
-  Egy for ciklussal csökkenő sorrendben menjünk végig a virágok listaárain `int c[]`  `for(int i = c.length-1; i>=0; i--)`
-  A for ciklus változóját felhasználva maradékos osztással végig tudunk iterálni a vásárlókon, ezzel biztosítva, hogy mindig olyan vásárlót szolgáljunk ki, akinél más nem vásárolt kevesebbet. `int vasarlo = i%k`
-  Az eredmény változóhoz hozzáadjuk a feladat leírásának megfelelően a vizsgált virág eladási árát `eredmeny += (ennyi_viragot_vett[vasarlo] + 1)*c[i];`
-  Növeljük a vásárlóhoz rendelt virágok számát 1-gyel `ennyi_viragot_vett[vasarlo] = ennyi_viragot_vett[vasarlo]+1`
-  Ha végigmentünk a teljes tömbön, visszatérünk az eredménnyel `return eredmeny`







