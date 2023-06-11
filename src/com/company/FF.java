package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class FF {
    static int partitions[];
    static String prt[];
    static int processs[];
    static String pro[];
    static LinkedList<Integer> prtsize = new LinkedList<>();
    static LinkedList<String> prtname = new LinkedList<>();
    static LinkedList<String> proname = new LinkedList<>();
    static LinkedList<String> notAllocated = new LinkedList<>();
    public int sum=0;

    static LinkedList<Integer> notAllInd = new LinkedList<>();
    public void partition(int partitions[], String prt[]) {
        FF.partitions = partitions;
        FF.prt = prt;
        for (int i = 0; i < prt.length; i++) {
            prtsize.add(partitions[i]);
            prtname.add(prt[i]);
        }
    }

    public void process(int process[], String pro[]) {
        FF.processs = process;
        FF.pro = pro;

    }

    public void firstFit() {
        for (int i = 0; i < prt.length; i++) {
            proname.add("-1");
        }
        int n = pro.length;
        for (int i = 0; i < n; i++) {
            int s = prtsize.size();
            for (int j = 0; j < s; j++) {
                if (prtsize.get(j) >= processs[i]) {

                    int remaining = prtsize.get(j) - processs[i];
                    prtsize.set(j, processs[i]);
                    prtsize.add(j + 1, remaining);
                    prtname.add(j + 1, "partition " + (s));
                    proname.add(j, pro[i]);
                    break;
                }
            }
        }
        print();
    }

    public void print() {
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < prtname.size(); i++) {
            if (proname.get(i) == "-1") {
                proname.set(i, "External fragment");
                sum+=prtsize.get(i);
            }
        }
        System.out.println();
        for (int i = 0; i < prtname.size(); i++) {
            System.out.println(prtname.get(i) + " (" + prtsize.get(i) + "KB) => " + proname.get(i));
            System.out.println();
        }

        /*
         * for (int i = 0; i < pro.length; i++) {
         * System.out.print(pro[i] + "  ");
         * }
         */
        for (int i = 0; i < pro.length; i++) {
            for (int j = 0; j < proname.size(); j++) {

                if (proname.get(j) == "External fragment") {
                    continue;
                }
                if (proname.contains(pro[i])) {
                    // System.out.println(pro[i] + " " + proname.get(j));
                    break;
                } else {
                    notAllInd.add(processs[i]);
                    notAllocated.add(pro[i]);
                    // System.out.println(pro[i] + " " + proname.get(j));
                    break;
                }

            }
        }

        System.out.println("Processes that are not allocated are: " + notAllocated);
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to compact? 1.yes 2.no ");
        int comp = sc.nextInt();
        if(comp==1) {
            compact();
        }

    }
    public void compact(){
        int siz=prtname.size();
        prtsize.add(siz, sum);
        prtname.add(siz, "partition " + (siz));
        proname.add(siz, "External fragment");

        for (int i = 0; i < notAllocated.size(); i++) {
            int remaining = prtsize.get(siz) - notAllInd.get(i);
            prtsize.set(siz, notAllInd.get(i));
            proname.set(siz, notAllocated.get(i));
            if(remaining>0) {
                prtsize.add(siz + 1, remaining);
                prtname.add(siz + 1, "partition " + (siz+1));
                proname.add(siz+1, "External fragment");
            }
            siz+=1;
        }
        System.out.println();
        for (int i = 0; i < prtname.size(); i++) {
            if(proname.get(i)!="External fragment"|| i == prtname.size()-1) {
                System.out.println(prtname.get(i) + " (" + prtsize.get(i) + "KB) => " + proname.get(i));
                System.out.println();
            }
        }
            /*int remaining = prtsize.get((prtsize.size() + 1)) - notAllocated.;
            prtsize.set(bestIdx, processs[i]);

            if(remaining>0) {
                prtsize.add(bestIdx + 1, remaining);
                prtname.add(bestIdx + 1, "partition " + (s));
            }
            proname.add(bestIdx, pro[i]);*/
    }
}
/*
 * for (int i = 0; i < pro.length; i++) {
 * for (int j = 0; j < proname.size(); j++) {
 *
 * if (proname.get(j) == "External fragment") {
 * continue;
 * } else if (pro[i] == (proname.get(j))) {
 * System.out.println(pro[i] + "  " + proname.get(j));
 * proname.remove(j);
 * break;
 * } else {
 * notAllocated.add(pro[i]);
 * // System.out.println(pro[i] + " " + proname.get(j));
 * break;
 * }
 *
 * }
 * }
 */
