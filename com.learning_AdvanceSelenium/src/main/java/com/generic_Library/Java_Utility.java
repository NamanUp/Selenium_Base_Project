package com.generic_Library;

import java.util.Date;

public class Java_Utility {

	public static String getName() {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		String name = "Report_"+time;
		return name;
	}
}
