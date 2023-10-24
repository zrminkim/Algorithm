import java.io.*;
import java.util.*;

class Main {
    static class Pair implements Comparable<Pair>{
        int index;
        int value;
        public Pair(int index, int value){
            this.index = index;
            this.value = value;
        }
        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // 우선 순위 큐
        int max = 0;
        for(int i=0; i < N; i++){
            pq.add(new Pair(i, Integer.parseInt(st.nextToken())));
        }
        int idx = 0;
        while (!pq.isEmpty()){
            Pair pair = pq.poll();

            if(max < pair.index - idx){
                max = pair.index - idx;
            }

            idx++;
        }
        System.out.println(max);
    }
}