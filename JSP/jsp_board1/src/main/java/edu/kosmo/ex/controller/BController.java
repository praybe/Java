package edu.kosmo.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.command.BCommand;
import edu.kosmo.ex.command.BContentCommand;
import edu.kosmo.ex.command.BListCommand;
import edu.kosmo.ex.command.BWriteCommand;

/**
 * Servlet implementation class BController
 */
@WebServlet("*.do") //전자정부프레임은 *.do로 쓴다
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		BCommand command = null; //이 부분이 수많은 Command들
		
		//
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		
		if(com.equals("/list.do")) { //list.do라고 치고 들어가면 BController객체가 처리하겠다. 그러면 actionDo를 타게 됨
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			
		}else if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp"; //글 쓰는 jsp 만들어주자
		
		
		}else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);//insert시키고 view페이지는 list.do로 해야함
			viewPage = "list.do"; //포워딩을 다시 시키고 다시 처음 /list.do를 실행하는 것
		}
		
		else if(com.equals("/content_view.do")) {
			viewPage = "content_view.jsp"; //
		
		}else if(com.equals("/modify.do")) {
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "list.do"; 
		}
		
		
		
		//파파라치 객체 생성.  
		//viewpage 설정하면 이 페이지를 유저에게 보여 줌
		//포워딩을 시켜서 보여줌. request.jsp에게 넘겨서 보여줌
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); 
		
	}

}
