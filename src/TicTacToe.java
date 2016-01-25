/**
 * Created by ashutoshchaubey on 25/01/16.
Board Design is as Follows -

  1 \ 2 \ 3
 ***********
  4 \ 5 \ 6
 ***********
  7 \ 8 \ 9

 1 to 9 are the positions to select which position you want to play for !


 */
public class TicTacToe {
    protected char user,computer,current,winner;
    char [] board = new char[9];
    TicTacToe(){
        for(int i=0;i<9;i++)
            board[i]='-';
        this.winner='-';
        printinitialboard();
    }
    public void setUserId(char c)
    {
        this.user=c;
    }
    public void setComputerId(char c) {
        this.computer = c;
    }
    public void printinitialboard(){
        System.out.println();
        for(int i=0;i<9;i++){
            if((i+1)%3==0 )
            {
                System.out.print(" "+(i+1));
                if(i!=8)
                System.out.println("\n***********");
            }
            else{
                System.out.print(" "+(i+1)+" |");
            }

        }
        System.out.println();
        System.out.println();
    }
    public void printboard(){

        for(int i=0;i<9;i++){
            if((i+1)%3==0 && i!=8)
            {
                System.out.print(" "+board[i]);
                System.out.println("\n***********");
            }
            else{
                System.out.print(" "+board[i]+" |");
            }

        }
        System.out.println();
        System.out.println();
    }
    public void playTurn(int pos){
        if(this.current==this.user){
            System.out.println(" Please enter your position : ");
            if(isValid(pos)) {
                board[pos - 1] = user;
                this.current = this.computer;
            }
            else{
                System.out.println("The position is not valid or occupied !");
            }

        }
        else{
            int a= Machine.ai(board);
            board[a-1]=computer;
            System.out.println(" The computer has selected position no  "+a);
            current=user;
        }
    }
    public boolean isThereAWinner(){
        if ((firstRow() || lastColumn() )&& board[2]!='-') {
            this.winner=board[2];
            return true;
        }
        else if((middleRow() || middleColumn() || leftDiagonal() || rightDiagonal() )&& board[4]!='-') {
            this.winner=board[4];
            return true;
        }
        else if(( lastRow() || firstColumn()) && board[6]!='-' ){
            this.winner=board[6];
            return true;
        }
        return false;
    }
    public boolean isBoardFilled(){
        for(int i=0;i<9;i++)
        {   if(board[i]=='-')
                return false;
        }
        return true;
    }
    public boolean firstRow() {
        return board[0]==board[1] && board[1]==board[2];
    }

    public boolean middleRow(){
        return board[3] == board[4]  && board[5] == board[4];
    }

    public boolean lastRow(){
        return board[6] == board[7]  && board[8]== board[7] ;
    }

    public boolean firstColumn(){
        return board[0] == board[3]  && board[3] ==board[6];
    }

    public boolean middleColumn(){
        return board[1] == board[4] && board[4]==board[7];
     }

    public boolean lastColumn(){
        return board[2]==board[5] && board[5]==board[8];
    }

    public boolean leftDiagonal(){
        return board[0]==board[4] && board[4] == board[8];
    }

    public boolean rightDiagonal(){
        return board[2]==board[4] && board[4] == board[6];
    }


    public boolean isValid(int pos){
        return (pos>0 && pos<10) && board[pos-1]=='-';
    }




}
