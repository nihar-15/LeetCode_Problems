class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
     Map<String, int[]> map = new HashMap<>();
	map.put("UP", new int[]{-1, 0});
	map.put("DOWN", new int[]{1, 0});
	map.put("LEFT", new int[]{0, -1});
	map.put("RIGHT", new int[]{0, 1});

	int r = 0, c = 0, res = 0;
	for(String str : commands) {
		int[] idx = map.get(str);
		r += idx[0];
		c += idx[1];
		res = (r*n)+c;
	}
	return res;
    }
}