package servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class croppedUpload extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		doPost(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		try{
			response.setContentType("text/html;charset=utf-8");
			String str = request.getParameter("img");
			byte[] toByte = javax.xml.bind.DatatypeConverter.parseBase64Binary(str);
			ByteArrayInputStream bis = new ByteArrayInputStream(toByte);
			BufferedImage image = ImageIO.read(bis);
			bis.close();
			File output = new File("src/profile.jpg");
			ImageIO.write(image, "jpg", output);
			
//			BufferedImage img = ImageIO.read(new ByteArrayInputStream(toByte));
//			String random = UUID.randomUUID().toString();
//			File outputfile = new File("a", random + ".jpg");
//			outputfile.createNewFile();
//			outputfile.setWritable(true);
//			ImageIO.write(img, "jpg", outputfile);
		}catch(Exception e){
			e.printStackTrace();	
		}
	}
}



