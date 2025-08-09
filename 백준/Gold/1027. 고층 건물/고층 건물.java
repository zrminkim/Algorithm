import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] h = new int[N];

        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        int buildingCount = 0;

        for (int i = 0; i < N; i++){
            int visible = getVisible(i, N, h);

            buildingCount = Math.max(buildingCount, visible);
        }

        System.out.println(buildingCount);
    }

    private static int getVisible(int i, int N, int[] h) {
        int visible = 0;

        double maxSlope = -Double.POSITIVE_INFINITY;
        for (int j = i +1; j < N; j++){
            double s = (double) (h[j] - h[i]) / (j - i);
            if(s > maxSlope){
                visible++;
                maxSlope = s;
            }
        }

        double minSlope = Double.POSITIVE_INFINITY;
        for(int k = i -1 ; k >= 0; k--){
            double s = (double) (h[k] - h[i]) / (k - i);
            if(s < minSlope){
                visible++;
                minSlope = s;
            }
        }
        return visible;
    }
}

