package kevin.dynamicprogram;

/**
 * @author kevin Pu
 * <p>
 * 最优子结构的性质：
 * 问题的最优解由相关子问题的最优解组合而成，这些子问题可以独立求解。
 * 朴素的递归效率很低，因为他反复求解相同的子问题；
 * 动态规划方法仔细安排求解顺序，对每个子问题只求解一次，并将结果保存下来，
 * 动态规划有两种等价实现方法：
 * 带备忘录的自顶向下法， 自底向上法
 * <p>
 * 状态方程：
 * Rn = max{pi + Rn-i}, 1 <= i <= n, 初始状态：R0 = 0
 */
public class CutRod {

    /**
     * 递归解法：
     * 时间复杂度 O(2^n)
     */
    public static int cutRod(int[] p, int n) {
        if (n == 0) return 0;

        int max = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = p[i] + cutRod(p, n - i);
            max = max >= tmp ? max : tmp;
        }

        return max;
    }

    /**
     * 带备忘录的自顶向下法
     */
    public static int memoCutRod(int[] p, int n) {
        int[] r = new int[n + 1];
        return memoCutRodAux(p, n, r);
    }

    private static int memoCutRodAux(int[] p, int n, int[] r) {
        if (r[n] > 0) return r[n];

        if (n == 0) return 0;

        for (int i = 1; i <= n; i++) {
            int tmp = p[i] + memoCutRodAux(p, n - i, r);
            r[n] = r[n] >= tmp ? r[n] : tmp;
        }

        return r[n];
    }


    /**
     * 自底向上法
     */
    public static int bottomUpcutRod(int[] p, int n) {
        int[] r = new int[n + 1];

        if (n == 0) return 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int tmp = p[j] + r[i - j];
                r[i] = r[i] >= tmp ? r[i] : tmp;
            }
        }
        return r[n];
    }
}
