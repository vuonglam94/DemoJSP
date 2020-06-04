package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Dept;
import utils.DBUtils;

@WebServlet(urlPatterns = "/jstl")
public class JstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JstlServlet() {
	        super();
	    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Truy vấn dữ liệu từ DB (Mô phỏng).
		List<Dept> list = DBUtils.queryDepartments();
		// Lưu dữ liệu vào thuộc tính 'departments' của request.
		request.setAttribute("departments", list);
		// Tạo đối tượng RequestDispatcher
		// để Forward (chuyển tiếp) yêu cầu tới jstl_core_example01.jsp
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/jsps/jstl.jsp");
		// Forward (Chuyển tiếp) yêu cầu, để hiển thị dữ liệu trên trang JSP.
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
