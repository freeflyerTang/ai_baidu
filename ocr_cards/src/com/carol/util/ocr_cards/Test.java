package com.carol.util.ocr_cards;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		String patternStr = "\\d{6}"; //java�з�б��Ҫת��
		String str ="<image>";
		Matcher meq = Pattern.compile(patternStr).matcher(str);
		if(meq.matches()){
			System.out.println("~~~��ȫƥ��~~");
			}else{
			System.out.println("�޷���ȫƥ��!!!");
			}
	}
}
