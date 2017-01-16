package util;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class PoiWriteXls {
		/**
		 * ͨ��POI�����󼯺ϣ����ݿ����������
		 * @author StruggleYang
		 * @param objList �û�����Ķ��󼯺�
		 * @throws Exception 
		 */
        public static void xlsReport(List objList) throws Exception {
        		
        	// ��ȡָ������.�ź��������Ϊ�ļ���
	            int replace = objList.get(0).getClass().getName().indexOf(".")+1;
	            String fileName = objList.get(0).getClass().getName().substring(replace);
        	
            // ����Excel�Ĺ������ Workbook,��Ӧ��һ��excel�ĵ�
            HSSFWorkbook wb = new HSSFWorkbook();

            // ����Excel�Ĺ���sheet,��Ӧ��һ��excel�ĵ���tab
            HSSFSheet sheet = wb.createSheet(fileName);
  
            // ������Ԫ����ʽ
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            // ���ñ߿�
            style.setBottomBorderColor(HSSFColor.BLACK.index);
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
            
            // ͨ����������������к���
            List list = objList;
            //  ���Ƚ����ж���͵�Ԫ�����
            HSSFRow row = null;
            HSSFCell cell = null;
            //  ѭ����ʼֵ��ȫ���Ա����
            int i = 0;
            // �����ȡʵ������������ԣ�����Field����  
            Field[] field = list.get(i).getClass().getDeclaredFields(); 
            // ��һ�з�����
            row = sheet.createRow(i);
            row.setHeight((short) 500);// �趨�еĸ߶�
            for( int r1 = 0;r1 < field.length;r1++){
            	// ����excelÿ�п��
                sheet.setColumnWidth(r1, 4000);
            	// ������һ�������򴴽�һ��Excel�ĵ�Ԫ��
                cell = row.createCell(r1);
                // ��Excel�ĵ�Ԫ��������ʽ�͸�ֵ
                cell.setCellStyle(style);
            	// ����ǰ���������������Ʒŵ�һ����Ϊ��ͷ����
            	cell.setCellValue(field[r1].getName());
            }
            
    		//  ѭ��������������,��ѭ�������У���ѭ��������
    		for ( ; i < list.size(); i++) {
    			// һ������Ϊһ�У�����Excel��sheet��һ��
                row = sheet.createRow(i+1);
                row.setHeight((short) 500);// �趨�еĸ߶�
                // ͨ���������������Գ���
                for( int j = 0;j < field.length;j++){
                	// ����excelÿ�п��
                    sheet.setColumnWidth(j, 4000);
                	// ������һ�������򴴽�һ��Excel�ĵ�Ԫ��
                    cell = row.createCell(j);
                    // ��Excel�ĵ�Ԫ��������ʽ�͸�ֵ
                    cell.setCellStyle(style);
                	// ��ȡ��������
                	String name = field[j].getName();
                	// �����Ե����ַ���д�����㹹��get��set����  
                    name = name.substring(0, 1).toUpperCase() + name.substring(1);
                    // ͨ��Method��ȡ����������������Ӧ��get����,
                    Method m = list.get(i).getClass().getMethod("get" + name);
                    // ͨ��invoke����getter������ȡ����ֵ ,��ֹ����ת���쳣�ҿ��ַ�����-1����Ϊ����ռ��һ��
                    String value = (String) m.invoke(list.get(i)).toString();
                	//���ǵ�һ��������ֵ���뵥Ԫ��
                	cell.setCellValue(value);
                }
			}
    		// ����excelÿ�п��
            sheet.setColumnWidth(0, 4000);
            // ѭ������ĩβ���һ�У����һ���ļ�д��ʱ��
    		row = sheet.createRow(i+2);
    		row.setHeight((short) 500);// �趨�еĸ߶�
    		// ���õ�Ԫ�����ݸ�ʽ������Ԫ���ʱ���ʽ����Ϊ
    		HSSFCellStyle style1 = wb.createCellStyle();
    		style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-m-d h:mm:ss"));
            style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 
            style1.setFillForegroundColor(HSSFColor.WHITE.index);

            // ���ñ߿�
            style1.setBottomBorderColor(HSSFColor.RED.index);
    		// ������Ԫ��
    		cell = row.createCell(0);
            // ��Excel�ĵ�Ԫ��������ʽ�͸�ֵ
            cell.setCellStyle(style1);
            cell.setCellValue("д��ʱ�䣺"+new Date());
            
            // ���ļ�ͨ�������д�뱾��
            FileOutputStream os = new FileOutputStream("D:\\"+fileName+".xls");
            // �رո���
            wb.write(os);
            os.close();
    }

}
