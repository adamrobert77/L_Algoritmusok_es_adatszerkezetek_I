public class Solution {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) { // ahol c = viragok listaarai, k = vasarlok szama
        
        int eredmeny = 0;
        Arrays.sort(c); // rendezzuk novekvo sorrendbe a tombot, csak ilyen modon mukodik az algoritmus
        
        int[] ennyi_viragot_vett = new int[k]; // felvesszuk a vasarlok szama meretu tombot, minden erteket 0-ra inicializalva
        
        
        for(int i = c.length-1; i>=0; i--) {
            int vasarlo = i%k; // ezzel a modszerrel ismetlesesen vegig tudunk menni a vasarlokon, nincs szukseg minimum keresesre - sorban szolgaljuk ki a vasarlokat
            eredmeny += (ennyi_viragot_vett[vasarlo] + 1)*c[i];
            ennyi_viragot_vett[vasarlo] = ennyi_viragot_vett[vasarlo]+1;
        }
        
        return eredmeny; 
        
    }
}
