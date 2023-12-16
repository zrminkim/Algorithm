import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        int answer = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(),"-");

        while(st.hasMoreTokens()){
            int temp = 0;
            StringTokenizer str = new StringTokenizer(st.nextToken(),"+");

            while(str.hasMoreTokens()){
               temp += Integer.parseInt(str.nextToken());

            }
            if(answer == Integer.MAX_VALUE){
                answer = temp;
           }else {
                answer -= temp;
            }
        }
        System.out.println(answer);
    }
}
