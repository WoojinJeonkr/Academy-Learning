package poject06;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class Fileupload extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}
	
	public void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		File currentDirPath = new File ("c:\\file_repo");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath); // ������ ����Ǵ� ���丮 ����
		factory.setSizeThreshold(1024*1024); // ���� �뷮 ����
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List items = upload.parseRequest(request);
			
			// ÷������ �Ӹ� �ƴ϶� �� ������(text)�� ���۵ȴ�.
			for(int i=0;i<items.size();i++) {
				FileItem fileitem = (FileItem) items.get(i);
				
				if(fileitem.isFormField()) { // �Ϲ� �Ķ�������� ����. �Ϲ� �Ķ���Ͷ�� true 
					// �Ϲ� text �Ķ����
					System.out.println(fileitem.getFieldName()+"="+fileitem.getString("utf-8"));
				} else {
					// ÷������ �Ķ����
					System.out.println("�Ķ���͸�:"+fileitem.getFieldName());
					System.out.println("���ϸ�:"+fileitem.getName());
					System.out.println("����ũ��:"+fileitem.getSize()+"bytes");
					System.out.println("÷������Ÿ��:"+fileitem.getContentType());
					
					//--- IE ����ؼ� ó����
					System.out.println(fileitem.getName().lastIndexOf("\\"));
					System.out.println(fileitem.getName()+"");
					if(fileitem.getSize()>0) {
						int idx = fileitem.getName().lastIndexOf("\\");
						if(idx == -1) {
							idx = fileitem.getName().lastIndexOf("\\");
						}
						String fileName = fileitem.getName().substring(idx+1);
						System.out.println("filename:"+fileName);
						File uploadFile = new File(currentDirPath+"\\"+fileName);
						fileitem.write(uploadFile); // ���丮�� ����
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
