import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] pick = new int[count];
        int sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < count; i++) {
            pick[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 1; j <= N; j++) {
            deque.addLast(j);
        }

        for (int k = 0; k < count; k++) {
            int target = pick[k];

            int index = 0;

            for (int ele : deque) {
                if(target == ele) break;
                index++;
            }

            int left = index;
            int right = deque.size() - index;

            if(left <= right){
                for(int m=0; m < left; m++){
                    deque.offerLast(deque.removeFirst());
                    sum++;
                }
            } else {
                for (int n=0; n < right; n++){
                    deque.offerFirst(deque.removeLast());
                    sum++;
                }
            }
            deque.pollFirst();
        }


        System.out.println(sum);
    }
}

