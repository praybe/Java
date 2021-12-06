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
@WebServlet("*.do") //���������������� *.do�� ����
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
		BCommand command = null; //�� �κ��� ������ Command��
		
		//
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		
		if(com.equals("/list.do")) { //list.do��� ġ�� ���� BController��ü�� ó���ϰڴ�. �׷��� actionDo�� Ÿ�� ��
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			
		}else if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp"; //�� ���� jsp ���������
		
		
		}else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);//insert��Ű�� view�������� list.do�� �ؾ���
			viewPage = "list.do"; //�������� �ٽ� ��Ű�� �ٽ� ó�� /list.do�� �����ϴ� ��
		}
		
		else if(com.equals("/content_view.do")) {
			viewPage = "content_view.jsp"; //
		
		}else if(com.equals("/modify.do")) {
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "list.do"; 
		}
		
		
		
		//���Ķ�ġ ��ü ����.  
		//viewpage �����ϸ� �� �������� �������� ���� ��
		//�������� ���Ѽ� ������. request.jsp���� �Ѱܼ� ������
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); 
		
	}

}
