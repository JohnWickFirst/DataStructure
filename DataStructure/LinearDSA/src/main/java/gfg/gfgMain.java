package gfg;

import java.util.*;

public class gfgMain {

    public static void main(String[] args){
        gfgMain gfg= new gfgMain();
        int n=1234;
        int num=gfg.nextBigNumber(n);
        System.out.println("Next big number:  "+num);


    }
    // Find next big number using the given digits
    // in case the given number is the biggest return -1;
    public int nextBigNumber(int n){
        if(isThisBiggest(n)){
            return -1;
        }
        int size=sizeInt(n);
        System.out.println("size "+size);
        int[] arr= new int[size];
        getArray(arr,n,size);
        printThisArray(arr,size, "Converted Array");
        replaceDigit(arr,size);
        printThisArray(arr,size,"Replaced Array");
        int ans=getNewDigit(arr,size);
        System.out.println("Ans: "+ans);



        return ans;
    }

    private void printThisArray(int[] arr, int size, String msg) {
        System.out.print(msg+":  ");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private int getNewDigit(int[] arr, int size) {
        int tens=1;
        int i=size-1;
        int ans=0;
        while(i>=0){
            ans=tens*arr[i]+ans;
            tens=tens*10;
            i--;
        }
        return ans;
    }

    private void replaceDigit(int[] arr, int size) {
        int i=size-2;
        boolean found=false;
        while(i>=0 && !found){
            if(arr[i]<arr[i+1]){
                found=true;
            }else{
                i--;
            }

        }
        List<Integer> list= new ArrayList<>();
        int max=Integer.MAX_VALUE;
        for(int j=i+1;j<size;j++){
            if(arr[j]>arr[i] && arr[j]<max){
                max=arr[j];
            }

        }
        for(int j=i;j<size;j++){
            if(arr[j]!=max){
                list.add(arr[j]);
            }
        }
        Collections.sort(list);
        arr[i]=max;
        int m=0;
        for(int j=i+1;j<size;j++){
            arr[j]=list.get(m);
            m++;
        }
    }

    private void getArray(int[] arr, int n, int size) {
       for(int i=size-1;i>=0;i--){
           arr[i]=n%10;
           n/=10;
       }
    }

    private int sizeInt(int n) {
        int count=0;

        while(n>0){
            n/=10;
            count++;

        }
        return count;
    }

    private int helpBig(int num, List<Integer> list){
        int s=list.size();
        int value=list.get(0);
        int temp=num;
        int f=temp%10;
        while(temp>10){
            int rem=temp%10;
            value=value*10+rem;
            temp/=10;
        }
        System.out.println("Temp "+temp);
        return temp;

    }

    private boolean isThisBiggest(int n){
        int rem=n%10;
        while(n>0){
            if(rem>n%10){
                return false;
            }
            rem=n%10;
            n=n/10;
        }

        return true;
    }




    public static int getMin(int n, int[] c){
        int sum=0, j=0, curSum=Integer.MAX_VALUE;
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(c[i]);
        }
        int d=set.size();
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int value=map.getOrDefault(c[i],0);
            map.put(c[i],value+1);
            sum+=c[i];
            while(map.size()==d && j<i){
                int temp=map.getOrDefault(c[i],0);
                if(temp>1){
                    sum-=c[j];
                }
              //  map.put()
                curSum=Math.min(sum,curSum);
            }
        }

        return curSum;
    }



}
