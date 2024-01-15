import java.util.Scanner;  
import java.util.Random;
class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);  
    Random rand = new Random();

    int grid [] = {10,10}; // ratios of the map
    int map [][] = new int[grid[1]][grid[0]]; // map
    String charakters [] = {"-","@","0", "#"}; // ascii charakters of map 

    String lastinput = "w"; // last input valid input if input is not valid
    
    int position [] = {grid[1]/2,grid[0]/2}; // snake starts in the middle
    int applePost [] = {3,4}; // spawn position of the apple

    int size =3; // size of snake
    

//  filling the map with empty cells
    for(int i = 0;i<grid[1];i++){ 
        for(int y = 0;y<grid[0];y++){
            map[i][y] = 0;
        }
    }
    
    boolean alive = true; // just in case the "break" would fail
    
    while(alive){
        if(map[position[0]][position[1]]>2){ alive = false;break;}
        map[applePost[0]][applePost[1]] = -1;
        map[position[0]][position[1]] = 1;
        
                    if(position[0] == applePost[0] && position[1] == applePost[1]){
                        boolean appleSpawn = true;
                        do{
                        applePost[0] = rand.nextInt(grid[0]);
                        applePost[1] = rand.nextInt(grid[1]);
                        if(map[applePost[0]][applePost[1]] == 0)appleSpawn = false;
                        }while(appleSpawn);
                        size++;
                    }

        for(int i = 0;i<grid[0];i++){
            for(int y = 0;y<grid[1];y++){
                String cell;
                switch (map[y][i]) {
                    case -1:cell = charakters[2];break;
                    case 0:cell = charakters[0];break;
                    case 1:cell = charakters[1];break;
                    default:cell = charakters[3];
                }
                System.out.print(cell);
                if(map[y][i]>0)map[y][i]++;
                if(map[y][i]>size)map[y][i]=0;
            }
            System.out.println();
            }
 
            String x = scanner.nextLine();
            switch (x) {
                case "w":case "a":case "s": case "d": lastinput = x;break;
                default:
            }
                switch (lastinput) {
                    case "w":position[1]--;break;
                    case "a":position[0]--;break;
                    case "s":position[1]++;break;
                    case "d":position[0]++;break;
                    default: 
                }

    }

  }
}
