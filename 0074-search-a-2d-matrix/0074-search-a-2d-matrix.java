// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
// int n = matrix.length;
// int m = matrix[0].length;
// for(int i=0;i<n;i++){
//     for(int j=0;j<m;j++){
//         if(matrix[i][j]==target ){
//             return true;
//         }
//     }
// }
// return false;
//     }
// }

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         int low = 0;
//         int high = m*n -1;
        

//         while (low<=high) {
//             int mid = (high+low)/2;
//             int midValue = matrix[mid / m][mid % m];
//             '''
//             Imp: how to convert 2d indexing to 1d indexing 
//             the first column will always have multiples of m as every row has m numbers 
//             that is why we divide mid/m
//             mid%m is for how many are remaning 
//             '''
//             if (midValue == target) {
//                 return true;
//             } 
//             else if (midValue < target) {
//                 low = mid + 1;
//             } 
//             else {
//                 high = mid-1;
//             }
//         }
//         return false;
//     }
// }



// class Solution{
//     public boolean searchMatrix(int[][] matrix,int target){
//     }
//     private boolean mySearch(int[][] matrix,int target,int high,int low ){
//         int m= matrix[0].length;
//         int midValue = matrix[mid/m][mid%m];
//         if(midValue == target ){
//             return true;
//         }
//         else if(midValue <target){
//             return mySearch(matrix,target,high,mid+1);
//         }
//         else if(midValue>target){
//             return mySearch(matrix,target,mid-1,low);
//         }
//         else{
//             return false;
//         }
//     }
// }

class Solution{
    public boolean searchMatrix(int[][] matrix,int target){
        int low=0;
        int high = matrix.length * matrix[0].length - 1;

        return mySearch(matrix, target, high, low);
    }
    private boolean mySearch(int[][] matrix,int target,int high ,int low){
        if(low>high){
            return false;
        }
        int m = matrix[0].length;
        int mid = (high+low)/2;
        int midValue = matrix[mid/m][mid %m];

        if(midValue == target){
            return true;
        }
        else if(midValue<target){
            return mySearch(matrix,target,high,mid+1);
        }
        else{
            return mySearch(matrix,target,mid-1,low);
        }

    }
}



















