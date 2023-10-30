import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 저장된 String char로 하나씩 확인 cnt로 비교하여 YES / NO 판별
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i < N; i++){
            sb.append(bracket(br.readLine())).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }
    public static String bracket(String s){

        int count = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                count++;
            } else if (count == 0) {
                return  "NO"; // 시작이 '(' 로 시작안될 때
            } else{
                count--; // 그 외
            }
        }
        if(count == 0){
            return "YES";
        }
        else {
            return "NO";
        }
    }
}
