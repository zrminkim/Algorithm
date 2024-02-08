import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Deque<Integer> deque = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    sb.append(!deque.isEmpty() ? deque.pollFirst() : -1).append("\n");
                    break;
                case 4:
                    sb.append(!deque.isEmpty() ? deque.pollLast() : -1).append("\n");
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 7:
                    sb.append(!deque.isEmpty() ? deque.peekFirst() : -1).append("\n");
                    break;
                case 8:
                    sb.append(!deque.isEmpty() ? deque.peekLast() : -1).append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }

}