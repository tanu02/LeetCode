package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	int INF = 2147483647;
	int WALL = -1; 
	int GATE = 0;
	int ROW,COL;
	
	List<int[]> DIRECTIONS = Arrays.asList(
									new int[] {0, 1},
									new int[] {1, 0},
									new int[] {0, -1},
									new int[] {-1, 0}
								);
	
	public void wallsAndGates(int[][] rooms) {
		if(rooms ==  null || rooms.length == 0 || 
				rooms[0].length == 0)
			return ; 
		Queue<int[]> queue = new LinkedList<>();
		this.ROW = rooms.length;
		this.COL = rooms[0].length;
		
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if(rooms[i][j] == GATE)
					queue.add(new int[]{i , j});
			}

		}
		int[] entry;
		int x, y;
		while(!queue.isEmpty()) {
			entry = queue.poll();
			
			for(int[] direct : DIRECTIONS) {
				x = entry[0] + direct[0];
				y = entry[1] + direct[1];
				if(checkBoundary(rooms, x, y))
					continue; 
				
				rooms[x][y] = 
						rooms[entry[0]][entry[1]] + 1;
				queue.add(new int[] {x, y});
			}
			
		}

	}
	private boolean checkBoundary(int[][] rooms, int i, int j ) {
		if(i < 0 || i == ROW || j < 0 || j == COL || rooms[i][j] != INF)
			return true; 
		
		return false; 
	}
}