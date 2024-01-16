import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        /**
         *
         * push : 정수 X를 큐에 넣는다
         * pop : 큐에 가장 앞에 있는 정수를 빼고, 그 수를 출력 큐에 정수가 없는 경우 -1 출력
         * size : 큐에 들어있는 정수의 개수를 출력한다.
         * empty : 큐가 비어 있으면 1, 아니면 0을 출력한다.
         * front : 큐의 가장 앞에 있는 정수를 출력한다. 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         * back : 큐의 가장 뒤에 있는 정수를 출력한다. 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         **/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            String command = st.nextToken();

            switch (command) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(!queue.isEmpty() ? queue.pop() : -1).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(!queue.isEmpty() ? queue.peekFirst() : -1).append("\n");
                    break;
                case "back":
                    sb.append(!queue.isEmpty() ? queue.peekLast() : -1).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
