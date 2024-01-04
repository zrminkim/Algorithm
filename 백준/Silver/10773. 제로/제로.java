import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * 첫번째 줄에 정수 K 수를 입력 받는 갯수
 * 0일 경우 가장 최근에 저장된 수를 지우고, 아닐경우 그 수를 사용한다.
 * 최종적으로 남은 수들의 합을 출력
 **/
public class Main {
    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for(int i=0; i< K; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                st.push(num);
            }else {
                st.pop();
            }
        }

        long sum = 0;
        for(int num : st){
            sum += num;
        }
        System.out.println(sum);
    }
}
