package hk.ust.cse;

public class NumberofIslands200 {
	public static void main(String []  args){
		char [][] g = {
				{'1', '1'}
		};
		int n = (new NumberofIslands200()).numIslands(g);
		System.out.println(n);
		
	}
    public int numIslands(char[][] grid) {
    	if (grid.length == 0){
    		return 0;
    	}
    	int rows = grid.length;
    	int columns = grid[0].length;
    	int [][] colors = new int[rows][columns];
    	
    	// init the color mask
    	for(int i=0;i<rows;i++){
    		for(int j =0;j<columns;j++){
    			colors[i][j] = 0;
    		}
    	}
    	
    	int color = 0;
    	for(int i=0;i<rows;i++){
    		for(int j =0;j<columns;j++){
    			if(grid[i][j] == '1' && colors[i][j] == 0){
    				color = color + 1;
    				setColor(grid, colors, i,j,color);
    			}
    		}
    	}
    	return color;
    }
    
    public void setColor(char [][]grid, int [][] colors, int i, int j, int color){
    	// color the grid with color
    	// color[0] stores the current color
    	// System.out.println(i + "," +j);
    	if(colors[i][j] != 0 || grid[i][j] == '0'){
    		return;
    	}
    	
    	colors[i][j] = color; 
    	if(i>0){
    		setColor(grid, colors, i-1, j, color);
    	}
    	if(i < grid.length - 1){
    		setColor(grid, colors,i+1,j,color);
    	}
    	if(j>0){
    		setColor(grid, colors, i,j-1,color);
    	}
    	if(j<grid[0].length-1){
    		setColor(grid, colors, i, j+1,color);
    	}
    }
}
