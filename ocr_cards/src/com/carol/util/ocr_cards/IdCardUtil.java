package com.carol.util.ocr_cards;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
/**
 * 
 * @author Carol Tang
 * @date 2018年12月21日 下午1:41:12 
 * @version v1.0
 * @Description 身份证识别http://ai.baidu.com/docs#/OCR-Java-SDK/top
 */
public class IdCardUtil {
	// 设置APPID/AK/SK
	public static final String APP_ID = "15200546";
	public static final String API_KEY = "boOpGNshlcg5pCVwUvY0yPVB";
	public static final String SECRET_KEY = "jH7ozPWnjXxjn5tZEcjxAfi7ySs2V1Oq";

	public static void main(String[] args) {
		// 初始化一个AipOcr
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		// 可选：设置代理服务器地址, http和socket二选一，或者均不设置
		// client.setHttpProxy("proxy_host", proxy_port); // 设置http代理
		// client.setSocketProxy("proxy_host", proxy_port); // 设置socket代理

		// 可选：设置log4j日志输出格式，若不设置，则使用默认配置
		// 也可以直接通过jvm启动参数设置此环境变量
		// System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

		// 调用接口
		String path = "E:\\eclipse-workspace\\ocr_cards\\WebRoot\\images\\demo-card-1.png";
		getResult(path);

	}

	public static String getResult(String path) {
		// 初始化一个AipOcr
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		// detect_direction是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:
		// - true：检测朝向；
		// - false：不检测朝向。
		options.put("detect_direction", "true");

		// detect_risk是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:
		// true-开启；
		// false-不开启
		options.put("detect_risk", "false");

		// front：身份证含照片的一面；back：身份证带国徽的一面
		String idCardSide = "front";

		// 参数为本地路径
		JSONObject res = client.idcard(path, idCardSide, options);
		System.out.println(res.toString(2));
		return res.toString(2);
	}
	
	public static String getResult(byte[] file) {
		// 初始化一个AipOcr
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		// detect_direction是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:
		// - true：检测朝向；
		// - false：不检测朝向。
		options.put("detect_direction", "true");

		// detect_risk是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:
		// true-开启；
		// false-不开启
		options.put("detect_risk", "false");

		// front：身份证含照片的一面；back：身份证带国徽的一面
		String idCardSide = "front";

		
		// 参数为二进制数组
		JSONObject res = client.idcard(file, idCardSide, options);
	    System.out.println(res.toString(2));
		return res.toString(2);
	}
	
	public static String localResult(String imgStr) {
		byte[] file = Base64Utils.Base64ToImage(imgStr);
		if (file!=null) {
			String result =  getResult(file);
			return result;
		}else {
			return "空值错误";
		}
		
	}
	
	
}
