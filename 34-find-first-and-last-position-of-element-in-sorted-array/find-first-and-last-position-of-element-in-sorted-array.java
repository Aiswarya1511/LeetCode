class Solution {
    public int search(int[] nums, int tar, boolean firstIndex, int l, int r){
        int mid = l+(r-l)/2;
        if(l>r) return -1;
        if(nums[mid]<tar){
            return search(nums, tar, firstIndex, mid+1, r);
        }else if(nums[mid]>tar){
            return search(nums, tar, firstIndex, l, mid-1);
        }else{
            if (firstIndex) {
                int ans = search(nums, tar, firstIndex, l, mid - 1);
                if (ans == -1) {
                    return mid;
                }
                return ans;
            } else {
                int ans = search(nums, tar, firstIndex, mid + 1, r);
                if (ans == -1) {
                    return mid;
                }
            return ans;
        }
    }
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int f = search(nums, target, true, 0, n - 1);
        int l = search(nums, target, false, 0, n - 1);
        return new int[] { f, l };
    }
}