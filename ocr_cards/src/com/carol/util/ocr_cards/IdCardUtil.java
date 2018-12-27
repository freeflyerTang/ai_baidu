package com.carol.util.ocr_cards;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
/**
 * 
 * @author Carol Tang
 * @date 2018��12��21�� ����1:41:12 
 * @version v1.0
 * @Description ���֤ʶ��http://ai.baidu.com/docs#/OCR-Java-SDK/top
 */
public class IdCardUtil {
	// ����APPID/AK/SK
	public static final String APP_ID = "15200546";
	public static final String API_KEY = "boOpGNshlcg5pCVwUvY0yPVB";
	public static final String SECRET_KEY = "jH7ozPWnjXxjn5tZEcjxAfi7ySs2V1Oq";

	public static void main(String[] args) {
		// ��ʼ��һ��AipOcr
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// ��ѡ�������������Ӳ���
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		// ��ѡ�����ô����������ַ, http��socket��ѡһ�����߾�������
		// client.setHttpProxy("proxy_host", proxy_port); // ����http����
		// client.setSocketProxy("proxy_host", proxy_port); // ����socket����

		// ��ѡ������log4j��־�����ʽ���������ã���ʹ��Ĭ������
		// Ҳ����ֱ��ͨ��jvm�����������ô˻�������
		// System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

		// ���ýӿ�
		String path = "E:\\eclipse-workspace\\ocr_cards\\WebRoot\\images\\demo-card-1.png";
		getResult(path);

	}

	public static String getResult(String path) {
		// ��ʼ��һ��AipOcr
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// �����ѡ�������ýӿ�
		HashMap<String, String> options = new HashMap<String, String>();
		// detect_direction�Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:
		// - true����⳯��
		// - false������⳯��
		options.put("detect_direction", "true");

		// detect_risk�Ƿ������֤��������(���֤��ӡ������ʱ���֤�����֤���ġ��޸Ĺ������֤)���ܣ�Ĭ�ϲ�����������false����ѡֵ:
		// true-������
		// false-������
		options.put("detect_risk", "false");

		// front�����֤����Ƭ��һ�棻back�����֤�����յ�һ��
		String idCardSide = "front";

		// ����Ϊ����·��
		JSONObject res = client.idcard(path, idCardSide, options);
		System.out.println(res.toString(2));
		return res.toString(2);
	}
	
	public static String getResult(byte[] file) {
		// ��ʼ��һ��AipOcr
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// �����ѡ�������ýӿ�
		HashMap<String, String> options = new HashMap<String, String>();
		// detect_direction�Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:
		// - true����⳯��
		// - false������⳯��
		options.put("detect_direction", "true");

		// detect_risk�Ƿ������֤��������(���֤��ӡ������ʱ���֤�����֤���ġ��޸Ĺ������֤)���ܣ�Ĭ�ϲ�����������false����ѡֵ:
		// true-������
		// false-������
		options.put("detect_risk", "false");

		// front�����֤����Ƭ��һ�棻back�����֤�����յ�һ��
		String idCardSide = "front";

		
		// ����Ϊ����������
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
			return "��ֵ����";
		}
		
	}
	
	
}
