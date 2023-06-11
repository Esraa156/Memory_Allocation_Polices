package com.company;

import java.util.*;

public class process {

    List<Integer> proSize = new ArrayList<>();
    List<String> proName = new ArrayList<>();

    public void processes(int select) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of process requests: ");
        int b = sc.nextInt();
        String processname[] = new String[b];
        int processSize[] = new int[b];
        System.out.println();
        System.out.println("Enter name and size of processes: ");
        for (int i = 0; i < b; i++) {
            processname[i] = sc.next();
            processSize[i] = sc.nextInt();
            proName.add(processname[i]);
            proSize.add(processSize[i]);
        }
        int m = proSize.size();
        int[] prosize = new int[m];
        String[] proname = new String[m];

        for (int i = 0; i < m; i++) {
            prosize[i] = proSize.get(i);
        }
        for (int i = 0; i < m; i++) {
            proname[i] = proName.get(i);
        }
        if(select==1){
            FF f = new FF();
            f.process(prosize, proname);
        }
        if(select==2){
            BF f = new BF();
            f.process(prosize, proname);
        }
        if(select==3){
            WF f = new WF();
            f.process(prosize, proname);
        }
    }

}

