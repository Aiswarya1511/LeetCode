class Solution {
    public boolean isValidSudoku(char[][] board) {

        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] subboxes = new int[9][9];

        for(int r = 0; r < 9 ; r++){
            for(int c = 0; c < 9 ; c++){

                if(board[r][c] == '.'){
                    continue;
                }

                int value = board[r][c] - '1';

                if(rows[r][value] == 1){
                    return false;
                }

                rows[r][value] = 1;

                if(columns[c][value] == 1){
                    return false;
                }

                columns[c][value] = 1;

                int subboxIndex = 3 * (r / 3) + (c / 3);

                if(subboxes[subboxIndex][value] == 1){
                    return false;
                }

                subboxes[subboxIndex][value] = 1;
            }
        }

        return true;
    }
}