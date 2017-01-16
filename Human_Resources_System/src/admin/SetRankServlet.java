package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.rankTab;

import net.sf.json.JSONArray;

public class SetRankServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SetRankServlet() {
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
		String rankID = request.getParameter("rankID");
		String rankName = request.getParameter("rankName");
		String rankSalary = request.getParameter("rankSalary");
		boolean rs = false; // ��¼�û��������
		//  �жϲ���������
		if(type.equals("update")){
			try {
				//  ���ݷ�װ������
				rankTab rank = new rankTab();
				rank.setRankID(new Integer(rankID));
				rank.setRankName(rankName);
				rank.setRankSalary(new Double(rankSalary));
				//  ��������service�����޸Ĳ���
				RankService service = new RankService();
				rs = service.updateRank(rank);
			} catch (NumberFormatException e) {
				
			}finally{
				//  �����Ƿ񲶻��������͵�ת���쳣�����������
				response.getWriter().print(rs);
			}
			
		}else if(type.equals("insert")){ // ���typeΪinsert���������
			// �ж��û������Ƿ�Ϊ��
			if(rankName.equals("")||rankSalary.equals("")){
				response.getWriter().print(rs);
			}else{	
				try {
					//  ���ݷ�װ������
					rankTab rank = new rankTab();
					rank.setRankName(rankName);
					rank.setRankSalary(new Double(rankSalary));
					// �Ƚ����е�ְ�Ʊ����ݲ����
					RankService service = new RankService();
					//  ��ȡ������ְ����Ϣ
					List<rankTab> list = service.queryAllRank();
					//  ����ְ����Ϣ
					boolean flag = true; // �ж��û������ֵ�Ƿ������ݿ��д���
					int max = 0;
					for(rankTab rk:list){
						//  �ҵ�id�е����ֵ
						if(max<rk.getRankID()){
							max=rk.getRankID();
						}
						if(rank.getRankName().equals(rk.getRankName())){
							flag=false;
						}
					}
					//  ��id�����ֵ��1��Ϊ������ݵ�id
					rank.setRankID(max+1);
					// ���������ݿ��д���ʱ���������ְ����Ϣ
					if(flag){
						rs =  service.insertOneRank(rank);
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
		
		//  ��ѯ����ְ����Ϣ
		String type = request.getParameter("selectType");
		if(type.equals("AllRank")){
			RankService service = new RankService();
			//  ��ȡ������ְ����Ϣ
			List list = service.queryAllRank();
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
