import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> card = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i <= N; i++){
            card.add(i);
        }

        while(card.size() > 1){
            card.poll();
            card.offer(card.poll());
        }
        System.out.println(card.poll());
    }
}