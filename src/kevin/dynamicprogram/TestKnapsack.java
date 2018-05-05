package kevin.dynamicprogram;

/**
 * @author kevin Pu
 */
public class TestKnapsack {

    public static void main(String[] args) {

    }

    /**
     * w, v 数组下标从 1 开始
     * <p>
     * m(i, j) = Max(m(i-1, j), m(i-1, j-w[i]) + v[i])
     *
     * @param w 重量数组
     * @param v 价值数组
     * @param c 背包容量
     * @return 最大价值
     */
    public static int knapsack(int[] w, int[] v, int c) {
        int n = w.length - 1;
        int[][] m = new int[n + 1][c + 1];

        for (int i = 1; i <= n; i++) {
            m[i][0] = 0;
        }
        for (int j = 0; j <= c; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                if (j >= w[i]) {
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i]] + v[i]);
                } else {
                    m[i][j] = m[i - 1][j];
                }
            }
        }
        return m[n][c];
    }

    public static int knapsack_1(int[] w, int[] v, int c) {
        int n = w.length - 1;
        int[] m = new int[c + 1];

        for (int j = 0; j <= c; j++) {
            m[j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = c; j >= w[i]; j--) {
                m[j] = Math.max(m[j], m[j - w[i]] + v[i]);
            }
        }
        return m[c];
    }


}
