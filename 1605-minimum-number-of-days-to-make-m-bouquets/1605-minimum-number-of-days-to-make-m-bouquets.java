class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 1, right = 1000000000;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int consecutiveFlowers = 0, bouquetCount = 0;

        for (int bloom : bloomDay) {
            if (bloom <= days) {
                consecutiveFlowers++;
                if (consecutiveFlowers == k) {
                    bouquetCount++;
                    consecutiveFlowers = 0;
                }
            } else {
                consecutiveFlowers = 0;
            }
        }

        return bouquetCount >= m;
    }
}