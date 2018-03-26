### 动态规划

 1. 通过子问题的解来求解原问题的解
 2. 存在重叠子问题的情况，即不同子问题具有公共的子问题；
 3. 通常用来求解最优化问题

求解步骤：
 1. 刻画一个最优解的结构特征
 2. 递归的定义最优解的值
 3. 计算最优解的值，通常采用自底向上的方法
 4. 利用计算出的信息构造一个最优解
 
 ### 例题 1 钢条切割 
 
 给定一段长度为 n 英尺的钢条和一个价格表 p<sub>i</sub>(i=1, 2, ..., n)，
 求切割钢铁方案，使销售收益 <sub>n</sub> 最大。
 R
 价格表样例：
 
 | 长度 i | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10
 |:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
 | 价格pi | 1 | 5 | 8 | 9 | 10 | 17 | 17	| 20 | 24 | 30 

+ 递归解法, 时间复杂度 O(2^n)

```java
public static int cutRod(int[] p, int n) {
    if (n == 0) return 0;
    int max = 0;
    for (int i = 1; i <= n; i++) {
        int tmp = p[i] + cutRod(p, n - i);
        max = max >= tmp ? max : tmp;
    }
    return max;
}
```
+ 带备忘录的自顶向下法, 时间复杂度 O(n^2)
```java
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
```
+ 自底向上法, 时间复杂度 O(n^2)
```java
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
```