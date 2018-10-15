package servlet;

import java.io.IOException; 
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Wechat extends HttpServlet{
	private static Logger logger = Logger.getLogger(Wechat.class.getName()); 
	private static String token = "jinsanpang";  
	
//	public static boolean checkSignature(String signature, String timestamp, String nonce) {  
//        System.out.println("signature:" + signature + "timestamp:" + timestamp + "nonc:" + nonce);  
//        String[] arr = new String[] { token, timestamp, nonce };  
//        // 将token、timestamp、nonce三个参数进行字典序排序  
//        Arrays.sort(arr);  
//        StringBuilder content = new StringBuilder();  
//        for (int i = 0; i < arr.length; i++) {  
//            content.append(arr[i]);  
//        }  
//        MessageDigest md = null;  
//        String tmpStr = null;  
//  
//        try {  
//            md = MessageDigest.getInstance("SHA-1");  
//            // 将三个参数字符串拼接成一个字符串进行sha1加密  
//            byte[] digest = md.digest(content.toString().getBytes());  
//            tmpStr = byteToStr(digest);  
//        } catch (NoSuchAlgorithmException e) {  
//            e.printStackTrace();  
//        }  
//  
//        content = null;  
//        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信  
//        System.out.println(tmpStr.equals(signature.toUpperCase()));  
//        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;  
//    }  
//  
//    /** 
//     * 将字节数组转换为十六进制字符串 
//     *  
//     * @param byteArray 
//     * @return 
//     */  
//    private static String byteToStr(byte[] byteArray) {  
//        String strDigest = "";  
//        for (int i = 0; i < byteArray.length; i++) {  
//            strDigest += byteToHexStr(byteArray[i]);  
//        }  
//        return strDigest;  
//    }  
//  
//    /** 
//     * 将字节转换为十六进制字符串 
//     *  
//     * @param mByte 
//     * @return 
//     */  
//    private static String byteToHexStr(byte mByte) {  
//        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
//        char[] tempArr = new char[2];  
//        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
//        tempArr[1] = Digit[mByte & 0X0F];  
//  
//        String s = new String(tempArr);  
//        return s;  
//    }  
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		logger.warning("Wechat   ----   Wechat");
		System.out.println("========Wechat========== ");  
        logger.info("请求进来了...");  
		Enumeration pNames = request.getParameterNames();
		while(pNames.hasMoreElements()){
			String name = (String) pNames.nextElement();
			String value = request.getParameter(name);
			String log = "name =" + name + "     value =" + value;  
            logger.warning(log);  
		}
		PrintWriter out = response.getWriter();  
		  
		 String signature = request.getParameter("signature");/// 微信加密签名  
	     String timestamp = request.getParameter("timestamp");/// 时间戳  
	     String nonce = request.getParameter("nonce"); /// 随机数  
	     String echostr = request.getParameter("echostr"); // 随机字符串  
	     
//	     if (checkSignature(signature, timestamp, nonce)) {  
//	         
//	     }  	
	     out.print(echostr);  
        out.close();  
        out = null;
	}
	@Override  
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
