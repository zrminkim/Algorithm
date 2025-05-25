import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N];
        int f = 0;
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
            if (f < input[i]) {
                f = input[i];
            }
        }

        int[] count0 = new int[Math.max(f + 1, 2)];
        int[] count1 = new int[Math.max(f + 1, 2)];

        count0[0] = 1;
        count0[1] = 0;
        count1[0] = 0;
        count1[1] = 1;

        for (int i = 2; i <= f; i++) {
            count0[i] = count0[i - 1] + count0[i - 2];
            count1[i] = count1[i - 1] + count1[i - 2];
        }

        for(int i=0; i< N; i++){
            sb.append(count0[input[i]]).append(" ").append(count1[input[i]]).append("\n");
        }
        System.out.println(sb);
    }
}

