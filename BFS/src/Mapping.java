import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Mapping {

    private static int edge_num, start, goal;
    private static ArrayList<Integer> x_vals, y_vals;

    private static void start(String file) {

        try {
            Scanner s = new Scanner(new File(file));
            s.nextInt();
            edge_num = s.nextInt();
            start = s.nextInt();
            goal = s.nextInt();
            
            x_vals = new ArrayList<Integer>();
            y_vals = new ArrayList<Integer>();
            
            for (int i = 0; i < edge_num; i++) {
                x_vals.add(s.nextInt());
                y_vals.add(s.nextInt());
            }
       
        } catch (Exception e) {
            System.out.println("file not opened");
        }

    }


    private static ArrayList<Integer> get_child(int parent) {

        ArrayList<Integer> children = new ArrayList<Integer>();
        for (int i = 0; i < x_vals.size(); i++)
            if (x_vals.get(i) == parent) children.add(y_vals.get(i));
        return children;
    }

    private static int get_depth(int start, int goal) {

        ArrayList<int[]> queue = new ArrayList<>();
        queue.add(new int[] { start, 0 });

        while (!queue.isEmpty()) {
//            for(int[] element : queue) System.out.println(Arrays.toString(element));
            int[] current = queue.remove(0);
            int cur_val = current[0], cur_depth = current[1];
            if (cur_val == goal)
                return cur_depth;
            for (int child : get_child(cur_val))
                queue.add(new int[] { child, cur_depth + 1 });
        }

        
        return -1;
    }

    public static void main(String[] args) {
        start("input.txt");
        System.out.println(get_depth(start, goal));

    }

}
