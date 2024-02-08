package Recursion;

import java.util.HashSet;

public class Minimum_Cost_Path {
    public static  int cost=Integer.MAX_VALUE;

    public int minCostPath(int row,int col,int[][] A)
    {
        int cost=Integer.MAX_VALUE;
        for(int i=0;i<row;i++){
           costPath(A,row,col,1,i,A[i][0],A[i][0]);

        }
        return cost;
    }

    public void costPath(int[][] A, int row, int col, int j, int i, int min, int max){
        if(j>=col){
            cost=Math.min(cost, Math.abs(max-min));
            return;
        }

        for(int m=0;m<row;m++){
            System.out.println(m+" "+j+" "+row+" "+col);
            costPath(A,row,col,j+1,i,Math.min(min,A[m][j]), Math.max(max,A[m][j]));
        }

    }

    public int lowestCommon(String X, String Y){

        int m=X.length();
        int n=Y.length();
        System.out.println("X : "+m+"  Y: "+n);
        int[] a= new int[26];
        int[] b= new int[26];
        int [] c= new int[26];
        int [] d= new int[26];
        for(int i=0;i<m;i++){
            char temp=X.charAt(i);
            if(Character.isUpperCase(temp)){
                c[temp-'A']++;
            }else{
                a[temp-'a']++;
            }

        }
        for(int i=0;i<n;i++){
            char temp=Y.charAt(i);
            if(Character.isUpperCase(temp)){
                d[temp-'A']++;
            }else{
                b[temp-'a']++;
            }
        }
        int min=0;

        for(int i=0;i<26;i++){
            int lower=Math.max(a[i],b[i]);
            int upper=Math.max(c[i],d[i]);
            System.out.println(a[i]+" "+b[i]+" "+c[i]+" "+d[i]+ " "+(lower+upper)+" "+min);
            min+=lower+upper;
        }
        return min;

    }

    public  int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        if(m==0 && n==0){
            return 0;
        }
        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }
        if(X.charAt(m-1)==Y.charAt(n-1)){
            return 1+shortestCommonSupersequence(X,Y,m-1,n-1);
        }else{
            return 1+ Math.min( shortestCommonSupersequence(X,Y,m,n-1),
                    shortestCommonSupersequence(X,Y,m-1,n));
        }

    }

        public int shortestCommonSupersequence(String X, String Y) {
            int m = X.length();
            int n = Y.length();

            // Create a table to store the lengths of the shortest common supersequences
            int[][] dp = new int[m + 1][n + 1];

            // Fill the table using bottom-up dynamic programming
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0) {
                        dp[i][j] = j;
                    } else if (j == 0) {
                        dp[i][j] = i;
                    } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    System.out.print(dp[i][j]+"  ");
                }
                System.out.println();
            }

            // The length of the shortest common supersequence is given by the bottom-right cell
            return dp[m][n];
        }
   public int lengthOfLIS(int[] nums) {
            // Check if the array is empty or null
            if (nums == null || nums.length == 0) {
                return 0;
            }

            // Get the length of the input array
            int n = nums.length;

            // Create an array to store the length of LIS ending at each index
            int[] lis = new int[n];

            // Initialize each element in the LIS array to 1 (minimum length of subsequence)
            for (int i = 0; i < n; i++) {
                lis[i] = 1;
            }

            // Dynamic programming approach to update LIS array
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    // Check if the current element can be added to the increasing subsequence
                    if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                    }
                }
            }

            // Find the maximum value in the LIS array, which represents the length of the LIS
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (lis[i] > max) {
                    max = lis[i];
                }
            }

            // Return the length of the longest increasing subsequence
            return max;
        }

        // Main method for testing the function

    public int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int[][] dp= new int[x+1][y+1];
        for(int i=0;i<=x;i++){
            boolean found=false;
            for(int j=0;j<=y;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else{
                    int max= Math.max(dp[i-1][j],dp[i][j-1]);

                    if(s1.charAt(i-1)==s2.charAt(j-1) && !found){
                        System.out.print(s1.charAt(i-1)+"  "+s2.charAt(j-1));
                        dp[i][j]=max+1;
                        System.out.println();
                        found=true;
                    }else{
                        dp[i][j]=max;
                    }
                }

            }
        }

        for (int i=0;i<=x;i++){
            for(int j=0;j<=y;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }


        return dp[x][y];
    }

    }








