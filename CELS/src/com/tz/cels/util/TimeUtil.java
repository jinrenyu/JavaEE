package com.tz.cels.util;

public class TimeUtil
{
	public static String formatTime(long ms) {  
        
		 long second = 0;
		 long  minute =0;
		 second=ms/1000;
		 if(second>=60&&second<3600){
			 second=second%60;
			 minute=second/60;
		 }
          
         return minute + " 分钟 " + second + " 秒"; 
	}
}
