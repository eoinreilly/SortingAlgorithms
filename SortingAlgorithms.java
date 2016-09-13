import java.io.*;
import java.util.Scanner;

/**
 * Created by reillye on 13-Sep-16.
 */
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
        System.out.println("----------------------");

        //Retrieve the choice from the user
        System.out.print("\nPlease enter your sort choice: ");
        choice = input.nextInt();

        if (choice == 1)
        {
            //Assign array to new array and call Bubble Sort method
            int[] sortedArray = BubbleSort(Array);

            //call method to store array in new text file
            writeArray(sortedArray);

            //display sorted array
            System.out.println("\nArray after sorting: ");
            displayArray(sortedArray);
        }

        else if (choice == 2)
        {
            //Assign array to new array and call Selection Sort method
            int[] sortedArray = SelectionSort(Array);

            //call method to store array in new text file
            writeArray(sortedArray);

            //display sorted array
            System.out.println("\nArray after sorting: ");
            displayArray(sortedArray);
        }

        else if (choice == 3)
        {
            //Assign array to new array and call Insertion Sort method
            int[] sortedArray = InsertionSort(Array);

            //call method to store array in new text file
            writeArray(sortedArray);

            //display sorted array
            System.out.println("\nArray after sorting: ");
            displayArray(sortedArray);
        }

        else if (choice == 4)
        {
            //Assign array to new array and call Merge Sort method
            int[] sortedArray = MergeSort(Array);

            //call method to store array in new text file
            writeArray(sortedArray);

            //display sorted array
            System.out.println("\nArray after sorting: ");
            displayArray(sortedArray);
        }

        else if (choice == 5)
        {
            //Assign array to new array and call Quick Sort method
            int[] sortedArray = QuickSort(Array);

            //call method to store array in new text file
            writeArray(sortedArray);

            //display sorted array
            System.out.println("\nArray after sorting: ");
            displayArray(sortedArray);
        }

        else if (choice == 6)
        {
            System.exit(0);
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
            PrintWriter pr = new PrintWriter("src/SortedNumbers/txt");

            for(int i = 0; i < array.length; i++)
            {
                pr.println(array[i]);
            }
            pr.close();
            System.out.println("\nThe file " + fileName + "has been sorted and stored in 'SortedNumbers.txt' ");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("No such file exists.");
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
                //If the left iten is greater than the right one, swap them
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

    }

    //InsertionSort method
    public static int[] InsertionSort(int[] array)
    {

    }

    //MergeSort method
    public static int[] MergeSort(int[] array)
    {

    }

    //QuickSort method
    public static int[] QuickSort(int[]array, int left, int right)
    {

    }



}
