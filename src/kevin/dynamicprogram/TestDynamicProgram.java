package kevin.dynamicprogram;

/**
 * @author kevin Pu
 */
public class TestDynamicProgram {

    public static void main(String[] args) {
        testCutRod();
    }

    private static void testCutRod() {
        int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int Rn1 = CutRod.cutRod(p, 10); // 2s 635ms
        int Rn2 = CutRod.memoCutRod(p, 10); // 1s 875ms
        int Rn3 = CutRod.bottomUpcutRod(p, 10); // 1s 875ms

        System.out.println(Rn1);
        System.out.println(Rn2);
        System.out.println(Rn3);
    }
}
