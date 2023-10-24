import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] money = new int[N];
        for(int i=0; i < money.length; i++){
            money[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i = N - 1; i >= 0; i--){
            if(K >= money[i]){
                count += K / money[i];
                K %= money[i];
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
}