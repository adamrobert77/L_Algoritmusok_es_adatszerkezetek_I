
class Result {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here
        
        // a graf iranyitas nelkuli
        // mindegyik el sulya 6 egyseg
        // a node-ok 1-tol n-ig vannak szamozva
        
        // int n = csucsok szama (node)
        // int m = elek szama (edge)
        // int s = kiindulasi pont (starting node)
        // List<List<Integer>> edges = [1,2], [1,3], [3,4] --- elek ket pont kozott
        
        
        
        
        // hozzunk letre egy tarolot, amelyben eltarolhatjuk, hogy adott pontbol hany el fut ki
        
        LinkedList<Integer>[] adjacentList = new LinkedList[n]; // szomszedsagi lista
        
        for (int i = 0; i < n; i++) {
            adjacentList[i] = new LinkedList<>();
        }
        
        
        // tegyuk bele a szomszedsagi listaba az eleket adott indexeles alapjan
        for(List<Integer> edge : edges) {
            // ugyeljunk az indexeles konvenciora - minden node-bol vonjunk ki 1-et
            adjacentList[edge.get(0)-1].add(edge.get(1)-1); 
            adjacentList[edge.get(1)-1].add(edge.get(0)-1);
        }
        
        
        
        // hozzuk letre a valtozot, amelybe elmentjuk a megoldasokat
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
    }
    
    
        // implementaljuk egy BFS algoritmust
        static int shortestRoute(int start, int destination, int numOfNodes, LinkedList<Integer>[] adjacentList) {
            // hozzuk letre a szukseges valtozokat
            
            // rogzitjuk, hogy melyik csucsokban jartunk mar
            boolean[] visitedNodes = new boolean[numOfNodes];
            // rogzitjuk az eddig megtett tavolsagot
            int[] distance = new int[numOfNodes]; 

            // hozzunk letre egy sorozatot, ez teszi lehetove, hogy minden ponton vegig menjunk
            LinkedList<Integer> queue = new LinkedList<>();
            
            // a kezdopontot "latogatott" csucsnak tekintjuk, ott kezdjuk a bejarast
            visitedNodes[start] = true;
            queue.add(start);

            // addig iteralunk, amig el nem fogynak a csucsok a listabol
            while (!queue.isEmpty()) {
                
                // kivesszuk a sorbol a vizsgalando csucsot
                int node = queue.poll();

                // ha elerjuk a cel csucsot, terjunk vissza a tavolsaggal
                if (node == destination) {
                    return distance[node];
                }

                // ha nem ertuk el a csucsot, deritsuk fel a szomszedokat
                for (int neighbour : adjacentList[node]) {
                    if (!visitedNodes[neighbour]) {
                        visitedNodes[neighbour] = true;
                        // a szomszed tavolsaga az eddig megtett tavolsag + 1
                        distance[neighbour] = distance[node] + 1; 
                        // tegyuk be a sorba a felfedezett szoszedot
                        queue.add(neighbour);
                    }
                }
            }

            // amennyiben mar mindent felderitettunk, es a cel nem elerheto, terjunk vissza -1-gyel
            return -1;
        }




}
