import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(0, target, candidates, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start, int target, int[] candidates,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Required sum is achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Remaining elements are also too large because array is sorted
            if (candidates[i] > target) {
                break;
            }

            // Choose
            current.add(candidates[i]);

            // Explore: i + 1 because each index can be used only once
            backtrack(
                i + 1,
                target - candidates[i],
                candidates,
                current,
                result
            );

            // Undo the choice
            current.remove(current.size() - 1);
        }
    }
}