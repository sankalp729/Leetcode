class Solution {
    void merge(int[] arr, int l, int mid, int r){
        int low = l, high = mid+1;
        ArrayList<Integer> list = new ArrayList<>();
        while(low<=mid && high<=r){
            if(arr[low] <= arr[high]){
                list.add(arr[low]);
                low++;
            }else{
                list.add(arr[high]);
                high++;
            }
        }
        while(low<=mid){
            list.add(arr[low]);
            low++;
        }
        while(high<=r){
            list.add(arr[high]);
            high++;
        }
        for(int i =0; i<list.size(); i++){
            arr[i+l] = list.get(i);
        }
    }
    int cntPairs(int[] arr, int low, int mid, int high){
        int cnt = 0;
        int right = mid+1;
        for(int i = low; i<=mid; i++){
            while(right<=high && arr[i] > 2L*arr[right]) right++;
            cnt+= right-(mid+1);
        }
        return cnt;
    }
    int mergeSort(int arr[], int l, int r) {
        // code here
        int cnt = 0;
        if(l == r) return cnt;
        int mid = (l+r)/2;
        cnt+= mergeSort(arr, l, mid);
        cnt+= mergeSort(arr, mid+1, r);
        cnt+= cntPairs(arr, l, mid, r);
        merge(arr, l, mid, r);
        return cnt;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}