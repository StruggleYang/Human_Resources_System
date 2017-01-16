package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MapToEntiy;

import entity.EmployeeLogin;
import entity.leaveTab;
import net.sf.json.JSONArray;

public class AddLeave extends HttpServlet {

	private AdminService service = new AdminService();

	public AddLeave() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	/**
	 * ��ѯȫ�����������Ϣ
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List list = service.getLeaveAll();
		// ��java���List����ת��Ϊjs����������
		JSONArray js = JSONArray.fromObject(list);
		response.getWriter().print(js);
	}

	/**
	 * ����µ������Ϣ
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		leaveTab info = new leaveTab();
		info.setEmployeeNumber(Integer.parseInt(request.getParameter("id")));
		info.setDateBging(request.getParameter("dateBging"));
		info.setDateEnd(request.getParameter("dateEnd"));
		info.setLeaveReason(request.getParameter("leaveReason"));
		info.setLeaveType(request.getParameter("leaveType"));

		response.getWriter().println(service.addLeave(info));
	}

	public void init() throws ServletException {
		// Put your code here
	}
}
