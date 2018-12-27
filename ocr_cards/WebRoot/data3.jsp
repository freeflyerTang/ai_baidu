<%@ page language="java" import="java.util.*,com.carol.util.ocr_cards.*" pageEncoding="utf-8"%>
<%
	String img = request.getParameter("path");
	//String filePath = request.getRealPath("/") + "temp\\1.jpg";
	String[] imgStrs = img.split(",");
	String imgStr = imgStrs[1];
	//out.print(imgStr);需要注释掉，否则会返回到data中
	// 返回身份证识别的文字信息
	String result = IdCardUtil.localResult(imgStr);
	
	out.print(result);//print()和println()方法可将各种类型的数据转换成字符串的形式输出
%>