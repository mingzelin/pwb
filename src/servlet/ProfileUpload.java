package servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ProfileUpload extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//System.out.print(request.getContentType());
		try{
			response.setContentType("text/html;charset=utf-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			File f = new File("/Users/elin/Documents/workspace/pwb/WebContent/profileImage/temp");
			if(!f.exists()){
				f.mkdirs();
			}
			factory.setRepository(f);
			ServletFileUpload fileupload = new ServletFileUpload(factory);
			fileupload.setHeaderEncoding("utf-8");
			List<FileItem> fileitems = fileupload.parseRequest(request);
			PrintWriter writer = response.getWriter();
			for(FileItem fileitem: fileitems){
				if(fileitem.isFormField()){//
					String name = fileitem.getFieldName();
					if(name.equals("name")){
						if(!fileitem.getString().equals("")){
							String value = fileitem.getString("utf-8");
							writer.print("uploader:" + value + "<br />");
						}
					}
				}else{
					String filename = fileitem.getName();
					if(filename != null && !filename.equals("")){
						writer.print("the name of the uploading file is: " + filename + "<br />");
						filename = filename.substring(filename.lastIndexOf("\\") + 1);
						filename = UUID.randomUUID().toString()+"_"+filename;
						String filepath = "/Users/elin/Documents/workspace/pwb/WebContent/profileImage/temp/" + filename;
						File file = new File(filepath);
						file.getParentFile().mkdirs();
						file.createNewFile();
						
						InputStream in = fileitem.getInputStream();
						FileOutputStream out = new FileOutputStream(file);
						byte[] buffer = new byte[1024];
						int len;
						while((len = in.read(buffer)) > 0){
							out.write(buffer, 0, len);}
							in.close();
							out.close();
							fileitem.delete();
							writer.print("uploading success!");
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		doGet(request,response);
	}
}