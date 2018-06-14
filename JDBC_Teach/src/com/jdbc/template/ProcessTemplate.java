package com.jdbc.template;

import com.jdbc.template.interf.Command;
import com.jdbc.template.interf.imple.AddCommand;
import com.jdbc.template.interf.imple.PrintCommand;

public class ProcessTemplate {

    public void calculate(int[] array, Command command) {
        System.out.println("��ȡһ��Connection����......");
        command.process(array);
        System.out.println("�ͷ����ݿ�ռ�õ���Դ......");
    }
    
    public static void main(String[] args) {
        ProcessTemplate template = new ProcessTemplate();
        int[] arr = {1, 2, 4, 8};
        template.calculate(arr, new AddCommand());
        template.calculate(arr, new PrintCommand());
        template.calculate(arr, new Command() {

            @Override
            public void process(int[] array) {
                int num = 1;
                for (int i : arr) {
                    num *= i;
                }
                System.out.println("�����Ա�ĳ˻�Ϊ:" + num);
            }
            
        });
    }
}
