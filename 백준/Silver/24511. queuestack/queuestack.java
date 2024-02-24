import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 자료구조의 개수
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int[] dataStructure = new int[N];
        for(int i=0; i < N; i++){
            dataStructure[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(dataStructure[i]==0){
                deque.add(num);
            }
        }
        int insertCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i =0; i < insertCount; i++){
            int insert = Integer.parseInt(st.nextToken());
            deque.addFirst(insert);
            sb.append(deque.pollLast()).append(" ");
        }
        br.close();
        bw.write(String.valueOf(sb));
        bw.close();
    }
}