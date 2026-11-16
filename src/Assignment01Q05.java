public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        // TODO: implement
        if (i == j) {
            return 0;
        } else {
            int[] counter = new int[m.length];
            for (int t = 0; t < m.length; t++) {
                if (m[i][t] == 1) {
                    counter[t] = findShortestPath(m, t, j) + 1;
                } else {
                    counter[t] = 0;
                }
            }
            int max = counter[0];
            for (int t = 0; t < counter.length; t++) {
                if (max < counter[t])
                    max = counter[t];
            }
            if (max == 0)
                return -1;
            else {
                int min = max;
                for (int t = 0; t < counter.length; t++) {
                    if (min > counter[t] && counter[t] != 0)
                        min = counter[t];
                }
                return min;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 } }, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } }, 0, 2)); // 2
    }
}