import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String pattern = "(100+1+|01)+";
        Pattern pt = Pattern.compile(pattern);
        Matcher matcher;

        while (N-- > 0){
            st = new StringTokenizer(br.readLine());
            matcher = pt.matcher(st.nextToken());
            if (matcher.matches()){
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}

