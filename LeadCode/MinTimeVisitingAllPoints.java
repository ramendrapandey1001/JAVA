package LeadCode;

public class MinTimeVisitingAllPoints {
	
	public static void main(String[] args) {

		int[] [] points = {{100, 100}, {-500, 200}, {-500, -500}, {1000, 1000}, {0, 0}, {-1000, 1000}, {1000, -1000}};
		System.out.println(minTimeToVisitAllPoints(points));
	}

	public static int minTimeToVisitAllPoints(int[][] points) {
    int totalTimeTaken = 0;
    for (int i = 1; i < points.length; i++) {
        int dx = Math.abs(points[i][0] - points[i - 1][0]);
        int dy = Math.abs(points[i][1] - points[i - 1][1]);
        totalTimeTaken += Math.max(dx, dy);
    }
    return totalTimeTaken;
}
}
