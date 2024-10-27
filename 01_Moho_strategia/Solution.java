public class Solution {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        
        int eredmeny = 0;
        Arrays.sort(c);
        
        if(k < c.length) {
        // ESET --> tobb virag van, mint ember
        // taroljuk: adott szemelyek eddig hany viragot vasaroltak
        // index = szemely, ertek = ennyi viragot vett eddig
        
        int[] ennyi_viragot_vett = new int[k];
        
        
        for(int i = c.length-1; i>=0; i--) {
            // ez biztositja, hogy mindig olyan szemelyt valassszunk ki, aki eddig a legkevesebb viragot vasarolta ---> nincs szukseg kulon minimumot keresni a tombben
            int szemely = i%k;
            eredmeny += (ennyi_viragot_vett[szemely] + 1)*c[i];
            ennyi_viragot_vett[szemely] = ennyi_viragot_vett[szemely]+1;
        }
        
        return eredmeny; 
        
        } else {
            
        // ESET --> legfeljebb annyi virag van, mint ember
        // menjunk vegig a tombon novekvo sorrendben, adjuk hozza a viragok erteket az eredmeny valtozohoz
        
        int i = 0;
        while(i<k && i<c.length) {
            eredmeny += c[i];
            i++;
        }
        
        return eredmeny;
        }
        
        
        
        // virag_ara = (eddig_vasarolt_mennyiseg + 1) * listaar
        
        // ha (emberek_szama)<=(virag) nullatol felfele szamolunk
        // egyebkent csokkeno sorrendben
        
        // 1. hatarozzuk meg, hogy tobb-e az ember, mint a virag
        
        // 2. amennyiben kisebb-egyenlo ember van, mint virag, akkor
        // az eredmenyt megkapjuk, ha nulla indextol kezdve osszeadjuk
        // a viragok arait
        
        // 3. amennyiben tobb az ember, mint a virag, akkor ar szerint
        // csokkeno sorrendben elkezdjuk osszeadni a viragok arait
        // ha vegigmentunk minden emberen, akkor kivalasztjuk azt
        // a szemelyt, aki eddig a legkebesebb viragot vette, es
        // ar szerint novekvo sorrendben kezdjuk el megvenni a viragokat
        // ha elfogyott az osszes virag, visszaterunk a result-szel
    
        
        
        
        

    }
}
