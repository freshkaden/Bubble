import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class sort {
    public static void main(String[] args) throws IOException{ 
        Scanner scanner = new Scanner(System.in);

        int arrayLength = 0;

        System.out.print("Array length: ");
        arrayLength = scanner.nextInt();
        
        int [] array = createRandomArray(arrayLength);

        scanner.nextLine();
       
        System.out.print("write array to filename: ");
        String wfilename = "";
        wfilename = scanner.nextLine();

        writeArrayToFile(array, wfilename);

        //scanner.nextLine();

        System.out.print("read from filename: ");
        String rfilename = scanner.nextLine();


        int[] readArray = readFileToArray(rfilename);

        System.out.println("Array from file: " + Arrays.toString(readArray));

        bubbleSort(readArray);

        System.out.println("\nSorted Array: " + Arrays.toString(readArray));

        System.out.print("\nstore sorted array in filename: ");
        String zfilename = scanner.nextLine();
        writeArrayToFile(readArray, zfilename);
        System.out.println("Stored sorted array in file: " + zfilename);


        


    }

    public static int[] createRandomArray(int arrayLength){
        
        int[] array = new int[arrayLength];
        
        Random random = new Random(0);

        int i;

        for (i = 0; i < array.length; i++){
            //array[i] = random.nextInt(0, 100);
            array[i] = random.nextInt(0 ,101);
        }

        for (i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        


        return array;


    }

    public static void writeArrayToFile(int[] array, String filename) throws IOException{
        FileWriter fileWriter = new FileWriter(filename);

        for (int i = 0; i < array.length; i++){
            fileWriter.write(Integer.toString(array[i]));
            if (i < array.length -1 ){
                fileWriter.write("\n");
            }
        }


        fileWriter.close();
    }

    public static int[] readFileToArray(String filename) throws FileNotFoundException{
        
        Scanner scanner = new Scanner(new File(filename));



        List<Integer> list = new ArrayList<>();

        while (scanner.hasNextLine()){
            list.add(scanner.nextInt());
        }
        
        int [] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }
        
        scanner.close();



        return array;
    }

    public static void bubbleSort(int[] array){
        int n = array.length;

        boolean is_swapped;

        for (int i = 0; i < n -1; i++){
            is_swapped = false;

            for (int j = 0; j < n-1; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j]= array[j + 1];
                    array [j + 1] = temp;

                    is_swapped = true;


                }
            }
        

            if (!is_swapped){
            break;
            }
        }

    }
}
