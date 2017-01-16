package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.PoiWriteXls;
import entity.attendanceCountTab;
import entity.attendanceCountView;
import entity.departmentTab;
import entity.employeeInfoTab;
import entity.rankTab;
import entity.salaryInfoTab;

public class ReportTabServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ReportTabServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String reportTabs = request.getParameter("reportTabs");
			ReportTabService service = new ReportTabService();
			boolean flag = false;
			// �����","���ύ�����ָ�
			// ���û��","��ֻ�ύ��һ��������ָ�
			if(reportTabs.indexOf(",")!=-1){
				String[] reports  = reportTabs.split(",");
				for(int i=0;i < reports.length;i++){
					if(reports[i].equals("rankTab")){
						// ִ�в�ѯȫ������
						List<rankTab> list = service.reportRankTab(rankTab.class);
						try {
							PoiWriteXls.xlsReport(list);
							flag = true;
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							//  �����Ƿ񲶻��������͵�ת���쳣�����������
							response.getWriter().print(flag);
						}
					}else if(reports[i].equals("departmentTab")){
						// ִ�в�ѯȫ������
						List<departmentTab> list = service.reportDepartmentTab(departmentTab.class);
						try {
							PoiWriteXls.xlsReport(list);
							flag = true;
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							//  �����Ƿ񲶻��������͵�ת���쳣�����������
							response.getWriter().print(flag);
						}
					}else if(reports[i].equals("employeeInfoTab")){
						// ִ�в�ѯȫ������
						List<employeeInfoTab> list = service.reportEmployeeInfoTab(employeeInfoTab.class);
						try {
							PoiWriteXls.xlsReport(list);
							flag = true;
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							//  �����Ƿ񲶻��������͵�ת���쳣�����������
							response.getWriter().print(flag);
						}
					}else if(reports[i].equals("attendanceCountTab")){
						// ִ�в�ѯȫ������
						List<attendanceCountView> list = service.reportAttendanceCountView(attendanceCountTab.class);
						try {
							PoiWriteXls.xlsReport(list);
							flag = true;
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							//  �����Ƿ񲶻��������͵�ת���쳣�����������
							response.getWriter().print(flag);
						}
					}else if(reports[i].equals("salaryInfoTab")){
						// ִ�в�ѯȫ������
						List<salaryInfoTab> list = service.reportSalaryInfoTab(salaryInfoTab.class);
						try {
							PoiWriteXls.xlsReport(list);
							flag = true;
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							//  �����Ƿ񲶻��������͵�ת���쳣�����������
							response.getWriter().print(flag);
						}
					}
				}
			}else{
					if(reportTabs.equals("rankTab")){
						// ִ�в�ѯȫ������
						List<rankTab> list = service.reportRankTab(rankTab.class);
						try {
							PoiWriteXls.xlsReport(list);
							flag = true;
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							//  �����Ƿ񲶻��������͵�ת���쳣�����������
							response.getWriter().print(flag);
						}
					}else if(reportTabs.equals("departmentTab")){
						// ִ�в�ѯȫ������
						List<departmentTab> list = service.reportDepartmentTab(departmentTab.class);
						try {
							PoiWriteXls.xlsReport(list);
							flag = true;
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							//  �����Ƿ񲶻��������͵�ת���쳣�����������
							response.getWriter().print(flag);
						}
					}else if(reportTabs.equals("employeeInfoTab")){
						// ִ�в�ѯȫ������
						List<employeeInfoTab> list = service.reportEmployeeInfoTab(employeeInfoTab.class);
						try {
							PoiWriteXls.xlsReport(list);
							flag = true;
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							//  �����Ƿ񲶻��������͵�ת���쳣�����������
							response.getWriter().print(flag);
						}
					}else if(reportTabs.equals("attendanceCountTab")){
						// ִ�в�ѯȫ������
						List<attendanceCountView> list = service.reportAttendanceCountView(attendanceCountView.class);
						try {
							PoiWriteXls.xlsReport(list);
							flag = true;
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							//  �����Ƿ񲶻��������͵�ת���쳣�����������
							response.getWriter().print(flag);
						}
					}else if(reportTabs.equals("salaryInfoTab")){
						// ִ�в�ѯȫ������
						List<salaryInfoTab> list = service.reportSalaryInfoTab(salaryInfoTab.class);
						try {
							PoiWriteXls.xlsReport(list);
							flag = true;
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							//  �����Ƿ񲶻��������͵�ת���쳣�����������
							response.getWriter().print(flag);
						}
					}
				}
			}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
