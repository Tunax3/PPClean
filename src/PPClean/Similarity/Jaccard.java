package src.PPClean.Similarity;

import java.util.HashSet;
import java.util.Set;

/**
 * Jaccard String similarity
 */
public class Jaccard implements StringSimilarity {

    int n;

    /**
     * @param n Length of substrings
     */
    public Jaccard(int n) {
        this.n = n;
    }

    /**
     * Calculates Jaccard String similarity for x and y, using ngrams of length {@link #n}
     * @param x
     * @param y
     * @return Similarity score in range [0,1]
     */
    @Override
  /**  public double compare(String x, String y) {
        double res = 0;
        Set<String> ngramsX = new HashSet<>();
        Set<String> ngramsY = new HashSet<>();
        // BEGIN SOLUTION
        if (n < 0){ throw new IllegalArgumentException("Das übergbene n muss größer als 0 seien.");}
        if(x == null || y == null){return res;}
        int Schnittmenge = 0;
        for(int i = 0; i < x.length()-n+1;i++){
            ngramsX.add(x.substring(i,i+n));
        }
        for(int i = 0; i < y.length()-n+1;i++){
            ngramsY.add(y.substring(i,i+n));
        }
        String str = ngramsY.iterator().next();
        for (int i = 0; i < ngramsY.size(); i++) {
            if (ngramsX.contains(str)) {
                Schnittmenge++;
            }
            str = ngramsY.iterator().next();
        }
        res = Schnittmenge/ (double) ngramsX.size()+ (double) ngramsY.size() - (double) Schnittmenge ;
        // END SOLUTION
        return res;
    }
   **/
    public double compare(String x, String y) {
        double res = 0;
        Set<String> ngramsX = new HashSet<>();
        Set<String> ngramsY = new HashSet<>();
        // BEGIN SOLUTION
        if (x == null || y == null) {
            return res;
        }
        int lengthX = x.length() - n + 1;
        int lengthY = y.length() - n + 1;

        for (int i = 0; i < lengthX; i++) {
            ngramsX.add(x.substring(i, i + n));
        }
        for (int i = 0; i < lengthY; i++) {
            ngramsY.add(y.substring(i, i + n));
        }
        res = ngramsX.stream().filter(ngramsY::contains).count();
        res = res / ((ngramsX.size() + ngramsY.size()) - res);
        // END SOLUTION
        return res;
    }
}
