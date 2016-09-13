import java.io.*;
import java.util.Scanner;


public class SortingAlgorithms
{
    private static String fileName;

    public static void main(String[] args) throws IOException {

        String line;
        int [] Array = new int[1000];
        int choice;
        int count = 0;

        //Read in file with random numbers for sorting
        Scanner file = new Scanner(System.in);
        System.out.println("Please enter the filename: ");
        fileName = file.nextLine();
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        //Loop through file until count reaches end of the array
        while((line = br.readLine()) != null)
        {
            //Convert each string to an integer
            Array[count] = Integer.parseInt(line);
            count++;
        }
        br.close();

        Scanner input = new Scanner(System.in);

        System.out.println("This program sorts a file of numbers by your choosing");

        System.out.println("\nArray before sorting: ");
        displayArray(Array);

        System.out.println("\n\n----------------------");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Exit");
        System.out.println("----------------------\n");

        //Keep prompting user for sorting method until this choose to exit
        do
        {
            System.out.print("\nPlease enter your sort choice: ");
            choice = input.nextInt();

            chooseMethod(choice, Array);
        }
        while(choice != 6);

        System.exit(0);
    }

    public static void chooseMethod(int choice,  int[] Array)
    {
        if (choice == 1)
        {
            //Assign array to new array and call Bubble Sort method
            int[] sortedArray = BubbleSort(Array);

            //display sorted array
            System.out.println("\nArray after sorting: ");
            displayArray(sortedArray);

            //call method to store array in new text file
            writeArray(sortedArray);

        }

        else if (choice == 2)
        {
            //Assign array to new array and call Selection Sort method
            int[] sortedArray = SelectionSort(Array);

            //display sorted array
            System.out.println("\nArray after sorting: ");
            displayArray(sortedArray);

            //call method to store array in new text file
            writeArray(sortedArray);
        }

        else if (choice == 3)
        {
            //Assign array to new array and call Insertion Sort method
            int[] sortedArray = InsertionSort(Array);

            //display sorted array
            System.out.println("\nArray after sorting: ");
            displayArray(sortedArray);

            //call method to store array in new text file
            writeArray(sortedArray);
        }

        else if (choice == 4)
        {
            //Assign array to new array and call Merge Sort method
            int[] sortedArray = MergeSort(Array);

            //display sorted array
            System.out.println("\nArray after sorting: ");
            displayArray(sortedArray);

            //call method to store array in new text file
            writeArray(sortedArray);
        }

        else if (choice == 5)
        {
            //Assign array to new array and call Quick Sort method
            int[] sortedArray = QuickSort(Array, 0, Array.length - 1);

            //display sorted array
            System.out.println("\nArray after sorting: ");
            displayArray(sortedArray);

            //call method to store array in new text file
            writeArray(sortedArray);
        }

        else
        {
            System.out.println("Invalid choice. Please choose again.");
        }
    }

    //Method to display array
    public static int[] displayArray(int[] array){
        //display array
        for (int i =0; i < array.length; i++)
        {
            //if statement will automatically print a new line after
            //ever 40th increment of the for loop
            if ( i % 40 == 0)
            {
                System.out.print("\n");
            }
            System.out.print(array[i] + " ");
        }

        return array;
    }

    //Method to write array to a text file
    public static void writeArray(int[] array)
    {
        try
        {
            PrintWriter pr = new PrintWriter("src/SortedNumbers.txt");

            for(int i = 0; i < array.length; i++)
            {
                pr.println(array[i]);
            }
            pr.close();
            System.out.println("\n The file " + fileName + "has been sorted and stored in 'SortedNumbers.txt' ");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("The destination file does not exist.");
        }
    }

    //Bubble sort method
    public static int[] BubbleSort(int[] array)
    {
        int outer, inner, temp;

        //The outer loop runs from right to left
        for(outer = array.length-1; outer > 0; outer--)
        {
            //The inner loop runs from left to right
            for(inner = 0; inner < outer; inner ++)
            {
                //If the left item is greater than the right one, swap them
                if(array[inner] > array[inner+1])
                {
                    temp = array[inner];
                    array[inner] = array[inner+1];
                    array[inner + 1] = temp;
                }
            }
        }
        return array;

    }

    //Selection sort method
    public static int[] SelectionSort(int[] array)
    {
        for(int outer = 0; outer < array.length - 1; outer++)
        {
            //Start of array
            int min = outer;
            for ( int inner = outer + 1; inner < array.length; inner++)
            {
                //If the next number is smaller than the first, replace with the first
                if (array[inner] < array[min])
                {
                    min = inner;
                }
            }

            //Smaller number is assigned to temp and then swapped
            int temp = array[min];
            array[min] = array[outer];
            array[outer] = temp;
        }

        return array;
    }

    //InsertionSort method
    public static int[] InsertionSort(int[] array)
    {
        int outer, inner, temp;
        for(outer = 1; outer < array.length; outer++)
        {
            //Assign current outer element to temp and inner to outer - 1
            temp = array[outer];
            inner = outer - 1;

            //Inner loop checks if outer element is smaller than the inner element
            while(inner >= 0 && temp < array[inner])
            {
                //Insert current element into element on right
                array[inner + 1] = array[inner];

                inner --;
            }

            //Swap temp with first element (array[0])
            array[inner + 1] = temp;
        }
        return array;
    }

    //MergeSort method
    public static int[] MergeSort(int[] array)
    {
        sort(array, 0, array.length - 1);
        return array;
    }

    public static void sort(int []array, int lowerIndex, int upperIndex)
    {
        if(lowerIndex == upperIndex)
        {
            return;
        }

        else
        {
            //Find approx. midpoint of the array
            int mid = (lowerIndex + upperIndex)/2;
            //Recursive method sorts everything left of the midpoint
            sort(array, lowerIndex, mid);
            //Recursive method sorts everything right of the midpoint
            sort(array, mid + 1, upperIndex);
            //Merge the sorted array
            merge(array, lowerIndex, mid + 1, upperIndex);
        }
    }

    public static void merge(int [] array, int low, int middle, int high)
    {
        //Get the size of the array and assign it to a temporary array
        int size = array.length;
        int tempArray[] = new int[size];

        int tempIndex = 0;
        int lowerIndex = low;
        int midIndex = middle - 1;
        int totalItems = high - lowerIndex + 1;

        //Loop until lowerIndex is smaller than or equal to the mid index
        //and the middle is smaller than or equal to the high index
        while(lowerIndex <= midIndex && middle <= high)
        {
            //Checks if current item at lowerIndex is smaller than the current item at the middle
            //If yes, it is copied into the temporary array
            if(array[lowerIndex] < array[middle])
            {
                tempArray[tempIndex++] = array[lowerIndex++];
            }

            else
            {
                tempArray[tempIndex++] = array[middle++];
            }
        }

        while (lowerIndex <= midIndex)
        {
            tempArray[tempIndex++] = array[lowerIndex++];
        }
        //Copies all items from the middle that are less than or equal to
        //the high into the temp array
        while (middle <= high)
        {
            tempArray[tempIndex++] = array[middle++];
        }
        //Copies the items from the temporary array into the true array
        for (int i = 0; i < totalItems; i++)
        {
            array[low + i] = tempArray[i];
        }
    }

    //QuickSort method
    public static int[] QuickSort(int[]array, int left, int right)
    {
        int i = left;
        int j = right;
        int temp;

        //Determine approx midpoint of array for pivot
        int pivot = array[(left + right)/2];

        while(i < j)
        {
            //If data is already less than pivot, keep moving through array
            while(array[i] < pivot)
            {
                i++;
            }

            //If right hand side is greater than pivot, we move down array
            while(array[j] > pivot)
            {
                j--;
            }

            //Otherwise we swap
            if (i <= j)
            {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        //Recursive call since we are dealing with segments of the array
        if (left < j)
        {
            QuickSort(array, left, j);
        }

        if(i < right)
        {
            QuickSort(array, i, right);
        }

        return array;
    }
}
