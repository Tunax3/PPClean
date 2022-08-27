package src.PPClean.Similarity;

import java.lang.reflect.Array;

/**
 * Levenshtein String similarity
 */
public class Levenshtein implements StringSimilarity {
    public Levenshtein() {
    }

    /**
     * Calculates Levenshtein String similarity for x and y
     * @param x
     * @param y
     * @return Similarity score in range [0,1]
     */

    public static void main (String [] args){
        Levenshtein c = new Levenshtein();
        System.out.println(c.findMin(0,1,1));
        c.compare("jo", "non");
    }
    @Override
    public double compare(String x, String y) {
        double res = 0;
        int m = x.length();
        int n = y.length();
        // BEGIN SOLUTION
        if(x.length() == 0 && y.length() == 0){return 0;};
        if(x.length() == 0){return y.length();}
        if(y.length() == 0){return x.length();}
        int LD = 0;
        int [] [] D = new int [x.length()+1][y.length()+1];
        for(int i = 0; i < x.length()+1;i++){
            D[i][0] = i;
        }
        for(int j = 0; j < y.length()+1;j++){
            D[0][j] = j;
        }

        LDrec(x,y,D,1,1);
        LD = D[x.length()][y.length()];
        if(x.length()>y.length()) {
            res = 1 - (double)LD/x.length();
        }else{
            res = 1 - (double)LD/y.length();
        }
        // END SOLUTION
        return res;
    }

    public void LDrec(String s1,String s2,int[][]a,int x,int y){
        if(s1.charAt(x-1) == s2.charAt(y-1)){
            a[x][y] = a[x-1][y-1];
        }else{
            a[x][y]= 1 + findMin(a[x-1][y-1] ,a[x-1][y],a[x][y-1]);
        }
        if(x < s1.length()){
            LDrec(s1,s2,a,x+1,y);
        }else if(y < s2.length()){
            LDrec(s1,s2,a,1,y+1);
        }
    }

    public int findMin(int x,int y,int z){
        if(x < z){
            if(x < y){
                return x;
            }else{
                return y;
            }
        }else{
            if(z < y){
                return z;
            }else{
                return y;
            }
        }
    }
}
