import Queue.DynamicQueue;

import Queue.Queue;

import java.util.HashMap;

public class LinearMain{

    public static void main(String[] args){
        int age=0;
      System.out.println("Enterg the Age");
      age=55;
      age=age-10;
    }

    public static void streamMap(int[] arr, int n, int k){
        HashMap<Integer,Integer> map= new HashMap<>();
        int num=0;
        int count=n/k;
        for(int i=0;i<n;i++){
            int value=map.getOrDefault(arr[i],0);
            map.put(arr[i],value+1);
        }
        map.entrySet().stream().forEach(x-> System.out.println(x.getKey()+"  "+x.getValue()));

    }
}
