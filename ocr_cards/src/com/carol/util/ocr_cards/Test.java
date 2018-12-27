package com.carol.util.ocr_cards;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		String patternStr = "\\d{6}"; //java中反斜杠要转义
		String str ="<image>";
		Matcher meq = Pattern.compile(patternStr).matcher(str);
		if(meq.matches()){
			System.out.println("~~~完全匹配~~");
			}else{
			System.out.println("无法完全匹配!!!");
			}
	}
}
