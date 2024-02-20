import java.io.*;
import java.util.*;

public class Main {

    static Queue<Integer> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        // 스택, 큐 둘다 사용
        // 학생 수, 번호표
        // 먼저 배열에 순서대로 저장
        // 순서대로만 들어갈 수 있는 라인으로 가기 조건
        // 순서가 아닌 숫자는 스택으로 들어가 저장
        // 순서대로 들어갈 수 있으면 Nice, 그렇지 못하면 Sad
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] line = new int[N];

        for(int i=0; i < N; i++){
            line[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(foodPriority(line));
        bw.close();
        br.close();
    }

    public static String foodPriority(int[] lineStack){
        int comparisonValue = 1;
        Stack<Integer> tmpStack = new Stack<>();
        // comparisonValue와 linestack의 값이 맞지 않을 경우
        // stack 내부에 저장되어 있는 요소들도 비교를 해야하는 부분이 있어야한다.
        // stack 내부에 comparisonValue과 같은 값이 있는지 확인
        // 없으면 lineStack에 요소를 stack에 저장
        // 순서대로 나가서 다 pop 됐을 경우 true, 그렇지 못하면 false
        for(int i=0; i < lineStack.length; i++){
            if(lineStack[i] != comparisonValue){
                if(!tmpStack.isEmpty() && tmpStack.peek() == comparisonValue){
                    tmpStack.pop();
                    i--; // 배열이 아닌 tmpStack내에 들어가 있는 값들을 없애기 위해 한번 더 반복
                    comparisonValue++;
                }else{
                    tmpStack.push(lineStack[i]);
                }
            }else {
                comparisonValue++;
            }
        }
        boolean result = true;
        for(int j=0; j < tmpStack.size(); j++){
            // 위에서 제거를 했어도 stack에 남아 있는 값이 있을 수 있다.
            int tmpValue = tmpStack.pop();
           if(tmpValue == comparisonValue){
               comparisonValue++;
           }else {
               result = false;
           }
        }
        return result ? "Nice" : "Sad";
    }
}