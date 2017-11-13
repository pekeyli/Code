package tianchi2017;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Shop {

	public static void main(String[] args) {
		File f1 = new File("/Users/pekey/Desktop/s2.csv");
		File f2 = new File("/Users/pekey/Desktop/e2.csv");
		File o1 = new File("/Users/pekey/Desktop/out.csv");

		String s1 = "";
		String s2 = "";
		String temp = "";

		try {
			BufferedReader r1 = new BufferedReader(new FileReader(f1));
			BufferedReader r2 = new BufferedReader(new FileReader(f2));

			BufferedWriter writer = new BufferedWriter(new FileWriter(o1));

			HashMap<String, ArrayList<String>> shopMap = new HashMap<String, ArrayList<String>>();

			while ((s1 = r1.readLine()) != null) {
				int currentPosition = 0;
				int maxPosition = s1.length();
				int nextComma = 0;
				ArrayList<String> a1 = new ArrayList<String>();
				while (currentPosition < maxPosition) {
					nextComma = nextComma(s1, currentPosition);
					a1.add(nextToken(s1, currentPosition, nextComma));
					currentPosition = nextComma + 1;
					if (currentPosition == maxPosition) {
						a1.add("");
					}
				}
				shopMap.put(a1.get(5), a1);
			}

			while ((s2 = r2.readLine()) != null) {
				int currentPosition = 0;
				int maxPosition = s2.length();
				int nextComma = 0;
				ArrayList a2 = new ArrayList();
				while (currentPosition < maxPosition) {
					nextComma = nextComma(s2, currentPosition);
					a2.add(nextToken(s2, currentPosition, nextComma));
					currentPosition = nextComma + 1;
					if (currentPosition == maxPosition) {
						a2.add("");
					}
				}

				Iterator iter = shopMap.keySet().iterator();
				while (iter.hasNext()) {
					Object key = iter.next();
					ArrayList<String> val = shopMap.get(key);
					if(key.equals(a2.get(2))){
						a2.add(val.get(0));
						a2.add(val.get(1));
						a2.add(val.get(2));
						a2.add(val.get(3));
						a2.add(val.get(4));
					}
					
				}
				System.out.println(a2.toString());
				a2.add(calDis(a2.get(4).toString(),a2.get(5).toString(),a2.get(10).toString(),a2.get(11).toString()));
				
				String lineString = toCSVLine(a2);
				
				writer.write(lineString);
				writer.newLine();

			}

			r1.close();
			r2.close();
			writer.close();
		} catch (FileNotFoundException ex) {
			System.out.println("没找到文件！");
		} catch (IOException ex) {
			System.out.println("读写文件出错！");
		}
	}

	private static int nextComma(String source, int st) {
		int maxPosition = source.length();
		boolean inquote = false;
		while (st < maxPosition) {
			char ch = source.charAt(st);
			if (!inquote && ch == ',') {
				break;
			} else if ('"' == ch) {
				inquote = !inquote;
			}
			st++;
		}
		return st;
	}

	private static String nextToken(String source, int st, int nextComma) {
		StringBuffer strb = new StringBuffer();
		int next = st;
		while (next < nextComma) {
			char ch = source.charAt(next++);
			if (ch == '"') {
				if ((st + 1 < next && next < nextComma) && (source.charAt(next) == '"')) {
					strb.append(ch);
					next++;
				}
			} else {
				strb.append(ch);
			}
		}
		return strb.toString();
	}
	
	private static String calDis(String s1, String s2, String s3, String s4) {
		double x1 = Double.parseDouble(s1);
		double y1 = Double.parseDouble(s2);
		double x2 = Double.parseDouble(s3);
		double y2 = Double.parseDouble(s4);
		return String.valueOf(Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
	}
	
	public static String toCSVLine(ArrayList strArrList) {  
        if (strArrList == null) {  
            return "";  
        }  
        String[] strArray = new String[strArrList.size()];  
        for (int idx = 0; idx < strArrList.size(); idx++) {  
            strArray[idx] = (String) strArrList.get(idx);  
        }  
  
        StringBuffer cvsLine = new StringBuffer();  
        for (int idx = 0; idx < strArray.length; idx++) {  
            String item = addQuote(strArray[idx]);  
            cvsLine.append(item);  
            if (strArray.length - 1 != idx) {  
                cvsLine.append(',');  
            }  
        }  
        return cvsLine.toString();  
    } 
    
    private static String addQuote(String item) {  
        if (item == null || item.length() == 0) {  
            return "\"\"";  
        }  
        StringBuffer sb = new StringBuffer();  
        sb.append('"');  
        for (int idx = 0; idx < item.length(); idx++) {  
            char ch = item.charAt(idx);  
            if ('"' == ch) {  
                sb.append("\"\"");  
            } else {  
                sb.append(ch);  
            }  
        }  
        sb.append('"');  
        return sb.toString();  
    } 

}
