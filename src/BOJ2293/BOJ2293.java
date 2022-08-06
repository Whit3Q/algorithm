package BOJ2293;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2293 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] list = new int[100];
    static int[] dp = new int[10001];
    static int N;
    static int K;

        public int solution(int[] numbers, int target) {

            return solve(numbers, target, 1, numbers[0]) + solve(numbers, target, 1, -numbers[0]);
        }
        private int solve(int[] numbers, int target, int index, int sum) {
            if(numbers.length == index ) {
                if(target == sum) {
                    return 1;
                }
                return 0;
            }

            int result = solve(numbers, target, index + 1, sum + numbers[index])
                    + solve(numbers, target, index + 1, sum - numbers[index]);

            return result;
        }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }


        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = list[i]; j <= K; j++) {
                dp[j] += dp[j - list[i]];
            }
        }


        System.out.println(dp[K]);
    }
}
