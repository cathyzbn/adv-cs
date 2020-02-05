import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BFS {
    
    private boolean[][] grid;
    private int x_max, y_max;
    
    public BFS(String file_name) {
       try {
            Scanner s = new Scanner(new File("input.txt"));
            x_max = s.nextInt();
            y_max = s.nextInt();
            grid = new boolean[x_max][y_max];
            for (int i = 0; i < x_max; i++) {
                for (int j = 0; j < y_max; j++) grid[i][j] = s.nextInt() == 0;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
        }
    }
    
    public boolean is_full(int x, int y) { return grid[x-1][y-1]; }
    
    public ArrayList<int[]> get_neighbors(int x, int y){
        boolean up = y>0, down = y<y_max-1, left = x>0, right = y<y_max-1;
        ArrayList<int[]> neighbors = new ArrayList<int[]>();
        if (up) neighbors.add(new int[]([x ,y-1]))
        return neighbors;
    }
    
    
    public static void main(String[] args) {
        int[] l = new int[2];
        l[0] = 7;
        l[1] = 5;
        System.out.println(Arrays.toString(l));
        
    }
    
}
