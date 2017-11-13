package cleanData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CleanData {
	
	public static void main(String[] args) {
		Connection con = null;
	    PreparedStatement pre = null;
	    ResultSet result = null;
	    double temp;
	    int count = 0;
	    try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        System.out.println("开始尝试连接数据库！");
	        String url = "jdbc:oracle:thin:@219.216.64.57:1521:orcl";
	        String user = "fishery";
	        String password = "123456";
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("连接成功！");
	        
	        ArrayList<String[]> list  = new ArrayList<String[]>();
	        //list.add(new String[] {"","",""}); 第一个参数 表名  第二个参数 识别值  之后的参数 清洗的度量值
	        list.add(new String[] {"F_YQLSSJ","ID","JR","SL"});
	        list.add(new String[] {"F_YQLSSJN","DATA_ID","JR","SL"});
	        list.add(new String[] {"F_HDZBTJB","XZLS","MJ"});
	        list.add(new String[] {"F_PWKZK","XH","WSR","YD","HXH","AD","ZL"});
	        list.add(new String[] {"F_SCPLSJG","ID","ZGJ","ZJJ","ZDJ"});
	        list.add(new String[] {"F_YQ2017","QY","CYRYSQB","YZGMDSCT","YXGMHSCT","SCTRMZF","SCTRRYGZ","CYRYSCSS","SCTRJCSS","CSTZSLF","YYJSZGLL"});
	        list.add(new String[] {"F_YQ201708NEW","QY","ZFY","ZQJJSS","ZQCLSSJ","YYJSZGLL","SLFY","SYZJ","SDRL","RYGZ","QT","JCSS","CYZHCTJG","CYSTJG","CYCSSL"});
	        list.add(new String[] {"F_YCJYXX","CM","SJCS","ZDW","JDW"});
	        list.add(new String[] {"F_YCBLXX","CM","CZ","XK","XS","ZDW","JDW","ZJZGL"});
	        list.add(new String[] {"F_YCJBXX","CM","CZ","XK","XS","ZDW","JDW","ZJZGL","HZCZ","HZZD"});
	        
	        for (int i = 0; i < list.size(); i++) {
	        	String[] str = list.get(i);
	        	String sql = "select * from \""+str[0]+"\"";
		        pre = con.prepareStatement(sql);
		        result = pre.executeQuery();
		        
		        while (result.next()){	        	
	        		for (int k = 2; k < str.length; k++) {
	        			try {
	        				if(result.getString(str[k])!=null)
		        			temp = Double.parseDouble(result.getString(str[k]));
						} catch (Exception e) {
							System.out.println(result.getString(str[1])+"     "+str[k]+"     "+result.getString(str[k]));
							count++;
						}
					}
		        }
		        
		        System.out.println(str[0]+"查询完成，共"+count+"条异常数据");
		        count = 0;
			}
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (result != null)
	                result.close();
	            if (pre != null)
	                pre.close();
	            if (con != null)
	                con.close();
	            System.out.println("数据库连接已关闭！");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

}
