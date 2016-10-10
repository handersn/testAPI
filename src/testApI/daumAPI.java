package testApI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class daumAPI {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String keyWord = " 여의도동";
		keyWord = URLEncoder.encode(keyWord, "UTF-8");
		BufferedReader in = null;
		 
        try {
            URL obj = new URL("https://apis.daum.net/local/v1/search/keyword.json?apikey=5daf305bbd0c2f063bca5d86e7a33e61&query=" + keyWord); // 호출할 url
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            
            con.setRequestMethod("GET");
 
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        
            String line;
            while((line = in.readLine()) != null) { // response를 차례대로 출력
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null) try { in.close(); } catch(Exception e) { e.printStackTrace(); }
        }

	}

}
