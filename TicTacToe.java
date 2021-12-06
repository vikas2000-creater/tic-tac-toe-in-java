import java.util.Scanner;
class TicTacToe{
  private player player1,player2;
  Board board; 
  public player takeinput(int n)
  { 
    Scanner sc= new Scanner(System.in); 
     System.out.println("Enter player Name  "+ n +" :");
      String s= sc.nextLine(); 
     System.out.println(s);
      char c= sc.next().charAt(0);   
       
      player p2= new player(s,c); 
      return p2;
  }
    public void startgame()
  {Scanner sc= new Scanner(System.in);  
    
    this.player1=takeinput(1);
    this.player2= takeinput(2);    
      while(player1.getSymbol()== player2.getSymbol()){  
          System.out.println("Symbol already taken");
        char s=  sc.next().charAt(0);
        player2.setSymbol(s);
          
      }
    board = new Board(player1.getSymbol(),player2.getSymbol()); 
    boolean player1turn=true; 
    int status= Board.incomplete;
    
    while(status==Board.incomplete ||  status== Board.invalid)
    {
      if(player1turn)
      {
          System.out.println("player1 "+ player1.getName()+ " 's turn");
          System.out.println("Enter X:");
          int x= sc.nextInt(); 
           System.out.println("Enter Y:");
          int y= sc.nextInt(); 
           status = board.move(player1.getSymbol(), x,y); 
          if(status!=Board.invalid)
          {   
              
              player1turn= false; 
              board.print();
          } 
          else
           System.out.println("Invalid Move");
      }
      else{
       System.out.println("player2 "+ player2.getName()+ " 's turn");
          System.out.println("Enter X:");
          int x= sc.nextInt(); 
           System.out.println("Enter Y:");
          int y= sc.nextInt(); 
          status = board.move(player2.getSymbol(), x,y); 
          if(status!= Board.invalid)
          {
              
              player1turn= true; 
              board.print();
          }  
          else{
              System.out.println("Invalid Move");
          }
      } 
    }
      if(status==Board.p1win)
      {
          System.out.println("player1 "+player1.getName()+ " wins");
      } 
       if(status==Board.p2win)
      {
          System.out.println("player1 "+player2.getName()+ " wins");
      }  
    
      else{
          System.out.println("Draw");
      }
     
    
    
      
  }
    
    
    
    
}