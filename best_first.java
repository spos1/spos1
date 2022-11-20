import java.util.*;
class BestFit
{
 
 public void bestFit (int blockSize[], int m, int processSize[], int n)
 {
 
 int allocation[] = new int[n];
 System.out.println("\nBlock Size");
 for(int i=0; i<blockSize.length; i++){
     System.out.println(blockSize[i]);
 }
 
 for (int i = 0; i < allocation.length; i++)
 allocation[i] = -1;
 
 for (int i=0; i<n; i++)
 {
 
 int bestIdx = -1;
 for (int j=0; j<m; j++)
 {
 if (blockSize[j] >= processSize[i])
 {
 if (bestIdx == -1)
 bestIdx = j;
 else if (blockSize[bestIdx] > blockSize[j])
 bestIdx = j;
 }
 }
 
 
 if (bestIdx != -1)
 {
 
 allocation[i] = bestIdx;
 
 
 blockSize[bestIdx] -= processSize[i];
 }
 }
 
 System.out.println("\nProcess No.\tProcess Size\tBlock no.");
 for (int i = 0; i < n; i++)
 {
 System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t");
 if (allocation[i] != -1)
 System.out.print(allocation[i] + 1);
 else
 System.out.print("Not Allocated");
 System.out.println();
 }
 }
 
}
class FirstFit
{
 
 public void firstFit(int blockSize[], int m,int processSize[], int n)
 {
 
 int allocation[] = new int[n];
 System.out.println("\nBlock Size");
 for(int i=0; i<blockSize.length; i++){
     System.out.println(blockSize[i]);
 }
 
 for (int i = 0; i < allocation.length; i++)
 allocation[i] = -1;
 
 
 for (int i = 0; i < n; i++)
 {
 for (int j = 0; j < m; j++)
 {
 if (blockSize[j] >= processSize[i])
 {
 
 allocation[i] = j;
 
 
 blockSize[j] -= processSize[i];
 break;
 }
 }
 }
 

 System.out.println("\nProcess No.\tProcess Size\tBlock no.");
 for (int i = 0; i < n; i++)
 {
 System.out.print(" " + (i+1) + "\t\t" +
 processSize[i] + "\t\t");
 if (allocation[i] != -1)
 System.out.print(allocation[i] + 1);
 else
 System.out.print("Not Allocated");
 System.out.println();
 }
 }
 
}

public class best_first {
public static void main(String[] args) {
int blockSize[] = {100, 500, 200, 300, 600};
 int processSize[] = {212, 417, 112, 426};
 int m = blockSize.length;
 int n = processSize.length;
int ch = 1;
Scanner sc = new Scanner(System.in);
System.out.println("1.FirstFit\n2.BestFit\n3.Exit");
System.out.println("Enter your choice: ");
ch = sc.nextInt();
switch(ch){
 case 1 :
 System.out.println("FirstFit");
 FirstFit obj1 = new FirstFit();
 obj1.firstFit(blockSize, m, processSize, n);
 break;
 case 2 :
 System.out.println("BestFit");
 BestFit obj2 = new BestFit();
 obj2.bestFit(blockSize, m, processSize, n);
 break;
 case 3:
 System.out.println("Exit");
 default:
 break; 
 
 
}
 sc.close();
}
}