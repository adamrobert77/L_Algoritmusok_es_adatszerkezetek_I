
### 01_Mohó stratégia

# Greedy Florist feladatleírás // Hackerrank, közepes nehézség
Forrás: https://www.hackerrank.com/challenges/greedy-florist/problem?isFullScreen=true
## Feladatleírás
Egy baráti társaság szeretne vásárolni egy csokor virágot. A virágüzlet szeretné maximalizálni az új ügyfelek számát és a keresett pénzt. Ennek eléréséhez úgy dönt, hogy az adott virág listaárát megszorozza a vásárló eddig összesen vásárolt virágok száma plusz eggyel.  
  
Tehát az első virágot listaáron kapja, $\left(0\ +\ 1\right)\cdot listaár$, a következőt $\left(0\ +\ 1\right)\cdot listaár$ eladási áron, és így tovább.
  

A baráti társaság méretét, a megvásárolni kívánt virágok számát és a virágok listaárait figyelembe véve határozza meg az összes virág megvásárlásának minimális költségét. A kívánt virágok száma megegyezik a tömb hosszával.

  
### Példa
virágok = [1 2 3 4]  
emberek száma = 3  

A tömb összesen 4 hosszú, amelyet összesen 3 személy szeretne megvásárolni.  
Első körben az alábbiak kerülnek megvásárlása [2 3 4]  _(mindenki vásárol egyet)_, amelyek listaáron kerülnek értékesítésre, majd utolsó [1], amely már növelt áron. _(hiszen valakinek 2db-ot kell vásárolnia)_  
(eddig_vásárolt_virágok + 1) x virágok[0] ----> (1 + 1) x 1 = 2    
  
__Az eredmény így: 2 + 2 + 3 + 4 = 11__
  
### Függvény leírás
A függvény kettő bemeneti értéket kap:  
int c[n]: virágok listaárai  
int k: emberek száma
  
### Visszatérési érték  
A visszatérési érték a virágok lehető legkisebb bekerülési költségének összege.  
  
### Megkötések
$1  \leq virágszám, emberszám \leq 100$  
$1  \leq virágok[i] \leq 10^6$  
$eredmény < 2^{31}$  
$0 \leq i < virágszám$  

### Példa2
virágok = [2 5 6]  
emberek száma = 2  

Eredmény = 15  
  
#### Magyarázat  
Az első személy megveszi az 6-os listaárú virágot, a másik pedig az 5-ös listaárú virágot. Ezt követően valamelyikük megvásárolja az utolsót, amely már növelt eladási áron kerül értékesítésre.
