package com.company;

public class Main {
    public static void print(int[][] arr, int N) {// prints the sudoku
        for (int i = 0; i < N; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------|---------|----------");
            }
            int count1 = 0;
            for (int j = 0; j < N; j++) {


                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + arr[i][j]
                        + " ");

            }
            System.out.println();
        }


    }

    public static void print_initial(int[][] arr, int N) {// prints the sudoku
        for (int i = 0; i < N; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------|---------|----------");
            }
            int count1 = 0;
            for (int j = 0; j < N; j++) {


                if (j % 3 == 0) {
                    System.out.print("|");
                }
                if (arr[i][j] == 0) {
                    System.out.print(" " + "-"
                            + " ");
                } else {
                    System.out.print(" " + arr[i][j]
                            + " ");
                }

            }
            System.out.println();
        }


    }


    /**
     * Returns the first unassigned position from the board
     *
     * @param arr: Sudoku board
     * @return the (x, y) coordinate of the first free position
     */
    static int[] unassigned(int[][] arr) {
        int[] ra = {-1, -1};
        int r = 0, c = 0;
        for (int[] row : arr) {
            c = 0;
            for (int elem : row) {
                if (elem == 0) {
                    ra[0] = r;
                    ra[1] = c;
                    return ra;
                }
                c++;
            }
            r++;
        }
        return ra;
    }

    /**
     * Can this number be used in a particular position?
     * 1. Check row-wise
     * 2. Check column-wise
     * 3. Check box
     * ; if it's not used anywhere
     */
    boolean usedInRow(int[][] grid, int row, int num) {
        for (int elem : grid[row]) {
            if (elem == num) {
                return true;
            }
        }
        return false;
    }

    boolean usedInCol(int[][] grid, int col, int num) {
        int r = -1, c = -1;
        for (int[] row : grid) {
            r++;
            for (int elem : row) {
                c++;
                if (c != col)
                    continue;  // skip column that doesn't match the required column

                if (elem == num) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean usedInBox(int[][] grid, int row, int col, int elem) {
        class GuessBox {
            final int r;
            final int c;

            public GuessBox(int r, int c) {
                this.r = r;
                this.c = c;
            }

            int[] group_terminal(int x) {
                int Grp = (int) x / 3;
                int start = Grp * 3;
                int end = start + 3;
                return (new int[]{start, end});
            }

            int[][] guess() {
                int[] r_terminals = group_terminal(r);

                int[] c_terminals = group_terminal(c);

                return (new int[][]{r_terminals, c_terminals});
            }
        }
        GuessBox guessBox = new GuessBox(row, col);
        int[][] terminals = guessBox.guess();
        for (int i = terminals[0][0]; i < terminals[0][1]; i++) {
            for (int j = terminals[1][0]; j < terminals[1][1]; j++) {
                int box_elem = grid[i][j];
                if (box_elem == elem) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isSafe(int[][] grid, int r, int c, int elem) {
        return !usedInRow(grid, r, elem) &&
                !usedInCol(grid, c, elem) &&
                !usedInBox(grid, r, c, elem);

    }

    boolean sudoku(int[][] grid) {
        int[] ra;
        ra = unassigned(grid);
//        System.out.println("Unassigned position :("+ ra[0] +", "+ ra[1] +")");
        if (ra[0] == -1)
            return true;

        int row = ra[0], col = ra[1];
        boolean check;

        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;

                check = sudoku(grid);
                if (check)
                    return true;

                grid[row][col] = 0;  // if check == false, reset the move

            }
        }

        return false;  // sudoku cannot be solved
    }

    public static void main(String[] args) {
        int[][] arr = {{5, 8, 0, 2, 0, 0, 4, 7, 0},
                {0, 2, 0, 0, 0, 0, 0, 3, 0},
                {0, 3, 0, 0, 5, 4, 0, 0, 0},
                {0, 0, 0, 5, 6, 0, 0, 0, 0},
                {0, 0, 7, 0, 3, 0, 9, 0, 0},
                {0, 0, 0, 0, 9, 1, 0, 0, 0},
                {0, 0, 0, 8, 2, 0, 0, 6, 0},
                {0, 7, 0, 0, 0, 0, 0, 8, 0},
                {0, 9, 4, 0, 0, 6, 0, 1, 5}};

        Main obj = new Main();

        System.out.println("Sudoku board initially:");
        print_initial(arr, arr.length);
        System.out.println("\n\n");
        boolean possible = obj.sudoku(arr);
        if (possible) {
            System.out.println("After solving:");
            print(arr, arr.length);
        }
    }
}
