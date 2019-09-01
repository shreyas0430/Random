import java.util.*;

class BattleShipsGame
{
  public static void main(String args[])
  {
    char[][] arr = new char[10][10];
    for(int i=0;i<10;i++)
    {
      for(int j=0;j<10;j++)
      {
        arr[i][j]=' ';
      }
    }
    System.out.println("**** Welcome to Battle Ships Game ****\n");
    System.out.println("Right now, the sea is empty.\n");
    System.out.println("   " + "0123456789" + "   ");
    for(int i=0;i<10;i++)
    {
      System.out.print(i + " |");
      for(int j=0;j<10;j++)
      {
        System.out.print(arr[i][j]);
      }
      System.out.println("| " + i);
    }
    System.out.println("   " + "0123456789" + "   ");

    System.out.println("Deploy your ships:");
    for(int i=1;i<=5;i++)
    {
      while(true)
      {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter X coordinate for your " + i + ". ship: ");
        int x = s.nextInt();
        System.out.print("Enter Y coordinate for your " + i + ". ship: ");
        int y = s.nextInt();

        if(arr[y][x]==' ')
        {
          arr[y][x]='@';;
          break;
        }
        else
        {
          System.out.println("Position occupied! Please try again....");
        }
      }
    }
    System.out.println("   " + "0123456789" + "   ");
    for(int i=0;i<10;i++)
    {
      System.out.print(i + " |");
      for(int j=0;j<10;j++)
      {
        System.out.print(arr[i][j]);
      }
      System.out.println("| " + i);
    }
    System.out.println("   " + "0123456789" + "   ");

    System.out.println("Computer is deploying ships");
    for(int i=1;i<=5;i++)
    {
      while (true)
      {
        Random r = new Random();
        int rx = r.nextInt(10);
        int ry = r.nextInt(10);
        if(arr[ry][rx]==' ')
        {
          arr[ry][rx] = '#';
          System.out.println(i + ". ship DEPLOYED");
          break;
        }
      }
    }
    System.out.println("---------------------------------------------");
    boolean flag = true;
    int alpha=5, hash=5;
    while(true)
    {
      if(flag)
      {
        System.out.println("YOUR TURN");
        while(true)
        {
          Scanner s = new Scanner(System.in);
          System.out.print("Enter X coordinate: ");
          int xcor = s.nextInt();
          System.out.print("Enter Y coordinate: ");
          int ycor = s.nextInt();
          if(arr[ycor][xcor]==' ')
          {
            System.out.println("You missed");
            arr[ycor][xcor]='-';
            flag = false;
            break;
          }
          else if(arr[ycor][xcor]=='@')
          {
            System.out.println("Oh no, you sunk your own ship :(");
            arr[ycor][xcor]='x';
            flag = false;
            alpha-=1;
            break;
          }
          else if(arr[ycor][xcor]=='#')
          {
            System.out.println("Boom! You sunk the ship!");
            arr[ycor][xcor]='!';
            flag = false;
            hash-=1;
            break;
          }
          else if(arr[ycor][xcor]=='-' || arr[ycor][xcor]=='!' || arr[ycor][xcor]=='x')
          {
            System.out.println("Sorry! Position already guessed!");
          }
        }

      }
      else
      {
        System.out.println("COMPUTER'S TURN");
        while(true)
        {
          Random r = new Random();
          int xcor = r.nextInt(10);
          int ycor = r.nextInt(10);
          if(arr[ycor][xcor]==' ')
          {
            System.out.println("Computer missed");
            arr[ycor][xcor]='-';
            flag = true;
            break;
          }
          else if(arr[ycor][xcor]=='@')
          {
            System.out.println("The Computer sunk one of your ships!");
            arr[ycor][xcor]='x';
            flag = true;
            alpha-=1;
            break;
          }
          else if(arr[ycor][xcor]=='#')
          {
            System.out.println("The Computer sunk one of its own ships");
            arr[ycor][xcor]='!';
            flag = true;
            hash-=1;
            break;
          }
          else if(arr[ycor][xcor]=='-' || arr[ycor][xcor]=='!' || arr[ycor][xcor]=='x');
        }
      }
      if(alpha==0 || hash==0)
      {
        System.out.println("   " + "0123456789" + "   ");
        for(int i=0;i<10;i++)
        {
          System.out.print(i + " |");
          for(int j=0;j<10;j++)
          {
            System.out.print(arr[i][j]);
          }
          System.out.println("| " + i);
        }
        System.out.println("   " + "0123456789" + "   ");

        System.out.println("Your ships: " + alpha + " | " + "Computer ships: " + hash);
        if(alpha==0)
        {
          System.out.println("Sorry! You lose! Better luck next time!");
        }
        else
        {
          System.out.println("Hooray! You win the battle :)");
        }
        break;
      }
    }
  }
}
