class Solution {
    public int[] sortArray(int[] nums) {
     
   
        mergeSort(nums,0,nums.length-1);
         return nums;
    }
    
    void mergeSort(int []nums,int low ,int high){
        
         if(low >= high) return;
        int mid= (high +low)/2;
        
       
        mergeSort(nums,low , mid);
        mergeSort(nums,mid+1, high);
        merge(nums,low,mid,high);
         
    }
    
    void merge(int nums[], int low,int mid,int high){
        ArrayList<Integer> temp= new ArrayList<>();
        
        int left =low;
        int right =mid +1;
        
        while(left <= mid && right <= high){
            if(nums[left]<= nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }
        
        
          while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
        
        
        
        
    }
}