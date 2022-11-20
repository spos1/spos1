import java.util.Scanner;
class FCFS
{
    public void fsfc()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of process: ");
        int n = sc.nextInt();
        int pid[] = new int[n]; // process ids
        int ar[] = new int[n]; // arrival times
        int bt[] = new int[n]; // burst or execution times
        int ct[] = new int[n]; // completion times
        int ta[] = new int[n]; // turn around times
        int wt[] = new int[n]; // waiting times
        int temp;
        float avgwt=0,avgta=0;
        for(int i = 0; i < n; i++)
        {
            System.out.println("enter process " + (i+1) + " arrival time: ");
            ar[i] = sc.nextInt();
            System.out.println("enter process " + (i+1) + " brust time: ");
            bt[i] = sc.nextInt();
            pid[i] = i+1;
        }
        //sorting according to arrival times
        for(int i = 0 ; i <n; i++)
        {
            for(int j=0; j < n-(i+1) ; j++)
            {
                if( ar[j] > ar[j+1] )
                {
                    temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                    temp = bt[j];
                    bt[j] = bt[j+1];
                    bt[j+1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j+1];
                    pid[j+1] = temp;
                }
            }
        }
        // finding completion times
        for(int i = 0 ; i < n; i++)
        {
            if( i == 0)
            {
                ct[i] = ar[i] + bt[i];
            }
            else
            {
                if( ar[i] > ct[i-1])
                {
                    ct[i] = ar[i] + bt[i];
                }
                else
                    ct[i] = ct[i-1] + bt[i];
            }
            ta[i] = ct[i] - ar[i] ; // turnaround time= completion time- arrival time
            wt[i] = ta[i] - bt[i] ; // waiting time= turnaround time- burst time
            avgwt += wt[i] ; // total waiting time
            avgta += ta[i] ; // total turnaround time
        }
        System.out.println("\npid\tarrival\tburst\tfinish\ttat\twaiting");
        for(int i = 0 ; i< n; i++)
        {
            System.out.println(pid[i] + " \t " + ar[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" +
            ta[i] + "\t" + wt[i] ) ;
        }
        sc.close();
        System.out.println("\naverage waiting time: "+ (avgwt/n)); // printing average waiting time.
        System.out.println("average turnaround time:"+(avgta/n)); // printing average turnaround time.
    }
}

class PRIO
{
    public void prio() 
    {
        Scanner s = new Scanner(System.in);
        int ct[],a[],x,n,p[],pp[],bt[],w[],t[],i,k=0;
        float atat,awt;
        p = new int[10];
        pp = new int[10];
        bt = new int[10];
        w = new int[10];
        t = new int[10];
        a= new int[10];
        ct=new int[10];
        System.out.print("Enter the number of process : ");
        n = s.nextInt();
        for(i=0;i<n;i++)
        {
	    System.out.print("Enter arrival time of process "+i+" : ");
            a[i]=s.nextInt();
            System.out.print("Enter burst time of process "+i+" : ");
            bt[i] = s.nextInt();
            System.out.print("Enter priority of process "+i+" : ");
            pp[i] = s.nextInt();
            
            p[i]=i+1;
        }
        s.close();
        for(i=0;i<n-1;i++)
        {

            for(int j=i+1;j<n;j++)
            {
                if(a[i]>=a[j] || pp[i]>pp[j])
                {                           //Sorting according to prio.
                    x=pp[i];
                    pp[i]=pp[j];
                    pp[j]=x;
                    x=bt[i];
                    bt[i]=bt[j];
                    bt[j]=x;
                    x=p[i];
                    p[i]=p[j];
                    p[j]=x;
                    x=a[i];
                    a[i]=a[j];
                    a[j]=x;
                }
            }
        }
        for(i=1;i<=n;i++)
        {
            if(i==1)
            { 
                k=bt[0];
                ct[0]=k;
            }
            else
            {
                k=bt[i-1]+k;
                ct[i-1]=k;
            }
            for(int j=i+1;j<=n;j++)
            {
                if(pp[i]<pp[j] && a[j]<=k)
                {
                    x=pp[i];
                    pp[i]=pp[j];
                    pp[j]=x;
                    x=bt[i];
                    bt[i]=bt[j];
                    bt[j]=x;
                    x=p[i];
                    p[i]=p[j];
                    p[j]=x;
                    x=a[i];
                    a[i]=a[j];
                    a[j]=x;
                }
            }
        }
        w[0]=0;
        awt=0;
        t[0]=bt[0];
        atat=t[0];
        for(i=1;i<n;i++)
        {
            t[i]=ct[i]-a[i];
            w[i]=t[i]-bt[i];
            awt+=w[i];
            atat+=t[i];
        }
        System.out.println("\nProcess\tArrivalTime\tBurstTime\tWaitTime\tTAT\tPriority");
        for(i=0;i<n;i++)
            System.out.println(p[i]+"\t"+a[i]+"\t\t"+bt[i]+"\t\t"+w[i]+"\t\t"+t[i]+"\t"+pp[i]);
        awt/=n;
        atat/=n;
        System.out.println("Average Wait Time : "+awt);
        System.out.println("Average Turn Around Time : "+atat);
        
    }
}

public class fcfs_priority
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("1.FSFS\n2.Priority\n");
        System.out.println("Enter choice : ");
        int ch=sc.nextInt();
        switch(ch) 
        {
            case 1:
                FCFS fobj=new FCFS();
                fobj.fsfc();
                break;
            case 2:
                PRIO pobj=new PRIO();
                pobj.prio();
                break;
            default:
                System.out.println("Wrong Choice");
                break;            
        }
        sc.close();
    }
}