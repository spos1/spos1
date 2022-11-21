import static java.lang.System.exit;
import java.io.IOException;
import java.util.Scanner;
class Ring
{
    static int n,front=0,rear=0,ch,maxi=0,cord;
    static int[][] cq;
    public static void ring() 
    {
        int a=1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the no of processes : ");
        cord=n=scanner.nextInt();
        cq=new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        {
          if (rear==0 && front==0)
              front=rear=1;
          else if(rear==n && front!=1)
              rear=1;
          else
                rear=rear+1;
          System.out.println("Enter the  process no : ");
          cq[rear][0]=scanner.nextInt();
          System.out.println("Enter the state of process : ");
          cq[rear][1]=scanner.nextInt();
        }
        display();
        while(a==1)
        {
              System.out.print("\n1.Crash \n2.Activate\n3.Display\n4.Quit");
              System.out.print("\nEnter the choice : ");
              ch=scanner.nextInt();
              switch(ch)
               {
                    case 1 : 
                            System.out.println("Enter the process no you want to crash : ");
                            //int x=scanner.nextInt();
                            crash(scanner.nextInt());   
                            break;

                    case 2 :
                            System.out.println("Enter the process no you want to activate : ");
                            activate(scanner.nextInt());
                            break;
                    case 3 :
                            if(cq[cord][1]==1)
                            {
                                System.out.println("\n No need to start election.");
                            }
                            else
                            {
                                System.out.println("Enter the process no initiate election : ");
                                int x2=scanner.nextInt();
                                while(cq[x2][1]==0)
                                {
                                    System.out.println("Process "+x2 +" is crash and cannot start election");
                                    System.out.println("Enter another Process :");
                                    x2=scanner.nextInt();
                                }
                                dis(x2);
                            }
                            break;
                    case 4: 
                            exit(0);
                            break;
                              }
              System.out.print("\nDo you want to continue : ");
              a=scanner.nextInt();
         }
    }
    public static void crash(int x)
    {
        for(int i=0;i<=n;i++)
        {
            if(cq[i][0]==x)
            {
                if(cq[i][1]==0)
                {
                    System.out.println("Already crashed");
                    break;
                }
                else
                {
                    cq[i][1]=0;
                    display();
                    break;
                }
    }
        }
    }
    public static void activate(int x)
    {
        for(int i=0;i<=n;i++)
        {
            if(cq[i][0]==x)
            {
                if(cq[i][1]==1)
                {
                    System.out.println("Already activated");
                    break;
                     }
                else
                {
                    cq[i][1]=1;
                    display();
                    break;
                }
            }
        }
    }
    public static void display()
    {
           System.out.print("\nProcess    : ");
           for(int i=1;i<=n;i++)
           {
               System.out.print("\tP"+i);
           }
           System.out.print("\nStatus     : ");
           for(int i=1;i<=n;i++)
           {
               System.out.print("\t"+cq[i][1]);
           }
           System.out.print("\nIdentifier : ");
           for(int i=1;i<=n;i++)
           {
               System.out.print("\t"+cq[i][0]);
           }
    }
    public static void dis(int x)
       {
        rear=x-1;
        front=x;
        for(int i=front;i<=n;i++)
        {
            if(cq[i][1]!=0)
            {
                System.out.print(cq[i][0]);
                if(i!=n-1)
                {
                    System.out.print("->");  
                }
                maxi=Math.max(maxi, cq[i][0]);
            }
        }
        if(rear!=0)
            System.out.print("->"); 
        for(int i=1;i<=rear;i++)
        {
            if(cq[i][1]!=0)
            {
                System.out.print(cq[i][0]);
                if(i!=rear-1)
                {
                    System.out.print("->");  
                }
                maxi=Math.max(maxi, cq[i][0]);
            }
        }
        System.out.println("\nNew Co-ordinator is : "+maxi);
    }
}
class Bully{
    static int n;
    static int pro[] = new int[100];
    static int sta[] = new int[100];
    static int co;
   
    public static void bully() throws IOException
      {
        System.out.println("Enter the number of process");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int i,j,k,l,m;
        for(i=0;i<n;i++)
        {
            System.out.println("For process "+(i+1)+":");
            System.out.println("Status:");
            sta[i]=in.nextInt();
            System.out.println("Priority");
            pro[i] = in.nextInt();
        }
         
        System.out.println("Which process will initiate election?");
        int ele = in.nextInt();
        elect(ele);
        System.out.println("Final coordinator is "+co);
    }
    static void elect(int ele)
    {
        ele = ele-1;
        co = ele+1;
        for(int i=0;i<n;i++)
        {
            if(pro[ele]<pro[i])
            {
                System.out.println("Election message is sent from "+(ele+1)+" to "+(i+1));
                if(sta[i]==1)
                    elect(i+1);
            }
        }
         }
}
public class RingandBully
{
    public static void main(String[] args) throws IOException
    {
        Ring r=new Ring();
        Bully b=new Bully();
        Scanner sc=new Scanner(System.in);
        int ch;
        do
        {
            System.out.println("1.Ring Algorithm\n2.Bully Algorithm");
            System.out.print("Enter choice : ");
            ch=sc.nextInt();
            switch (ch) {
                case 1:
                    r.ring();
                    break;
                case 2:
                    b.bully();
                    break;
                case 3:
                    exit(0);
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }while(ch<=3);
    }
}