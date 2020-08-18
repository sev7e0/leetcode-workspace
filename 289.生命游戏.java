/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    int[][] df = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
    public void gameOfLife(int[][] board) {
    
        int yl = board.length;
        int xl = board[0].length;
        for (int i = 0; i < yl; i++) {
            for (int j = 0; j < xl; j++) {
                int count = countAlive(board, i, j);
                if (board[i][j] == 1 && (count == 2 || count == 3)) {
                    board[i][j] = 3;//继续活着
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;//准备复活
                }
            }

        }
        //整体更新状态
        for (int i = 0; i < yl; i++) {
            for (int j = 0; j < xl; j++) {
                board[i][j] >>= 1;
            }
        }


    }

    private int countAlive(int[][] board, int y, int x) {
        int count = 0;
        int yl = board.length;
        int xl = board[0].length;
        for (int[] d : df) {
            int ny = d[1]+y;
            int nx = d[0]+x;
            if (nx < 0 || nx >= xl || ny < 0 || ny >= yl) continue;
            // 如果这个位置为 0，代表当前轮是死的，不需要算进去
            // 如果这个位置为 1，代表当前轮是活得，需要算进去
            // 如果这个位置为 2，代表当前轮是死的（状态10，下一轮是活的），不需要算进去
            // 如果这个位置为 3，代表是当前轮是活的（状态11，下一轮也是活的），需要算进去
            count += (board[ny][nx] & 1);

        }

        return count;
    }
}
// @lc code=end
