import java.io.File;
import java.io.IOException;
import java.util.Scanner;
class element {
    public String elementName;
    public String stateOfElement;
    public int atomicNumber;
    public double atomicMass;
}

public class program3 {

    public static void main(String[] args) {
        element[] _dataFile = new element[100];
        int _nElements;

        Scanner kb = new Scanner(System.in);
        _nElements = loadDatafile(_dataFile);
        if(_nElements>0) {
            int choice = 0;
            do {
                System.out.print("" +
                        "(1). List all the element and their data\n" +
                        "(2). List the data by the selected element (by name).\n" +
                        "(3). Compute average atomic mass over a user-specified range of atomic weights.\n" +
                        "(4). Display the distribution of states by atomic number.\n"+
                        "(0). Quit.");
                choice = kb.nextInt();
                if (choice == 1) {
                    displayData(_dataFile, _nElements);
                    System.out.println();

                } else if (choice == 2) {
                    System.out.print("Enter the name of element you would like to display: ");
                    String targetElement = kb.next();
                    selectedDisplay(_dataFile, targetElement);
                } else if (choice == 3) {
                    System.out.println(averageInRange(_dataFile, _nElements));
                } else if (choice == 4) {
                    displayDistribution(_dataFile, _nElements);
                }
            } while (choice != 0);
        }
        System.out.println("Goodbye!");

    }
    public static int loadDatafile(element[] dataFile){
        Scanner kb = new Scanner(System.in);
        int nElement = 0;
        System.out.print("Enter the file name: ");
        String fileName = kb.next();
        try {
            File file = new File(fileName);
            Scanner inFile = new Scanner(file);
            do{
               dataFile[nElement] = new element();
               dataFile[nElement].elementName = inFile.next();
              // System.out.println(dataFile[nElement].elementName);
               dataFile[nElement].stateOfElement = inFile.next();
              //  System.out.println(dataFile[nElement].stateOfElement);
               dataFile[nElement].atomicNumber = inFile.nextInt();
               // System.out.println(dataFile[nElement].atomicNumber);
               dataFile[nElement].atomicMass = inFile.nextDouble();
               // System.out.println(dataFile[nElement].atomicMass);
               nElement++;

            } while(!(dataFile[nElement-1].elementName.equals("EOF")));
            nElement--;
            inFile.close(); // Close the file when done reading
        }

        catch (IOException ioe){
            System.out.println("File access error");
            nElement = 0;
        }
        return nElement;
    }
    public static void displayData(element[] dataFile, int nElement){
        int i;
        for (i = 0; i < nElement; i++){
            System.out.print(dataFile[i].elementName+ "\t" + dataFile[i].stateOfElement+"\t" + dataFile[i].atomicNumber+"\t" + dataFile[i].atomicMass);
            System.out.println();
        }

    }
    public static void selectedDisplay(element[] dataFile, String targetName){
        for (int i = 0; i<dataFile.length;i++){
            if (dataFile[i] != null && dataFile[i].elementName.equals(targetName)){
                System.out.println(dataFile[i].elementName+ "\t" + dataFile[i].stateOfElement+"\t" + dataFile[i].atomicNumber+"\t" + dataFile[i].atomicMass);
            }
        }
    }
    public static double averageInRange(element[] dataFile, int nElement){
        double average;
        double total=0;
        int count = 0;
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter lower bound: ");
        double lowerBound = kb.nextDouble();
        System.out.print("Please enter upper bound: ");
        double upperBound = kb.nextDouble();
        for (int i = 0; i<nElement; i++){
            if(dataFile[i].atomicMass>lowerBound && dataFile[i].atomicMass < upperBound){
                total = total + dataFile[i].atomicMass;
                count++;
            }
        }
        average = total / count;
        return average;
    }
    public static void displayDistribution(element[] dataFile,int nElement){
        int []count = new int[10];
        double minium = dataFile[0].atomicMass;
        double maxium = dataFile[0].atomicMass;
        for (int i = 1; i < nElement;i++){//find the minium
            if(minium>dataFile[i].atomicMass){
                minium = dataFile[i].atomicMass;
            }
        }
        for (int j =1; j<nElement;j++){
            if(maxium<dataFile[j].atomicMass){
                maxium = dataFile[j].atomicMass;
            }
        }
        double range = (maxium - minium)/10;
        int decadeWidth = (int)Math.ceil(range);        //width of decade
        for(int i = 0; i < nElement;i++){
            int counterindex = (int) (((dataFile[i].atomicMass)-minium)/decadeWidth);
            count[counterindex]++;
        }
        for (int i = 0; i < 10;i++){
            System.out.println((decadeWidth*(i+1) +"\t"+count[i]));
        }


    }
}






