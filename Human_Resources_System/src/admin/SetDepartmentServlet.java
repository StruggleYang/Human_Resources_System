package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import entity.departmentTab;

public class SetDepartmentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SetDepartmentServlet() {
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

		request.setCharacterEncoding("utf-8");
		//  �õ��������ͼ������첽�ύ������
		String type = request.getParameter("type");          
		String departmentID = request.getParameter("departmentID");
		String departmentName = request.getParameter("departmentName");
		boolean rs = false; // ��¼�û��������
		//  �жϲ���������
		if(type.equals("update")){
			try {
				//  ���ݷ�װ������
				departmentTab dep = new departmentTab();
				dep.setDepartmentID(new Integer(departmentID));
				dep.setDepartmentName(departmentName);
				//  ��������service�����޸Ĳ���
				DepartmentService service = new DepartmentService();
				rs = service.updateDepartment(dep);
			} catch (NumberFormatException e) {
				
			}finally{
				//  �����Ƿ񲶻��������͵�ת���쳣�����������
				response.getWriter().print(rs);
			}
			
		}else if(type.equals("insert")){ // ���typeΪinsert���������
			// �ж��û������Ƿ�Ϊ��
			if(departmentName.equals("")){
				response.getWriter().print(rs);
			}else{	
				try {
					//  ���ݷ�װ������
					departmentTab dep = new departmentTab();
					dep.setDepartmentName(departmentName);
					
					// �Ƚ����е�ְ�Ʊ����ݲ����
					DepartmentService service = new DepartmentService();
					//  ��ȡ������ְ����Ϣ
					List<departmentTab> list = service.queryAllDepartment();
					//  ����ְ����Ϣ
					boolean flag = true; // �ж��û������ֵ�Ƿ������ݿ��д���
					int max = 0;
					for(departmentTab dt:list){
						//  �ҵ�id�е����ֵ
						if(max<dt.getDepartmentID()){
							max=dt.getDepartmentID();
						}
						if(dep.getDepartmentName().equals(dt.getDepartmentName())){
							flag=false;
						}
					}
					//  ��id�����ֵ��1��Ϊ������ݵ�id
					dep.setDepartmentID(max+1);
					// ���������ݿ��д���ʱ���������ְ����Ϣ
					if(flag){
						rs =  service.insertOneDepartment(dep);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					response.getWriter().print(rs);
				}
				
			}
		}
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

		//  ��ѯ���в�����Ϣ
		String type = request.getParameter("selectType");
		if(type.equals("AllDepartment")){
			DepartmentService service = new DepartmentService();
			//  ��ȡ�����в�����Ϣ
			List list = service.queryAllDepartment();
			if(list.size()>0){
				// ��java���List����ת��Ϊjs����������,���ش�
				JSONArray js = JSONArray.fromObject(list);
				response.getWriter().print(js);
			}else{
				JSONArray js = JSONArray.fromObject(null);
				response.getWriter().print(js);
			}
		}else{
			JSONArray js = JSONArray.fromObject(null);
			response.getWriter().print(js);
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
