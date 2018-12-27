<%@ page language="java" import="java.util.*,com.carol.util.ocr_cards.*" pageEncoding="utf-8"%>
<%
	String path = request.getParameter("path");
	String filePath = request.getRealPath("/") + path;
	
	// 返回身份证识别的文字信息
	String result = IdCardUtil.getResult(filePath);
	
	out.print(result);
%>