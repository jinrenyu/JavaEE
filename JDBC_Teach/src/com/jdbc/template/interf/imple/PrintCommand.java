package com.jdbc.template.interf.imple;

import com.jdbc.template.interf.Command;

public class PrintCommand implements Command {

    @Override
    public void process(int[] array) {
        System.out.println("����ĳ�Ա��:"); 
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

}
