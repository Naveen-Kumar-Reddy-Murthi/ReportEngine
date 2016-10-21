package org.mnr.engine.job;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClass {

	public static void main(String[] args) throws ParseException {
		
		String input ="2016-10-21T18:41";
//		input=input.substring(0, input.indexOf('T'));
		input=input.replace('T', ' ');
		System.out.println("input String:  "+input);
		
//		input=input.substring(0, input.indexOf(' '));
//		System.out.println(input);
		
		SimpleDateFormat sdf	=	new SimpleDateFormat("yyyy-MM-dd kk:mm");
		Date inputDate= new Date();
		inputDate=sdf.parse(input);
//		System.out.println("inputDate   :  "+inputDate);
		
		Date curDate = new Date();
//		System.out.println("current Date:  "+curDate);
		
		
		
		SimpleDateFormat formatter	=	new SimpleDateFormat("EEEE, kk:mm");
		System.out.println("day of the week:"+formatter.format(curDate));
		if(formatter.format(curDate).equals(formatter.format(inputDate))){
			System.out.println("inputDate:"+formatter.format(inputDate));
			System.out.println("currentDate:"+formatter.format(curDate));
			System.out.println("weekly match");
		}
		else
			System.out.println("weekly not matched");
		
		formatter= new SimpleDateFormat("dd kk:mm");
		System.out.println("day of month:"+formatter.format(inputDate));
		if(formatter.format(curDate).equals(formatter.format(inputDate))){
			System.out.println("monthly match");
		}
		else
			System.out.println("monthly not matched");
		
		formatter= new SimpleDateFormat("dd-MM kk:mm");
		System.out.println("day of year:"+formatter.format(inputDate));
		if(formatter.format(curDate).equals(formatter.format(inputDate))){
			System.out.println("yearly match");
		}
		else
			System.out.println("yearly not matched");

	}

}
