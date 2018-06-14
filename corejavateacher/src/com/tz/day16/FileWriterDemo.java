package com.tz.day16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileWriterDemo
{
	private static final String PATH = "record.log";
	
	public static void writeText(String text) {
		//
		File file = new File(PATH);
		//
		if(!file.exists()) {
			System.out.println("文件不存在...");
		}
		//
//		try(FileWriter fw = new FileWriter(file);) { //替换模式
//		try(FileWriter fw = new FileWriter(file,true);) {//追加模式
		try(PrintWriter fw = 
			new PrintWriter(new FileWriter(file, true),true);) {
			//写入文本
//			fw.write(text);
			fw.println(text); //写入完text后，会自动追加换行符
		}catch(IOException e) {
			e.printStackTrace();
		}
	} // end of writeText
	
	//从键盘读取用户的输入，并写入到PATH指定的文件中
	public static void readFromSystemIn() {
		//定义变量来保存读取的行
		String line = null;
		try(BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));) {
			//循环
			while(true){
				//提示用户输入
				System.out.print("请输入>");
				//
				line = br.readLine();
				//判断
				if(line.equalsIgnoreCase("exit")) {
					break; //退出
				}
				//把读到的字符串写入到path中
				writeText(line);
			}
			System.out.println("\n:)谢谢使用!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		readFromSystemIn();
	}
}
