package servlet;
import java.io.*;

//This is not a servlet, this is just a java program!
public class ImageHtmlOutput{	
	public String getUrl(){
		String[] url = this.getClass().getResource("").toString().split("pwb");
		return url[0];
	}
	public int countFile(String url){
		File f = new File(url);
		return f.listFiles().length - 1;
	}
	
	public String ImageCssForm(int size){
		int i;
		String code = "";
		for(i = 1; i <= size; i++){	
			code+="#s" + i +"{background-image:url(\"../image/image"+ i +".jpg\");}";
		}
		return code;
	}
	
	public String ImageHtmlForm(int size){
		int i;
		String code = "";
		for(i = 1; i <= size; i++){		
			code+="<div class=\"sec\" id=\"s"+ i +"\"></div><div class=\"sub\"></div>";		
		}
		
		return code;
	}
}


