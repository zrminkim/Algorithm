import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] buildTime = new int[N + 1]; // 건물 건설 시간
            int[] buildOrder = new int[N + 1]; // 건물 지어지는 인덱스
            int[] result = new int[N + 1]; // 최대 건설 시간

            List<List<Integer>> rule = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                rule.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                rule.get(X).add(Y);
                buildOrder[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                if (buildOrder[i] == 0) {
                    queue.add(i);
                    result[i] = buildTime[i];
                }
            }

            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int next : rule.get(now)) {
                    buildOrder[next]--;
                    result[next] = Math.max(result[next], result[now] + buildTime[next]);

                    if (buildOrder[next] == 0) {
                        queue.add(next);
                    }

                }
            }
            sb.append(result[W]).append("\n");
        }
        System.out.println(sb);
    }
}

