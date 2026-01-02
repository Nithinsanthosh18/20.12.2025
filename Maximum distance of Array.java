class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);
            int currentMin = arr.get(0);
            int currentMax = arr.get(arr.size() - 1);

            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minVal));
            maxDistance = Math.max(maxDistance, Math.abs(maxVal - currentMin));

            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<Integer>> arrays1 = List.of(
            List.of(1,2,3),
            List.of(4,5),
            List.of(1,2,3)
        );
        System.out.println(sol.maxDistance(arrays1));

        List<List<Integer>> arrays2 = List.of(
            List.of(1),
            List.of(1)
        );
        System.out.println(sol.maxDistance(arrays2)); 
    }
}
  
    
