package employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet extends HttpServlet {

	public CheckCodeServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* ����ͼƬ������ */
		BufferedImage bi = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
		/* ��ȡ���� */
		Graphics g = bi.getGraphics();
		/* ���û�����ɫ */
		g.setColor(new Color(220, 220, 220));
		/* ������ */
		g.fillRect(0, 0, 100, 50);
		/* �������� */
		char chars[] = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		/* ����������� */
		Random random = new Random();
		// �����߼�String����
		StringBuffer sb = new StringBuffer();

		// ͨ��ѭ�������������4λ��֤��
		for (int i = 0; i < 4; i++) {
			/* ͨ��������������ȡ���������е����� */
			char ch = chars[random.nextInt(36)];
			// ����������֤���ַ�׷�ӵ�sb���������������ж��û��Ƿ�������ȷ
			sb.append(ch);
			/* ͨ��������û�����ɫ */
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			/* �������� */
			g.setFont(new Font("΢���ź�", Font.ITALIC, 30));
			/* ������ */
			g.drawString(ch + "", i * 25, 35);
		}
		// ����������֤����ӵ�request
		request.getSession().setAttribute("checkCode", sb.toString());
		/* ��ͼƬ��������������jpg��ʽд�뵽��Ӧ��������� */
		ImageIO.write(bi, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// �ж���֤���Ƿ�������ȷ
		String code = request.getParameter("code");
		if (code.equals(request.getSession().getAttribute("checkCode"))) {
			response.getWriter().print(true);
		} else {
			response.getWriter().print(false);
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
