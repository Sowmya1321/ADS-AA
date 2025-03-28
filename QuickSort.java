import java.util.*;
class QuickSort
{
	public static void quicksort(int[] arr,int low,int high)
	{
		if(low<high)
		{
			int pivot = partition(arr,low,high);
			quicksort(arr,low,pivot-1);
			quicksort(arr,pivot+1,high);
		}
	}
	public static int partition(int[] arr,int low,int high)
	{
		int pivot=arr[high];
		int i=low-1;
		for(int j=low;j<high;j++)
		{
			if(arr[j]<=pivot)
			{
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}
	public static void measureExeTime(int []arr)
	{
		long startTime=System.nanoTime();
		quicksort(arr,0,arr.length-1);
		long endTime=System.nanoTime();
		long duration=endTime-startTime;
		System.out.println("Execution Time(in nanoseconds):"+duration);
		System.out.println("Sorted Arrays: "+ Arrays.toString(arr));
	}
	public static void main(String args[])
	{
		Random random=new Random();
		int n=10;
		int[] avgCase=new int[n];
		for(int i=0;i<n;i++)
		{
			avgCase[i]=random.nextInt(100);
		}
		System.out.println("Average Case(Random Array):");
		measureExeTime(avgCase.clone());
		int[] bestCase=new int[n];
		for(int i=0;i<n;i++)
		{
			bestCase[i]=i;
		}
		System.out.println("BestCase(Sorted Array):");
		measureExeTime(bestCase.clone());
		int[] worstCase=new int[n];
		for(int i=0;i<n;i++)
		{
			worstCase[i]=n-i-1;
		}
		System.out.println("worst Case(Reverse Sorted Array):");
		measureExeTime(worstCase.clone());
	}
}	




OUTPUT:Average Case(Random Array):
Execution Time(in nanoseconds):3818
Sorted Arrays: [11, 18, 38, 50, 53, 55, 73, 78, 92, 98]
BestCase(Sorted Array):
Execution Time(in nanoseconds):3025
Sorted Arrays: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
worst Case(Reverse Sorted Array):
Execution Time(in nanoseconds):2612
Sorted Arrays: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]


