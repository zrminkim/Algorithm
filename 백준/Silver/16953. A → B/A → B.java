import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int count(long a, long b){
        int cnt =0;
        Queue<Long> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i < size; i++){
                long temp = queue.poll();

                if(temp == b){
                    return cnt + 1;
                }
                if(temp * 2 <= b){
                    queue.add(temp * 2);
                }
                if(temp * 10 + 1 <= b){
                    queue.add(temp*10+1);
                }
            }
            cnt++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정수 A를 B로 바꿔야한다.
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(count(A,B));

    }
}
// 또 다른 풀이
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        // 정수 A를 B로 바꿔야 한다.
//        long A = Long.parseLong(st.nextToken());
//        long B = Long.parseLong(st.nextToken());
//
//        int cnt = 1;
//        while ( B != A){
//            if(B < A){
//                cnt = -1;
//                break;
//            }
//            String str = String.valueOf(B);
//
//            if(str.charAt(str.length()-1) != '1' && B % 2 !=0 ){
//                cnt = -1;
//                break;
//            }
//            if(B % 2 ==0){
//                B /= 2;
//            }else{
//                str = str.substring(0,str.length()-1);
//                B = Long.parseLong(str);
//            }
//            cnt++;
//        }
//        System.out.println(cnt);
//    }
//}