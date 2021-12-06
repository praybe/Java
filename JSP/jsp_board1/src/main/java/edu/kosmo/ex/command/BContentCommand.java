package edu.kosmo.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.dao.BDao;
import edu.kosmo.ex.dto.BDto;

public class BContentCommand implements BCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {;
	
	String bname = request.getParameter("bname");
	String btitle = request.getParameter("btitle");
	String bcontent = request.getParameter("bcontent");
	

	//°´Ã¼»ý¼º
	BDao dao = new BDao();
	ArrayList<BDto> dtos = dao.list();
	request.setAttribute("content", dtos);
	dao.content(bname, btitle, bcontent);
	
	

	}
}
