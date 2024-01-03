import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * 정수를 저장하는 스택을 구현한 후 입력으로 주어지는 명령얼 처리하는 프로그램을 처리
 *
 * 명령 1 - 정수 X를 스택에 넣는다.
 * 명령 2 - 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 명령 3 - 스택에 들어 있는 정수의 개수를 출력한다.
 * 명령 4 - 스택이 비어 있으면 1, 아니면 0을 출력한다.
 * 명령 5 - 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 *
 * 첫째 줄 명령의 수 N
 * 둘째 줄 부터 N개의 줄에 명령이 하나씩 주어진다.
 *
 * 반복적으로 동작하기에 메소드를 호출해서 return 받는 방식으로 작성해보자.
 * 한꺼번에 출력하기 위해 StringBuilder를 활용
 **/
public class Main {
    static Stack<Integer> stackInt = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            command(br.readLine());
        }
        br.close();
        System.out.println(sb);
    }
    static void command(String com){
        char c = com.charAt(0);

        switch (c){
            case '1' : stackInt.push(Integer.parseInt(com.substring(2)));
                return;
            case '2' : sb.append(stackInt.empty() ? -1 : stackInt.pop()).append("\n");
                return;
            case '3' : sb.append(stackInt.size()).append("\n");
                return;
            case '4' : sb.append(stackInt.empty() ? 1 : 0).append("\n");
                return;
            case '5' : sb.append(stackInt.empty() ? -1 : stackInt.peek()).append("\n");
            break;
        }
    }
}