import LinkedList.SinglyLinkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LinearMain{

    public static void main(String[] args){

        SinglyLinkedList sl=new SinglyLinkedList(10);

        sl.insert(23,0);
        sl.insert(50,0);
        sl.insert(9,4);
        sl.insert(7,5);

        sl.print();
        System.out.println(" \n");
        sl.reverseLinkedList();
        System.out.println(" \n Ram Jai Jai Ram   "+sl.getCount() );
        sl.print();
        List<String> halfString=new ArrayList<String>();
        List<String> ans=new ArrayList<String>();
       String middle="";
        HashSet<String> hs=new HashSet<String>();
        hs.add("test");
     //   hs.

        for(int i=0;i<halfString.size();i++){
            ans.add(halfString.get(i)+middle+halfString.get(i));
        }
    }
}
