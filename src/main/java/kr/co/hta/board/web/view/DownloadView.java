package kr.co.hta.board.web.view;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import kr.co.hta.board.exception.SimpleBoardException;

@Component
public class DownloadView implements View {

	@Override
	public String getContentType() {
		return "application/octet-stream";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String directory = (String) model.get("directory");
		String filename = (String) model.get("filename");
		File file = new File(directory, filename);
		
		if(!file.exists()) {
			throw new SimpleBoardException("파일이 존재하지 않습니다.");
		}
		
		filename = URLEncoder.encode(filename, "UTF-8");
		response.setContentType(getContentType());
		response.setHeader("content-Disposition", "attatchment; filename=\"" + filename + "\";");

		FileInputStream in = new FileInputStream(file);
		IOUtils.copy(in, response.getOutputStream());
		
		in.close();
	}
	
}