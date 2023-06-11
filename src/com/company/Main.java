package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Select the policy you want to apply: ");
        System.out.print("1. First fit\n" +
                "2. Best fit\n"+
                "3. Worst fit" );

        int select = sc.nextInt();
        partition p1 = new partition();
        p1.partitions(select);

        process p2 = new process();
        p2.processes(select);
        if(select==1){
            FF f = new FF();
            f.firstFit();
        }
        if(select==2){
            BF f = new BF();
            f.firstFit();
        }
        if(select==3){
            WF f = new WF();
            f.firstFit();
        }

    }
}
