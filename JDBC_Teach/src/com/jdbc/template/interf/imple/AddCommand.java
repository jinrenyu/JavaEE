package com.jdbc.template.interf.imple;

import com.jdbc.template.interf.Command;

public class AddCommand implements Command {

    @Override
    public void process(int[] array) {
        int num = 0;
        for (int i : array) {
            num += i;
        }
        System.out.println("数组内的和为:" + num);
    }

}
