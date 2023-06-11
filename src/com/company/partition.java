package com.company;
import java.util.*;

public class partition {
    List<Integer> prtSize = new ArrayList<>();
    List<String> prtName = new ArrayList<>();

    public void partitions(int select) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of partitions: ");
        int a = sc.nextInt();
        String partitionname[] = new String[a];
        int partitionSize[] = new int[a];
        System.out.println();
        System.out.println("Enter name and size of partitions: ");
        for (int i = 0; i < a; i++) {
            partitionname[i] = sc.next();
            partitionSize[i] = sc.nextInt();
            prtName.add(partitionname[i]);
            prtSize.add(partitionSize[i]);
        }
        int n = prtSize.size();
        int[] prtsize = new int[n];
        String[] prtname = new String[n];
        for (int i = 0; i < n; i++) {
            prtsize[i] = prtSize.get(i);
        }
        for (int i = 0; i < n; i++) {
            prtname[i] = prtName.get(i);
        }
        if(select==1){
            FF f = new FF();
            f.partition(prtsize, prtname);
        }
        if(select==2){
            BF f = new BF();
            f.partition(prtsize, prtname);
        }
        if(select==3){
            WF f = new WF();
            f.partition(prtsize, prtname);
        }

    }
}

