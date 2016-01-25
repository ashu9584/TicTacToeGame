import java.util.LinkedList;
import java.util.Random;

/*
 * Created by ashutoshchaubey on 25/01/16.
 */
public class Machine {
    public static int ai(char[] board){
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0;i<9;i++)
        {
            if(board[i]=='-')
            {
                list.add(i+1);
            }
        }
        Random rand = new Random();
        return list.get((Math.abs(rand.nextInt())%list.size()));
    }
}
