// lab3b.java
// Fall 2025
// Dylan Neese
// Demonstrates recursive algorithm to "flood fill"
// an ASCII graphic

class lab3b {
    public static void main(String[] args) {
        // grid represents a graphic image
        char grid[][] = {
            { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' },
            { 'g', 'g', ' ', 'g', 'g', ' ', ' ', ' ', 'g' },
            { 'g', 'g', ' ', ' ', ' ', ' ', 'g', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', 'g', ' ', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', 'g', ' ', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'g' },
            { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' }
        };

        // show starting grid
        display(grid);

        // fill open space ' ' with 'r'
        floodFill(grid, 5, 3, 'r', 'g');
        display(grid);

        // fill border with 'i'
        floodFill(grid, 0, 0, 'i', 'r');
        display(grid);
    }

    // flood fill 2D char array
    public static void floodFill(char temp[][], int row, int col, char fillColor, char borderColor) {
        // base case: out of bounds
        if (row < 0 || col < 0 || row >= temp.length || col >= temp[0].length) return;

        // base case: already filled or hit border
        if (temp[row][col] != fillColor && temp[row][col] != borderColor) {

        // fill current cell
            temp[row][col] = fillColor;

        // recursive calls in 8 directions
            floodFill(temp, row - 1, col, fillColor, borderColor);     // fill up
            floodFill(temp, row + 1, col, fillColor, borderColor);     // fill down
            floodFill(temp, row, col - 1, fillColor, borderColor);     // fill left
            floodFill(temp, row, col + 1, fillColor, borderColor);     // fill right
            floodFill(temp, row - 1, col - 1, fillColor, borderColor); // fill up-left
            floodFill(temp, row - 1, col + 1, fillColor, borderColor); // fill up-right
            floodFill(temp, row + 1, col - 1, fillColor, borderColor); // fill down-left
            floodFill(temp, row + 1, col + 1, fillColor, borderColor); // fill down-right
    }
}
    // display array
    public static void display(char temp[][]) {
        for (int r = 0; r < temp.length; r++) {
            for (int c = 0; c < temp[r].length; c++) {
                System.out.print(temp[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
