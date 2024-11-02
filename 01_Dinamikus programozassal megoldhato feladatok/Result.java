import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'fibonacciModified' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER t1
     *  2. INTEGER t2
     *  3. INTEGER n
     */

    public static BigInteger fibonacciModified(int t1, int t2, int n) {
    // Write your code here

        // FIGYELEM ----> A hackerrank teszteleshez a komplett feladat kimasolasa javasolt
        // A megoldas kizarolag BigInteger valtozokkal mukodik, mert 64 bitnel nagyobb megoldas is keletkezhet

        // Ebbol adodoan a FGV visszateresi ertek at lett irva int-rol BigInteger-re, illetve a public class solution-ban talalhato
        // int result is at lett javitva BigInteger result-ra
        
      
        // adott t[i] es t[i+1], ahol i eleme (1, infinite), es t[i+2]-t az alabbi modon kapjuk meg:
        // t[i+2] = t[i] + t[i+1]^2
        
        // bemenet: 
        // int n = index, ezt az elemet keressuk
        // int t1 = t[1] kezdoertek
        // int t2 = t[2] kezdtoertek
        
        
        // hozzunk letre egy tarolot a megoldasoknak
        List<BigInteger> calculatedNumbers = new ArrayList<>();
        
        // tegyuk bele a t[1] es t[2] kezdoertekeket
        calculatedNumbers.add(BigInteger.valueOf(t1));
        calculatedNumbers.add(BigInteger.valueOf(t2));
        
        
        // kozelitsuk a megoldast alulrol, szamoljuk ki a megoldas osszes elozo elemet (ezzel elve a dinamikus programozas elonyevel a rekurzios megoldassal szemben) 
            for(int i = 2; i<n; i++) {
                
                // i_minus_one = t[i-1] elem
                BigInteger i_minus_one = calculatedNumbers.get(i-1);
                // i_minus_two = t[i-2] elem
                BigInteger i_minus_two = calculatedNumbers.get(i-2);
                
                // szamoljuk ki t[n] elemet: t[i-2] + (t[i-1])^2
                BigInteger result = i_minus_two.add(i_minus_one.pow(2));
                
                // helyezzuk el a megoldast a memoriaba
                calculatedNumbers.add(result);
            }    
    
        // terjunk vissza a kiszamolt elemmel
        return calculatedNumbers.get(n-1);
        
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int t1 = Integer.parseInt(firstMultipleInput[0]);

        int t2 = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        BigInteger result = Result.fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
