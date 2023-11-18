import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 도시 갯수
        int N = Integer.parseInt(br.readLine());
        // 거리
        BigInteger[] dist = new BigInteger[N-1];
        // 가격
        BigInteger[] price = new BigInteger[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 거리 저장
        for(int i=0; i < N-1; i++){
            dist[i] = new BigInteger(st.nextToken());
        }
        // 가격 저장
        st = new StringTokenizer(br.readLine());
        for (int k=0; k < N; k++){
            price[k] = new BigInteger(st.nextToken());
        }

        //처음 주유소 비용은 무조건 발생
        BigInteger result = price[0].multiply(dist[0]);
        BigInteger minPrice = price[0];

        for(int i=1; i < price.length -1; i++){
            if(price[i].compareTo(minPrice) < 0){
                result = result.add(price[i].multiply(dist[i]));
                minPrice = price[i];
            }else {
                result = result.add(minPrice.multiply(dist[i]));
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}