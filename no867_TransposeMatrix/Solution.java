package no867_TransposeMatrix;

class Solution {
    public int[][] transpose(int[][] A) {
        if(A==null) {
        	return null;
        }
        int[] dims= {A[0].length, A.length};
        int[][] result = new int[dims[0]][dims[1]];
        for(int i=0;i<dims[0];i++) {
        	for(int j=0; j<dims[1];j++) {
        		result[i][j] = A[j][i];
        	}
        }
        return result;
    }
}