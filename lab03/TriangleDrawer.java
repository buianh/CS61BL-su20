public class TriangleDrawer {
    public static void main(String[] args) {
        int row = 0;
        int SIZE = 10;
        System.out.println();
        while (row < SIZE) {
            int col = 0;
            while (col < row) {
                System.out.print('*');
                col++;
            }
            System.out.println('*');
            row++;
        }
    }
}
