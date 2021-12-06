import java.util.Scanner;
class Board{
    private  char board[][];
    private int boardsize=3;
    private int count=0;
    private  char p1symbol;
    private char p2symbol;  
    public final static int p1win=1;
    public final static int p2win=2;
    public final static int draw=3;
    public final static int incomplete=4; 
    public final static int  invalid=5;
    
    Board(char p1symbol, char p2symbol)
    {
        board= new  char[boardsize][boardsize];
        for(int i=0;i<boardsize;i++)
        {
            for(int j=0;j<boardsize;j++)
            {
                board[i][j]=' ';
            }
        } 
         this.p1symbol= p1symbol;
         this.p2symbol= p2symbol;
    }
     public    int  move(char symbol, int x,int y)
     {  
         if(x<0 || x>=boardsize || y<0 || y>=boardsize || board[x][y]==' ')
         {
             return invalid;
         }
         board[x][y]=symbol;
         count++;
         if(board[x][0]==board[x][1] && board[x][0] == board[x][2])
         {   
           return  symbol== p1symbol ? p1win: p2win;
              
         } 
         if(board[0][y]==board[1][y] && board[0][y] == board[2][y])
         {   
           return  symbol== p1symbol ? p1win: p2win;
              
         } 
                  if(board[0][0]!=' '&& board[0][0]==board[1][1] && board[0][0] == board[2][2])
         {   
           return  symbol== p1symbol ? p1win: p2win;
              
         } 
                  if( board[0][0]!=' '&& board[0][2]==board[1][1] && board[0][2] == board[2][0])
         {   
           return  symbol== p1symbol ? p1win: p2win;
              
         } 
         if(count==boardsize*boardsize)
         {
             return draw;
         } 
         else
         return incomplete;
     }  
     public   void print()
     {
         for(int i=0;i<boardsize;i++)
         {
             for(int j=0;j<boardsize;j++)
             {
                 System.out.println("| " + board[i][j] + " |" );
             } 
             System.out.println();
         } 
         System.out.println();
         System.out.println("-----------------------------");
     }
    
}