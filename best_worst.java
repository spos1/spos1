import java.util.*;
class BestFit
{
 
 public void bestFit (int blockSize[], int m, int processSize[], int n)
 {
 
 int allocation[] = new int[n];
 
 for (int i = 0; i < allocation.length; i++)
 allocation[i] = -1;
 
 System.out.println("\nBlock Size");
 for(int i=0; i<blockSize.length; i++){
     System.out.println(blockSize[i]);
 }
 
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

class WorstFit
{
 
 public void worstFit(int blockSize[], int m, int processSize[], int n)
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
 
 int wstIdx = -1;
 for (int j=0; j<m; j++)
 {
 if (blockSize[j] >= processSize[i])
 {
 if (wstIdx == -1)
 wstIdx = j;
 else if (blockSize[wstIdx] < blockSize[j])
 wstIdx = j;
 }
 }
 
 
 if (wstIdx != -1)
 {
 
 allocation[i] = wstIdx;
 
 blockSize[wstIdx] -= processSize[i];
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
public class best_worst {
public static void main(String[] args) {
int blockSize[] = {100, 500, 200, 300, 600};
 int processSize[] = {212, 417, 112, 426};
 int m = blockSize.length;
 int n = processSize.length;
int ch = 1;
Scanner sc = new Scanner(System.in);
System.out.println("1.BestFit\n2.WorstFit\n3.Exit");
System.out.println("Enter your choice: ");
ch = sc.nextInt();
switch(ch){
 case 1 :
 System.out.println("BestFit");
 BestFit obj2 = new BestFit();
 obj2.bestFit(blockSize, m, processSize, n);
 break;
 case 2:
 System.out.println("WorstFit");
 WorstFit obj3 = new WorstFit();
 obj3.worstFit(blockSize, m, processSize, n);
 break;
 case 3:
 System.out.println("Exit");
 default:
 break; 
 
 
}
 sc.close();
}
}