import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i < N; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);

        int sum = 0; // 줄 서는 사람들의 시간 총합
        int prev = 0; // 이전 사람들 출금 시간의 합

        for(int i=0; i < N; i++){
            prev += p[i];
            sum += prev;
        }

        System.out.println(sum);
        

    }
}