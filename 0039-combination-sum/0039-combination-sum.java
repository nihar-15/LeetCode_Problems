class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findCombinations(0, ans, candidates, target, new ArrayList<Integer>());

        return ans;

    }

    public static void findCombinations(int i, List<List<Integer>> ans, int cand[], int target, ArrayList<Integer> ds) {

        if (cand.length == i) {

            if (target == 0) {

                ans.add(new ArrayList<>(ds));

                return;

            } else {

                return;

            }

        }

        if (cand[i] <= target) {

            ds.add(cand[i]);

            findCombinations(i, ans, cand, target - cand[i], ds);

            ds.remove(ds.size() - 1);

        }

        findCombinations(i + 1, ans, cand, target, ds);

        return;
    }
}