package Recursion;

public class RecursionMain {
    public static void main(String[] args){
        int[][] a= new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                a[i][j]=i+1;
            }
        }
        Minimum_Cost_Path mcp= new Minimum_Cost_Path();
    //    int value=mcp.minCostPath(3,3,a);
        String first="ABBBB";
        String sec="BBCB";
  //    System.out.println(mcp.shortestCommonSupersequence(first,sec));

     //   System.out.println(mcp.lowestCommon("Aa", "a"));

            // Example array
            int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80};

            // Call the function and print the resu
            System.out.println("Length  " +mcp.lcs(first.length(),sec.length(),first,sec));

    }
}
