package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int numCourses = 4;
		topoList(sol.findOrder(numCourses, prerequisites));

		Solution sol1 = new Solution();
		int[][] prerequisites1 = { { 1, 0 } };
		int numCourses1 = 2;

		topoList(sol1.findOrder(numCourses1, prerequisites1));

		Solution sol2 = new Solution();
		int[][] prerequisites2 = { { 1, 0 }, { 0, 1 } };
		int numCourses2 = 2;

		topoList(sol2.findOrder(numCourses2, prerequisites2));
		
		Solution sol3 = new Solution();
		int[][] prerequisites3 = {};
		int numCourses3 = 2;

		topoList(sol3.findOrder(numCourses3, prerequisites3));
		
		Solution sol4 = new Solution();
		int[][] prerequisites4 = {{1,0}};
		int numCourses4 = 3;

		topoList(sol4.findOrder(numCourses4, prerequisites4));
	}

	private static void topoList(int[] list) {
		System.out.println("-----start----- ");
		for (int val : list) {
			System.out.println(val);
		}
		
		System.out.println("-----end---- ");
	}
}