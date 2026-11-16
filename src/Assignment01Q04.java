import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (direction != 'R' && direction != 'L')
            return array;
        if (array.length > 0) {
            if (move < 0) {
                if (direction == 'R')
                    return shiftArrayCyclic(array, -1 * move, 'L');
                else
                    return shiftArrayCyclic(array, -1 * move, 'R');
            } else if (move > 0) {
                if (direction == 'R') {
                    int num = array[0];
                    for (int i = 1; i < array.length; i++) {
                        int temp = array[i];
                        array[i] = num;
                        num = temp;
                    }
                    array[0] = num;
                } else {
                    int num = array[array.length - 1];
                    for (int i = array.length - 2; i >= 0; i--) {
                        int temp = array[i];
                        array[i] = num;
                        num = temp;
                    }
                    array[array.length - 1] = num;
                }
                return shiftArrayCyclic(array, move - 1, direction);
            }
            return array;
        }
        return array;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 1, 2, 3, 4, 5 }, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] { 0, 8, 9, 5, 6 }, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[] {}, 3, 'R'))); // []
    }
}