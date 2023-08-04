package com.kh.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class ListUpdateController
 */
@WebServlet("/notice/update.do")
public class ListUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		NoticeService service = new NoticeService();

		Notice notice =service.detatilNotice(noticeNo);
		if(notice!=null) {
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp").forward(request, response);;
		}
		else {
			request.setAttribute("msg", "실패");
			request.setAttribute("url", "/WEB-INF/views/notice/detail.jsp");
			request.getRequestDispatcher("/WEB-INF/views/commmon/erorrpage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String noticeSubject = request.getParameter("noticeSubject");
		String noticeContent = request.getParameter("noticeContent");
		Notice notice = new Notice(noticeNo,noticeSubject, noticeContent);
		NoticeService service = new NoticeService();
		int result = service.updateList(notice);
		if(result>0) {
			response.sendRedirect("/notice/detail.do?noticeNo="+noticeNo);
		}else {
			request.setAttribute("msg", "수정에 실패 했습니다.");
			request.setAttribute("url", "/notice/update.do?noticeNo"+noticeNo);

			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	}

}
