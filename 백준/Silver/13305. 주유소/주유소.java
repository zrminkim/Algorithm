import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 도시 갯수
        int N = Integer.parseInt(br.readLine());
        // 거리
        int[] dist = new int[N-1];
        // 가격
        int[] price = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 거리 저장
        for(int i=0; i < N-1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        // 가격 저장
        st = new StringTokenizer(br.readLine());
        for (int k=0; k < N; k++){
            price[k] = Integer.parseInt(st.nextToken());
        }
        // 합계
        int sum =0;

        //최소 비용
        int min = price[0];

        for(int i=0; i < N-1; i++){
            if(price[i] < min){
                min = price[i];
            }
            sum += min * dist[i];
        }

        System.out.println(sum);
        br.close();
    }
}