import java.util.ArrayList;

public class maze {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
        path(" ", 3, 3);
        System.out.println(Mazepath(" ", 3, 3));
        boolean[][] board ={
            {true,true,true},
            {true,false,true},
            {true,true,true}
        };
        // pathRes(" ", board, 0, 0);
        Allpath(" ", board, 0, 0);
        int[][] visited = new int[3][3];
        AllpathPrint(" ", board, 0, 0, visited, 0);
    }
    static int count(int r,int c){
        if (r==1 || c==1) {
            return 1;            
        }
        int left = count(r-1, c);
        int right = count(r, c-1);
        return left + right;
    }
    static void path (String p,int r,int c){
        if (r==1 || c==1){
            System.out.println(p);
            return;
        }
        if (r>1){
            path(p+'D', r-1, c);
        } 
        if (c>1){
            path(p+'R', r, c-1);
        } 
    }
    static ArrayList<String> Mazepath(String p,int r,int c){
        if (r==1 || c==1){
            ArrayList<String> list = new ArrayList<>(); 
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (r>1){
            list.addAll(Mazepath(p + 'D', r-1, c));
        }
        if (c>1){
            list.addAll(Mazepath(p + 'R', r, c-1));
        }
        return list;
    }
    static void pathRes(String p,boolean[][] maze,int r,int c){
        if (r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
        }
        if (!maze[r][c]) {
            return;
        }
        if (r<maze.length-1) {
            pathRes(p+'D', maze, r+1, c);
        }
        if (c<maze[0].length-1) {
            pathRes(p+'R', maze, r, c+1);
        }

    }
    static void  Allpath(String p,boolean[][] maze,int r,int c){
        if (r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);            
        }
        if (!maze[r][c]){
            return;
        }
        maze[r][c]= false;

        if (r<maze.length-1){
            Allpath(p+'D', maze, r+1, c);
        }
        if (c<maze[0].length-1){
            Allpath(p+'R', maze, r, c+1);
        }
        if (r>0){
            Allpath(p+'U', maze, r-1, c);            
        }
        if (c>0){
            Allpath(p+'L', maze, r, c-1);            
        }
        maze[r][c]=true;
    }
    static void  AllpathPrint(String p,boolean[][] maze,int r,int c,int[][] visited,int count){
        if (r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);            
            System.out.println(count);
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[0].length; j++) {
                    System.out.print(visited[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;            
        }
        if (!maze[r][c]){
            return;
        }
        maze[r][c]= false;
        visited[r][c] = count;
        if (r<maze.length-1){
            AllpathPrint(p+'D', maze, r+1, c, visited, count+1);
        }
        if (c<maze[0].length-1){
            AllpathPrint(p+'R', maze, r, c+1,visited, count+1);
        }
        if (r>0){
            AllpathPrint(p+'U', maze, r-1, c,visited, count+1);            
        }
        if (c>0){
            AllpathPrint(p+'L', maze, r, c-1,visited, count+1);            
        }
        maze[r][c]=true;
        visited[r][c]=0;
        
    }
}

    