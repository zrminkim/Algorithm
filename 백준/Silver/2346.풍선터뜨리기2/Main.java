import java.io.*;
import java.util.*;

public class Main {

    static Deque<int[]> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int[] number = new int[N];
        for(int i=0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        // 첫번째 풍선은 먼저 터뜨린다.
        sb.append("1 ");
        int moveValue = number[0];
        // 풍선 번호와 값을 덱에 같이 저장해야한다.

        for(int i=1; i < N; i++){
            deque.add(new int[]{i+1, number[i]});
        }
        while (!deque.isEmpty()){
            if(moveValue > 0){
                for(int i=1; i < moveValue; i++){
                    deque.add(deque.poll());
                }
                int[] num = deque.poll();
                moveValue = num[1];
                sb.append(num[0]).append(" ");
            }else {
                for(int i=1; i <= -moveValue; i++){
                    deque.addFirst(deque.pollLast());
                }
                int[] num = deque.poll();
                moveValue = num[1];
                sb.append(num[0]).append(" ");
            }

        }
        System.out.println(sb);
    }
}

