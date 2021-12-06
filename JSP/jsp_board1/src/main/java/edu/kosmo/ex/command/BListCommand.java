package edu.kosmo.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.dao.BDao;
import edu.kosmo.ex.dto.BDto;

public class BListCommand implements BCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {;
	
	BDao dao = new BDao();
	ArrayList<BDto> dtos = dao.list(); //게시판 글 내용
	
	// 포워딩 될 떄까지 게시판 글 살아있음
	// 핵심코드. jsp 코드에 안 넣고 있음 
	request.setAttribute("list", dtos);
			

	}
}
