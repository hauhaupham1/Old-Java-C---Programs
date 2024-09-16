//Hau Pham
//Program 6 let user manipulate string list, also generalize the program to work for inventory list.
import java.util.Scanner;

public class program6 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("This program let you manipulate 3 lists (a string list, and 2 inventory \nitem lists");
        LinkedList stringList = new LinkedList();
        LinkedList inventoryList1 = new LinkedList();
        LinkedList inventoryList2 = new LinkedList();

        char again = 'y';
        while (again == 'y' || again == 'Y') {
            System.out.print("Which list you want to manipulate? ");
            System.out.print("1 for String list, 2 for the first inventory list, \n3 for the second inventory list: ");
            int whichList = scanner.nextInt();
            if (whichList == 1) {
                System.out.println("Menu:");
                System.out.println("1. Initialize");
                System.out.println("2. Insert on Front");
                System.out.println("3. Insert");
                System.out.println("4. Delete the item at a given position in the list\n" +
                        "5. Delete all the occurrences of a given item from the list\n" +
                        "6. Retrieve: return the item at a given position in the list\n" +
                        "7. Find: return a list of the positions where a given item is found in the list\n" +
                        "8. Get Size: return the number of items in the list\n" +
                        "9. Show: return a string summarizing the contents of the list.");
            } else if (whichList == 2 || whichList == 3) {
                System.out.println("Menu:");
                System.out.println("1. Initialize");
                System.out.println("2. Insert on Front");
                System.out.println("3. Insert");
                System.out.println("4. Delete the item at a given position in the list\n" +
                        "5. Delete all the occurrences of a given item from the list\n" +
                        "6. Retrieve: return the item at a given position in the list\n" +
                        "7. Find: return a list of the positions where a given item is found in the list\n" +
                        "8. Get Size: return the number of items in the list\n" +
                        "9. Show: return a string summarizing the contents of the list.\n" +
                        "10. Compute total value of inventory list.");
            }

            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                // Initialize lists
                if (whichList == 1) stringList = new LinkedList();
                else if (whichList == 2) inventoryList1 = new LinkedList();
                else if (whichList == 3) inventoryList2 = new LinkedList();
                System.out.println("List initialized.");
            } else if (userChoice == 2) {
                // Insert on front

                if (whichList == 1) {
                    System.out.println("Enter data to insert on front:");
                    String data = scanner.next();
                    stringList.insertOnFront(data);
                }else if (whichList == 2){
                    Inventory invenItem;
                    System.out.println("Enter name:");
                    String data = scanner.next();
                    System.out.println("Enter quantity:");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter cost per item:");
                    double value = scanner.nextDouble();
                    inventoryList1.insertOnFront(invenItem = new Inventory(data, quantity, value));
                }else if (whichList == 3){
                    Inventory invenItem;
                    System.out.println("Enter name:");
                    String data = scanner.next();
                    System.out.println("Enter quantity:");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter cost per item:");
                    double value = scanner.nextDouble();
                    inventoryList2.insertOnFront(invenItem = new Inventory(data, quantity, value));
                }
                System.out.println("Done insert on front");
            } else if (userChoice == 3) {
                // Insert

                if (whichList == 1) {
                    System.out.println("Enter data to insert:");
                    String dataToInsert = scanner.next();
                    System.out.println("Enter position to insert:");
                    int positionToInsert = scanner.nextInt();
                    stringList.insert(dataToInsert, positionToInsert);
                }else if (whichList == 2) {
                    Inventory invenItem;
                    System.out.println("Enter name:");
                    String data = scanner.next();
                    System.out.println("Enter quantity:");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter cost per item:");
                    double value = scanner.nextDouble();
                    System.out.println("Enter position to insert:");
                    int positionToInsert = scanner.nextInt();
                    inventoryList1.insert(invenItem = new Inventory(data, quantity, value), positionToInsert);
                }else if (whichList == 3) {
                    Inventory invenItem;
                    System.out.println("Enter name:");
                    String data = scanner.next();
                    System.out.println("Enter quantity:");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter cost per item:");
                    double value = scanner.nextDouble();
                    System.out.println("Enter position to insert:");
                    int positionToInsert = scanner.nextInt();
                    inventoryList2.insert(invenItem = new Inventory(data, quantity, value), positionToInsert);
                }
                System.out.println("Done");
            } else if (userChoice == 4) {
                System.out.print("Enter the position: ");
                int position = scanner.nextInt();
                if (whichList == 1) stringList.delete(position);
                else if (whichList == 2) inventoryList1.delete(position);
                else if (whichList == 3) inventoryList2.delete(position);
                System.out.println("Done");
            } else if (userChoice == 5) {


                if (whichList == 1) {
                    System.out.print("Enter the name: ");
                    String data = scanner.next();
                    stringList.deleteItem(data);
                }
                else if (whichList == 2) {
                    System.out.print("Enter the name of inventory item: ");
                    String data = scanner.next();
                    Inventory itemToDelete = new Inventory(data,0,0);
                    inventoryList1.deleteItem(itemToDelete);
                }
                else if (whichList==3) {
                    System.out.print("Enter the name of inventory item: ");
                    String data = scanner.next();
                    Inventory itemToDelete = new Inventory(data,0,0);
                    inventoryList1.deleteItem(itemToDelete);
                }
                System.out.println("Done");
            } else if (userChoice == 6) {
                System.out.print("Enter the position: ");
                int position = scanner.nextInt();
                if (whichList == 1) System.out.println(stringList.retrieve(position));
                else if (whichList == 2) System.out.println(inventoryList1.retrieve(position));
                else System.out.println(inventoryList2.retrieve(position));
                System.out.println("Done");
            } else if (userChoice == 7) {
                System.out.print("Enter the name: ");
                String data = scanner.next();
                if (whichList == 1) {
                    System.out.println("Position(s) List in backward order: " + stringList.find(data));
                } else if (whichList == 2) {
                    System.out.println("Position(s) List in backward order: " + inventoryList1.find(data));
                } else if (whichList==3) {
                    System.out.println("Position(s) List in backward order: " + inventoryList2.find(data));
                }
                System.out.println("Done");
            } else if (userChoice == 8) {
                if (whichList == 1) {
                    System.out.println("Size: " + stringList.getSize());
                } else if (whichList == 2) {
                    System.out.println("Size: " + inventoryList1.getSize());
                } else if (whichList==3){
                    System.out.println("Size: " + inventoryList2.getSize());
                }
                System.out.println("Done");
            } else if (userChoice == 9) {
                if (whichList == 1) System.out.println(stringList.toString());
                else if (whichList == 2) System.out.println(inventoryList1.toString());
                else if (whichList==3) System.out.println(inventoryList2.toString());
                System.out.println("Done");
            } else if (userChoice == 10 & whichList == 2 || whichList == 3 ) {

                double totalValue = 0;
                if (whichList == 2) {
                    for (int pos = 1; pos <= inventoryList1.getSize(); pos++) {
                        Inventory inven = (Inventory) inventoryList1.retrieve(pos);
                        totalValue += inven.getQuantity() * inven.getCostPerItem();
                    }
                    System.out.println("Total Value of Inventory Item(s): "+totalValue);
                } else if (whichList ==3){
                    for (int pos = 1; pos <= inventoryList2.getSize(); pos++) {
                        Inventory inven = (Inventory) inventoryList2.retrieve(pos);
                        totalValue += inven.getQuantity() * inven.getCostPerItem();
                    }
                    System.out.println("Total Value of Inventory Item(s): "+totalValue);
                }

            } else System.out.println("Invalid choice");
            System.out.print("Do you want to do anything else? (y/n): ");
            again = scanner.next().charAt(0);
        }
    }
}
class Link{
    public Object data;
    public Link next;
}
class LinkedList{
    private Link _head;
    private int size=0;
    public LinkedList(){
        _head = null;
    }
    public void insertOnFront(Object givenItem){
        Link add = new Link();
        add.data = givenItem;
        add.next = _head;
        _head = add;
        size++;
    }
    public void insert(Object item, int position){
        if (position<1 || position > size+1){
            //do nothing
        } else if (position ==1){
            insertOnFront(item);
        } /*else if (position == size+1) {
            int thePosition =1;
            Link add = new Link();
            add.data = item;
            //go to the position size + 1
            Link current = _head;
            while (current!=null){
                thePosition++;
                current = current.next;
                if (thePosition == size){
                    current.next = add;
                    size++;
                }
            }

        } */else {
            int thePosition = 1;
            Link add = new Link();
            add.data = item;
            //Find the position
            Link prev = null;
            Link current = _head;
            do {
                thePosition++;
                prev = current;
                current = current.next;
                if (thePosition == position){
                    //insert item
                    add.next = current;
                    prev.next = add;
                    size++;
                }
            }while (current!=null);
        }
    }
    public void delete(int position){
        if (position<1 || position>size){
            //do nothing
        }else {if (position ==1){
            _head = _head.next;
            size= size-1;
        } else {
            int thePosition = 1;
            Link prev = null;
            Link curr = _head;
            for (int i = 2; i <= position; i++) {
                thePosition++;
                prev = curr;
                curr = curr.next;
                if (thePosition == position) {
                    prev.next = curr.next;
                    size = size-1;
                }
            }
                }
       }
    }
    public void deleteItem(Object item) {
        while (_head != null && _head.data.equals(item)) {       //in case first item is the target item
            //if ( _head.data.equals(item)){
                _head = _head.next;
                size = size - 1;
            //}
        }
        Link prev = null;
        Link curr = _head;
        if (size < 0 || size == 0) {
        }else {

        while (curr != null) {
            if (curr.data.equals(item)) {
                prev.next = curr.next;
                size = size - 1;
            } else {
                prev = curr;
            }
            curr = curr.next;

        }
    }
    }

    public int getSize(){
        return size;
    }
    public Object retrieve(int position) {
        if (position < 0 || position > size) {
              return null;
        } else {
            if (position == 1) {
                return _head.data;
            } else {
                int thePosition = 1;
                Link curr = _head;
                for (int i = 2; i <= position; i++) {
                    thePosition++;
                    curr = curr.next;
                    if (thePosition == position) {
                        return curr.data;
                    }
                }
            }
        }
     return null;
    }
    public LinkedList find(Object item){
        int thePosition = 0;
        LinkedList returnedLink = new LinkedList();
        Link curr = _head;
        while (curr != null){
            thePosition++;
            if (curr.data.equals(item)){
                returnedLink.insertOnFront(thePosition);
            }
            curr = curr.next;
        }
        return returnedLink;
    }


    public String toString(){
        Link current = _head;
        String s ="";
        s+= "Content of Linked List" + "\n";
        s+= "-- front -- " ;
        while (current != null){
            s += current.data + "\t";
            current = current.next;
        }
        s += "-- back --" + "\nSize: "+ size + "\n" ;
        return s;
    }
}
class Inventory{
    private String name;
    private int quantity;
    private double costPerItem;
    public Inventory(String _name, int _quantity, double _costPerItem){
        name = _name;
        quantity = _quantity;
        costPerItem = _costPerItem;
    }
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getCostPerItem(){
        return costPerItem;
    }
    public boolean equals(Object other){
        //System.out.println("Here");
        if (other instanceof Inventory) {
            Inventory comparedObject = (Inventory) other;
            return (name.equals(comparedObject.name));
        } else return false;
    }
   /* public double computeTotalValue(){
        return  ((double) quantity) * costPerItem;
    } */
    public String toString() {
        return "Item: " + name + ", Quantity: " + quantity + ", Cost per item: $" + costPerItem;
    }

}

public class YourSimpleLinkedList extends SimpleLinkedList {

    @Override
    protected int countNegative() {
        int count = 0;
        Item current = start;

        // Iterate through the linked list
        while (current != null) {
            if (current.value < 0) {
                count++;
            }
            current = current.next; // Move to the next item in the list
        }

        return count;
    }
}