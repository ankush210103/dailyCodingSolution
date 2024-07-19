class Solution {
    public static int minElement(int[] matrix){
        int s = 99999;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i]< s){
                s = matrix[i];
            }
        }
        return s;
    }
    public static int maxElement(int[][] matrix,int col){
        int m = -9999;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col]> m){
                m = matrix[i][col];
            }
        }
        return m;
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
         ArrayList<Integer> a  = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                int min = minElement(matrix[i]);
                int max = maxElement(matrix,j);
                System.out.println("row = "+ i+"col = "+j+ " max = "+max+"min = "+min);
                if(max == matrix[i][j] && min == matrix[i][j]){
                    a.add(matrix[i][j]);
                }
            }
        }
        // int max = maxElement(matrix,0);
        // System.out.println(matrix.length+"    "+max);
      

       
        return a;
    }
}