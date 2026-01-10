class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int i = m-1, j = 0;
        while(i>=0 && j<n){
            if(nums1[i] > nums2[j]){
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i--;
                j++;
            }else break;
        }
        i = m;
        j = 0;
        while(j<n){
            nums1[i] = nums2[j];
            i++;
            j++;
        }
        Arrays.sort(nums1);
    }
}