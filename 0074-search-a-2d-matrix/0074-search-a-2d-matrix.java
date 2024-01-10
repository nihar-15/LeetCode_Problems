class Solution {
    public boolean searchMatrix(int[][] mat, int key) {
     
        
        int col=mat[0].length-1;
        for(int i=0;i<mat.length;i++){
            
            if(key>=mat[i][0] && key<=mat[i][col]){
                if (binarySearch(mat[i],key)==true){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    
    
    boolean binarySearch(int arr[],int key){
    
        int low=0,high=arr.length-1;
        
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==key){
                return true;
            }else if(key> arr[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}