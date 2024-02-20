import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Deque<Balloon> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] number = new int[N];

        for(int i=0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        sb.append("1 ");
        int moveValue = number[0];

        for(int j=1; j < N; j++){
            deque.add(new Balloon(j+1,number[j]));
            // 풍선 번호와 숫자를 저장
        }
        while(!deque.isEmpty()){// 풍선이 다 터질 때까지
            if(moveValue > 0){
                for(int i=1; i < moveValue; i++){
                    deque.offer(deque.poll()); //앞에 있는 요소 빼서 뒤로 저장
                }
                Balloon balloonValue = deque.poll();
                // 움직임을 끝낸 후 첫번쨰 요소 반환
                moveValue = balloonValue.value;
                int index = balloonValue.idx;
                sb.append(index).append(" ");
            } else {
                for(int i= 1; i <= -moveValue; i++){
                    deque.addFirst(deque.pollLast());
                }
                Balloon balloonValue = deque.poll();
                moveValue = balloonValue.value;
                int index = balloonValue.idx;
                sb.append(index).append(" ");
            }
        }
        System.out.println(sb);
    }
}
class Balloon {
    int idx;
    int value;

    Balloon(int idx, int value){
        this.idx = idx;
        this.value = value;
    }
}