package edu.kosmo.ex.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.dao.BDao;

public class BWriteCommand implements BCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {;
	
	String bname = request.getParameter("bname");
	String btitle = request.getParameter("btitle");
	String bcontent = request.getParameter("bcontent");
	

	//°´Ã¼»ý¼º
	BDao dao = new BDao();
	dao.write(bname, btitle, bcontent);
	
	

	}
}
