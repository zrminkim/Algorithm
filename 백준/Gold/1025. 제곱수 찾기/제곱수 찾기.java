import java.io.*;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rc = br.readLine();
        StringTokenizer st = new StringTokenizer(rc, " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] table = new char[N][M];

        int max = -1;

        for (int row = 0; row < N; row++) {
            String number = br.readLine();
            for (int cul = 0; cul < M; cul++) {
                table[row][cul] = number.charAt(cul);
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int dr = -N; dr <= N; dr++) {
                    for (int dc = -M; dc <= M; dc++) {
                        if (dr == 0 & dc == 0) continue;
                        int nr = r;
                        int nc = c;

                        StringBuilder sb = new StringBuilder();

                        while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                            sb.append(table[nr][nc]);
                            long sq = Long.parseLong(String.valueOf(sb));
                            long sqrt = (long) Math.sqrt(sq);

                            if (sqrt * sqrt == sq) {
                                if (sq > max) {
                                    max = (int) sq;
                                }
                            }
                            nr += dr;
                            nc += dc;
                        }
                    }
                }
            }
        }
        System.out.println(max);

    }
}

