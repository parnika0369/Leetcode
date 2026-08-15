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

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = m*n -1;
        

        while (low<=high) {
            int mid = (high+low)/2;
            int midValue = matrix[mid / m][mid % m];
            //Imp: how to convert 2d indexing to 1d indexing 
            // the first column will always have multiples of m as every row has m numbers that is why we divide mid/m
            //mid%m is for how many are remaning 
            if (midValue == target) {
                return true;
            } 
            else if (midValue < target) {
                low = mid + 1;
            } 
            else {
                high = mid-1;
            }
        }
        return false;
    }
}


