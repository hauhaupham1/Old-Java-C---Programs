//Hau Pham
//This program is created for the user to set up a train with different car set.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner kb= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome To Train Program");
        System.out.println("Weight in Kilogram, Value in U.S Dollar Currency");
        Train train = null;
        char again;
        char choice;
        System.out.print("Enter max load for a single car: ");
        double maxLoad = kb.nextDouble();

        do {
            System.out.println("Let's build a train");
            Engine engine = construcEngine();
            System.out.print("Enter engineer's name: ");
            String engineerName = kb.nextLine();
            train = new Train(engine, engineerName);
            do {
                System.out.println("Train Building Menu");
                System.out.println("(a) Add a car");
                System.out.println("(b) Display a complete description of the characteristics of the train");
                System.out.println("(c) Display a brief summary of each car");
                System.out.println("(d) Display the total weight and value of the train");
                System.out.println("(e) Start a new train");
                System.out.println("(f) Exit the program");
                System.out.print("Choose an option: ");
                choice = kb.next().charAt(0);
                kb.nextLine(); //


                if (choice == 'a') {
                    train.addCar(createFreightCar(maxLoad));
                } else if (choice == 'b'){
                    System.out.println(train.engineAndCars());
                }else if (choice == 'c'){
                    System.out.println(train.summaryCarID(maxLoad));
                }else if (choice == 'd'){
                    System.out.println(train.choiceD(engine.getPullingCapacity()));
                }else if (choice == 'e') {
                    engine = construcEngine();
                    System.out.print("Enter engineer's name: ");
                    engineerName = kb.nextLine();
                    train = new Train(engine, engineerName);
                }
            }while (choice !='f');
            System.out.print("Do you want to run the program again?:");
            again = kb.next().charAt(0);
        }while (again =='y' || again == 'Y');
    }

    public static Engine construcEngine() {
        System.out.println("Please enter engine details:");
        System.out.print("Enter the pulling capacity: ");
        double pullingCapacity = kb.nextDouble();
        kb.nextLine();

        System.out.print("Enter the name of owner: ");
        String name = kb.nextLine();

        System.out.print("Enter the unique ID number: ");
        int IDNum = kb.nextInt();
        kb.nextLine();

        System.out.print("Enter the weight of base frame: ");
        double weightOfBaseFrame = kb.nextDouble();
        kb.nextLine();
        return new Engine(pullingCapacity, name, IDNum, weightOfBaseFrame);
    }

    public static FreightCar createFreightCar( double maxLoad) {
        Container container = createContainer(kb);
        Contents contents = createContents(kb);

        System.out.print("Enter the load factor (on scale of 100): ");
        double loadFactor = kb.nextDouble();
        kb.nextLine();

        System.out.print("Enter the owner's name: ");
        String ownerName = kb.nextLine();

        System.out.print("Enter the unique ID number: ");
        int uIDNum = kb.nextInt();
        kb.nextLine();

        System.out.print("Enter the weight of the base frame: ");
        double weightOfBaseFrame = kb.nextDouble();
        kb.nextLine();

        FreightCar car = new FreightCar(loadFactor, container, contents, ownerName, uIDNum, weightOfBaseFrame);
        // Check if the car's weight exceeds the maximum load
        if (car.totalWeight() > maxLoad) {
            System.out.println("Warning: Car weight exceeds the maximum acceptable load for a single car.");
        }

        return car;
    }

    public static Container createContainer(Scanner kb) {
        System.out.println("Choose the shape of the container:");
        System.out.println("1. Cylinder");
        System.out.println("2. Trapezoidal Box");
        int shapeChoice = kb.nextInt();
        kb.nextLine();

        if (shapeChoice == 1) {
            System.out.print("Enter the radius of the cylinder: ");
            double radius = kb.nextDouble();
            kb.nextLine();

            System.out.print("Enter the length of the cylinder: ");
            double length = kb.nextDouble();
            kb.nextLine();

            System.out.print("Enter the wall thickness: ");
            double wallThickness = kb.nextDouble();
            kb.nextLine();

            System.out.print("Enter the wall density: ");
            double wallDensity = kb.nextDouble();
            kb.nextLine();

            return new Cylinder(radius, length, wallThickness, wallDensity);
        } else if (shapeChoice == 2) {
            System.out.print("Enter the height of the trapezoidal box: ");
            double height = kb.nextDouble();
            kb.nextLine();

            System.out.print("Enter the width of the trapezoidal box: ");
            double width = kb.nextDouble();
            kb.nextLine();

            System.out.print("Enter the upper length of the trapezoidal box: ");
            double upperLength = kb.nextDouble();
            kb.nextLine();

            System.out.print("Enter the lower length of the trapezoidal box: ");
            double lowerLength = kb.nextDouble();
            kb.nextLine();

            System.out.print("Enter the wall thickness: ");
            double wallThickness = kb.nextDouble();
            kb.nextLine();

            System.out.print("Enter the wall density: ");
            double wallDensity = kb.nextDouble();
            kb.nextLine();
            return new TrapezoidalBox(height, width, upperLength, lowerLength, wallThickness, wallDensity);
        }
        return null;
    }

    public static Contents createContents(Scanner kb) {
        System.out.println("Choose the type of contents:");
        System.out.println("Contents\t Density(Pounds per Cubic Foot)\t Value(Dollars per pound)");
        System.out.println("1. Oil\t 55 \t 30.03");
        System.out.println("2. Coal\t 69\t 0.679");
        System.out.println("3. Soybean oil\t 57 \t0.56");
        System.out.println("4. Linseed oil\t 59 \6.12");
        System.out.println("5. Uranium\t 1186 \t 40");
        int contentsChoice = kb.nextInt();
        kb.nextLine();
        if (contentsChoice == 1) {
            return new Contents("Oil", 55, 30.03);
        } else if(contentsChoice ==2) {
            return new Contents("Coal", 69, 0.679);
        }else if(contentsChoice ==3) {
            return new Contents("Soybean oil", 57, 0.56);
        }else if(contentsChoice ==4) {
            return new Contents("Linseed oil", 59, 6.12);
        }else
            return new Contents("Uranium", 1186, 40);
        }
    }




class Contents{
    private String name;
    private double density;       //weight per volume
    private double value;       //dollars per pound
    public String getName(){return name;}
    public double getDensity(){return density;}
    public double getValue(){return value;}
    public void setValue(double _value){
        value = _value;
    }
    public Contents(String _name, double _density, double _value){
        name = _name;
        density = _density;
        value = _value;
    }
    public String toString(){
        String s = "Name: "+ name
                +"\nDensity: "+ density
                +"\nValue: "+ value;
        return s;
    }
}
abstract class RollingStock{
    private String nameOfOwner;
    private int uIDNum;
    private double weightOfBaseFrame;
    public double getWeightOfBaseFrame(){return weightOfBaseFrame;}
    public RollingStock(String _nameOfOwner, int _uIDNum, double _weightOfBaseFrame){
        nameOfOwner = _nameOfOwner;
        uIDNum = _uIDNum;
        weightOfBaseFrame = _weightOfBaseFrame;
    }
    public int getID() { return uIDNum;}
    public String toString(){
        String s= "Name of Owner: "+ nameOfOwner
                +"\nUnique ID Number: "+ uIDNum
                +"\nWeight of Base Frame: "+ weightOfBaseFrame;
        return s;
    }
}
class Engine extends RollingStock{
    private double pullingCapacity;
    public double getPullingCapacity(){
        return pullingCapacity;
    }
    public Engine(double _pullingCapacity, String _nameOfOwner, int _uIDNum, double _weightOfBaseFrame){
        super(_nameOfOwner, _uIDNum, _weightOfBaseFrame);
        pullingCapacity = _pullingCapacity;
    }
    public String toString(){
        String s= "Pulling Capacity: "+ pullingCapacity;
        return super.toString()+"\n" + s;
    }
}
class FreightCar extends  RollingStock{
    private double loadFactor;
    Container containerInstance;
    Contents contentsInstance;
    public void setLoadFactor(double _loadFactor){loadFactor = _loadFactor;}
    public double getLoadFactor(){return loadFactor;}
    public FreightCar(double _loadFactor, Container _containerInstance, Contents _contentsInstance, String _nameOfOwner, int _uIDNum, double _weightOfBaseFrame){
        super(_nameOfOwner, _uIDNum, _weightOfBaseFrame);
        loadFactor = _loadFactor;
        containerInstance = _containerInstance;
        contentsInstance = _contentsInstance;
    }
    public double totalWeight(){
        return containerInstance.totalWeightWall() + contentsInstance.getDensity() * containerInstance.interiorVolume();
    }
    public double totalValue(){
       /* System.out.println(containerInstance.interiorVolume());
        System.out.println(contentsInstance.getDensity());
        System.out.println(contentsInstance.getValue());
        System.out.println(loadFactor);  */
       return containerInstance.interiorVolume() * contentsInstance.getDensity() * contentsInstance.getValue()*(loadFactor/100.0);
    }
    public String toString(){
        String s = "Load Factor: "+ loadFactor;
        return super.toString() + "\n"+ s;
    }
}
abstract class Container{
    private double thicknessOfWall;
    private double densityOfWall;
    public double getThicknessOfWall(){return thicknessOfWall;}
    public double getDensityOfWall(){return  densityOfWall;}
    public Container(double _thicknessOfWall, double _densityOfWall){
        thicknessOfWall = _thicknessOfWall;
        densityOfWall = _densityOfWall;
    }
    abstract public double interiorVolume();
    abstract public double exteriorVolume();

    public String toString(){
        String s="Thickness of Wall: "+ thicknessOfWall
                +"\nDensity of Wall: "+ densityOfWall;
        return s;
    }
    public double totalWeightWall(){
        return (exteriorVolume()-interiorVolume())*densityOfWall;
    }

}
class Cylinder extends Container{
    private double radius;
    private  double length;
    public double getRadius(){return radius;}
    public double getLength(){return  length;}
    public Cylinder(double _radius, double _length,double wallThickness, double wallDensity){
        super(wallThickness, wallDensity);
        radius = _radius;
        length = _length;
    }
    public double exteriorVolume(){
        return Math.PI * Math.pow(radius,2) *length;
    }
    public double interiorVolume(){
        return Math.PI * Math.pow(radius-getThicknessOfWall(),2) * (length-(2*getThicknessOfWall()));
    }
    public String toString(){
        String s = "Radius: "+ radius
                +"\n Length: "+ length
                +"\n Exterior Volume: "+ exteriorVolume()
                +"\n Interior Volume: "+ interiorVolume();
        return s;
    }
}
class TrapezoidalBox extends Container {
    private double height;
    private double width;
    private double upperLength;
    private double lowerLength;
    public double getHeight(){return height;}
    public double getWidth(){return width;}
    public double getUpperLength(){return upperLength;}
    public double getLowerLength(){return  lowerLength;}
    public TrapezoidalBox(double _height,double _width,double _upperLength,double _lowerLength,double wallThickNess,double wallDensity){
        super(wallThickNess, wallDensity);
        height = _height;
        width = _width;
        upperLength = _upperLength;
        lowerLength = _lowerLength;

    }
    public double exteriorVolume(){
        //or a trapezoidal box: volume = (1/2) (upper length + lower length) • width • heigh
        return (1/2)*(upperLength + lowerLength)*width*height;
    }
    public double interiorVolume(){
        //or a trapezoidal box: volume = (1/2) (uL - 2t + LL - 2t) • (w - 2t) • (h-t)
        //t is wall thickness
        return (1/2)*(upperLength - 2*getThicknessOfWall()+ lowerLength - 2*getThicknessOfWall()*(width -2*getThicknessOfWall())*(height-getThicknessOfWall()));
    }
    public String toString(){
        String s="Height: "+ height
                +"\nWidth: "+ width
                +"\nUpper Length: "+ upperLength
                +"\nLower Length: "+ lowerLength
                +"\nExterior Volume: "+ exteriorVolume()
                +"\nInterior Volume: "+ interiorVolume();
        return s;
    }
}
class Train{
    Engine engine;
    ArrayList <FreightCar> cars;
    String nameOfEngineer;
    public Train(Engine _engine,  String enName ){
        engine = _engine;
        nameOfEngineer = enName;
        cars = new ArrayList<FreightCar>();
    }
    public String getNameOfEngineer(){return nameOfEngineer;}
    public void addCar(FreightCar carToAdd){
        cars.add(carToAdd);
    }
    public void removeCar(int _uIDNum) {
        for (int ix = 0; ix < cars.size(); ix++) {
            FreightCar carID = cars.get(ix);
            if (carID.getID() == _uIDNum) {
                 cars.remove(ix);
            }
        }
    }
    public void changeLoad(int _uIDNum, double _loadFactor){
        for ( int ix = 0; ix < cars.size(); ++ix ) {
            FreightCar carID = cars.get(ix);
            if (carID.getID() == _uIDNum){
                carID.setLoadFactor(_loadFactor);
            }
        }
    }
    public double totalWeightOfTrain(){
        double totalWeight=0;
        for (int i=0;i< cars.size(); i++){
            FreightCar weight = cars.get(i);
            totalWeight = totalWeight + weight.totalWeight();
        }
        return totalWeight;
    }
    public double totalValueOfTrain(){
        double totalValue=0;
        for (int i=0;i< cars.size(); i++){
            FreightCar weight = cars.get(i);
            totalValue = totalValue + weight.totalValue();
        }
        return totalValue + engine.getWeightOfBaseFrame();
    }
    public String summaryCarID(double allowForSingleCar){        //c
        String s="";
        for (int i =0; i<cars.size(); i++){
            FreightCar carID = cars.get(i);
                s += "-Car :"+(i+1)+ "\nID:" + carID.getID()+"\t" +"Car Value:" + carID.totalValue()+"\t" + "Car Total Weight:" + carID.totalWeight() + "\n" ;
            if (carID.totalWeight() > allowForSingleCar) {
               s+= "Warning: This car weight exceeds the maximum acceptable load for a single car.";
            }
        }
        return s;
    }
    public String engineAndCars(){
        String s= "Cars Summary: \n";
        for (int i =0; i<cars.size(); i++){
            FreightCar cardID = cars.get(i);
            s+= "- Car "+ i+1 +":\n"+ cardID.toString() +"\n" ;
        }
        return s + "\nEngine Summary:\n" + engine.toString();
    }
    public String choiceD(double maxAllow){         //d
        String s="";
        int numOfCar =0;
        double _totalValue=0;
        double _totalWeight=0;
        for (int i =0; i<cars.size(); i++){
            numOfCar++;
            FreightCar carID = cars.get(i);
                s += "Car "+ (i+1) + " Card ID: " + carID.getID() +"\n" ;
                _totalValue += carID.totalValue();
                _totalWeight+= carID.totalWeight();
        }
        s+=  "Total num of cars: "+ numOfCar;
        s+= " Total Weight: " + _totalWeight;
        s+= " Total Value: "+ _totalValue;
        if (totalWeightOfTrain() > maxAllow){
            s = s+ "\nWeight is greater than the pulling capacity of the engine";
        }
        return s;
    }

}