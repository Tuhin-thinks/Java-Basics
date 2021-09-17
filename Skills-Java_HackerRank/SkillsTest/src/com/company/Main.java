package com.company;

public class Main {
    /**
     * Returns an array of positions yet to fill-up
     * @param mat sudoku board
     * @return array of empty positions
     */
    int[] get_next_empty_position(int[][] mat){
        int row, col;
        for (row =0; row <9; row++){
            for (col =0; col <9; col++){
                if(mat[row][col] == 0)
                    return new int[]{1, row, col};
            }
        }
        return new int[]{0, -1, -1};
    }

    /**
     * To find the box for any given position
     *  @param a row index
     * @param b column index
     * @return {x, y} top left position of the box
     */
    int[] box_top_left(int a, int b){
        int box_row = a /3 * 3;
        int box_col = b /3 * 3;
        return new int[]{box_row, box_col};
    }

    boolean duplicate_in_Row(int[][] mat, int row_num, int value){
        for (int elem : mat[row_num]){
            if (value == elem)
                return true;
        }
        return false;
    }
    boolean duplicate_in_Col(int[][] mat, int col_num, int value){
        int elem;
        for (int i=0; i < 9; i++){
            elem = mat[i][col_num];
            if( elem == value )
                return true;
        }
        return false;
    }

    /**
     * function to check if the value can be placed inside the box or not
     * @param mat sudoku board
     * @param a row index
     * @param b column index
     * @param value value to be placed
     * @return boolean
     */
    boolean valid_in_Box(int[][] mat, int a, int b, int value){
        int[] box_index;
        box_index = box_top_left(a, b);
        int start_x = box_index[0], start_y = box_index[1];

        for (int i=start_x; i<start_x+3; i++){
            for (int j=start_y; j<start_y+3; j++){
                if ( value == mat[i][j] )
                    return false;
            }
        }
        return true;
    }

    boolean  is_valid_pos(int a, int b, int value, int[][] mat){
        return valid_in_Box(mat, a, b, value) && !duplicate_in_Col(mat, b, value) && !duplicate_in_Row(mat, a, value);
    }

    boolean Solve(int[][] mat){
        int[] empty_pos;
        int row, col;
        empty_pos = get_next_empty_position(mat);  // returns {0 or 1, row, col}
        if (empty_pos[0] == 0) // no empty positions
            return true;
        row = empty_pos[1]; col = empty_pos[2];
        for (int num=1; num<=9; num++){
            if (is_valid_pos(row, col, num, mat)){
                mat[row][col] = num;
                if (Solve(mat))
                    return true;
                mat[row][col] = 0;
            }
        }
        return false;
    }
    int[][] assign_values(){
        return new int[][]{
                {0, 0, 3, 4, 0, 6, 9, 0, 0},
                {1, 0, 5, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 7, 0, 5, 6},
                {7, 0, 0, 0, 0, 0, 0, 6, 9},
                {0, 8, 0, 0, 4, 0, 0, 1, 0},
                {4, 5, 0, 0, 0, 0, 0, 0, 8},
                {8, 2, 0, 6, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 8, 0, 3},
                {0, 0, 7, 8, 0, 2, 6, 0, 0}
        };
    }

//    void fill_known_places(int[][] mat){
//        int [][] known_places = {
//                {0,3,4}, {0,4,1}, {0,8,6},
//                {1,0,4}, {1,3,7}, {1,4,6}, {1,7,5}, {1,8,8},
//                {2,1,6}, {2,2,1}, {2,3,9}, {2,5,8}, {2,6,3},
//                {3,4,7}, {3,7,1}, {3,8,3},
//                {4,0,2}, {4,1,5}, {4,8,4},
//                {5,0,6}, {5,1,1}, {5,2,3}, {5,3,5}, {5,4,4}, {5,5,9}, {5,8,2},
//                {6,1,9}, {6,5,4}, {6,6,7}, {6,7,3},
//                {7,0,7}, {7,1,4}, {7,2,5}, {7,5,6}, {7,6,2}, {7,8,1},
//                {8,0,8}, {8,4,5}
//        };
//
//        int x, y, value;
//        for (int[] known_place : known_places) { // enhanced for
//            x = known_place[0];
//            y = known_place[1];
//            value = known_place[2];
//
//            mat[x][y] = value;
//        }
//    }

    void print_mat(int[][] mat){
        for(int i=0; i<9; i++){
            for (int j=0;j<9;j++){
                if (j == 2 || j == 5)
                    System.out.print(mat[i][j] + " | ");  // space + | + space
                else
                    System.out.print(mat[i][j] + "  ");  // element + 2 spaces
            }

            if (i == 2 || i == 5){
                System.out.println();
                for (int x=0; x < 14; x++)
                    System.out.print("--");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Main obj = new Main();

        int [][] sudoku_matrix;

//        obj.fill_known_places(sudoku_matrix);
        sudoku_matrix = obj.assign_values();

        System.out.println("Unsolved SUDOKU matrix:");
        obj.print_mat(sudoku_matrix);

        if (obj.Solve(sudoku_matrix)) {
            System.out.println("\nSolved SUDOKU:");
            obj.print_mat(sudoku_matrix);
        }
        else
            System.out.println("Sudoku invalid, and cannot be solved");
    }
}
