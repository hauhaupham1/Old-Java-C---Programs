//Hau Pham
//Program 7: Binary Tree and methods that use O(logN) and a NBA Player table. 


import java.util.Scanner;

public class program7 {
    static Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the program!");
        System.out.println("This program create a table of NBA Player and let you \n" +
                "manipulate it");
        Table NBAPlayers = new Table();
        char again = 'y';
        int selection;
        do {
            System.out.println("Menu");
            System.out.println("1. initialize - initialize an empty table.\n" +
                    "2. Insert - insert a player in the table, given the item.\n" +
                    "3. Search - given a key, return the associated data item.\n" +
                    "4. Get Height - return the height of the tree.\n" +
                    "5. Get Size - return the number of nodes in the tree.\n" +
                    "6. ShowTree - display the contents of the tree in a tree-like fashion\n" +
                    "7. Display the entire contents of the table in order by their keys.");
            System.out.print("Your choice: ");
            selection = kb.nextInt();
            if (selection == 1){
                NBAPlayers = new Table();
                System.out.println("Done");
            } else if (selection == 2){
                NBAPlayer newPlayer = createNewPlayer();
                NBAPlayers.insert(newPlayer);
                System.out.println("Done");
            } else if (selection == 3){
                NBAPlayerKey newKey = createNBAPlayerKey();
                NBAPlayer searchedPlayer = (NBAPlayer) NBAPlayers.search(newKey);
                if (searchedPlayer!=null){
                    System.out.println("Associated Data with the key: " + searchedPlayer.briefSummary());
                    System.out.println("Done");
                }else {
                    System.out.println("No data found");
                }
            } else if (selection == 4){
                System.out.println("Height of the tree: " + NBAPlayers.getHeight());
            } else if (selection == 5){
                System.out.println("Number of nodes of the tree: " + NBAPlayers.numOfNode());
            } else if (selection == 6){
                NBAPlayers.showTree();
                System.out.println("Done");
            } else if (selection == 7){
                System.out.println("Contents of the tree: ");
                System.out.println(NBAPlayers.toString());
                System.out.println("Done");
            }
            else {
                System.out.println("Invalid choice");
            }
            System.out.print("Do you want to do anything else?(y/n) :");
            again = kb.next().charAt(0);
        }while (again == 'y' || again == 'Y');

    }
    private static NBAPlayer createNewPlayer(){
        System.out.print("Enter jersey number: ");
        int jerseyNumber = kb.nextInt();
        kb.nextLine(); // Consume the newline character
        System.out.print("Enter team name: ");
        String teamName = kb.nextLine();
        System.out.print("Enter player name: ");
        String playerName = kb.nextLine();
        System.out.print("Enter points per game: ");
        double pointsPerGame = kb.nextDouble();
        return new NBAPlayer(jerseyNumber, teamName, playerName, pointsPerGame);
    }
    private static NBAPlayerKey createNBAPlayerKey() {
        System.out.print("Enter jersey number: ");
        int jerseyNumber = kb.nextInt();
        kb.nextLine(); // Consume the newline character
        System.out.print("Enter team name: ");
        String teamName = kb.nextLine();
        return new NBAPlayerKey(jerseyNumber, teamName);
    }
}
class Table{
    private Node _root;
    public Table(){
        _root = null;
    }
    public void insert(Keyed item){
        _root = insertRecursive(_root, item);
    }
    private Node insertRecursive(Node current, Keyed item){
        if (current == null){
            current = new Node(item);
        }else {
            int comp = item.keyComp(current.data);
            if (comp < 0) {
               current.left= insertRecursive(current.left, item);
            } else if (comp > 0) {
                current.right= insertRecursive(current.right, item);
            }
        }
        return current;
    }
    public Keyed search(Keyed key){
       return searchRecursive(_root, key);
    }
    private Keyed searchRecursive(Node current, Keyed key){

        if (current == null) {
            return null;  // not found
        }
        int comp = key.keyComp(current.data);
        if (comp ==0 ){
            return  current.data;
        } else if (comp > 0) {
            return searchRecursive(current.right, key);
        } else  {
            return searchRecursive(current.left, key);
        }
    }
    public int getHeight(){
        return getHeightRecursive(_root);
    }
    private int getHeightRecursive(Node current){
        if (current == null){
            return  0;
        }
        int left =  getHeightRecursive(current.left);
        int right = getHeightRecursive(current.right);
        if (left > right){
            return left + 1;
        } else {
            return right + 1;
        }
    }
    public int numOfNode(){      //getSize
       return numOfNodeRecursive(_root);
    }
    private int numOfNodeRecursive(Node current){
        //empty tree
        if (current == null){
            return 0;
        } else {
            int left = numOfNodeRecursive(current.left);
            int right = numOfNodeRecursive(current.right);
            return left + right + 1;
        }
    }
    public void showTree() {
        showTreeRecursive(_root, 0);
    }
    private void showTreeRecursive(Node current, int level) {
        if (current != null) {
           // System.out.println("Here");
            showTreeRecursive(current.right, level + 1);
            // indentation based on the level
            briefSummary(current.data, level);
            showTreeRecursive(current.left, level + 1);
        }
    }
    private void briefSummary(Keyed data, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(data.briefSummary());
    }

    public String toString() {
        return inorder_Recursive(_root);
    }
    private String inorder_Recursive(Node current) {
        if (current != null) {
            String s = "";
            s = s + inorder_Recursive(current.left);
            s = s + current.data + " ";
            s = s + inorder_Recursive(current.right)+"\n";

            return s;
        }
        return "";
    }
}
class Node{
    public Keyed data;
    public Node left;
    public Node right;
    public Node(Keyed item){
        data = item;
        left = right = null;
    }
}
interface Keyed{
    public int keyComp( Keyed other );
    public String briefSummary();
}
class NBAPlayerKey implements Keyed {
    private int jerseyNumber;
    private String teamName;

    public NBAPlayerKey(int _jerseyNumber, String _teamName) {
        jerseyNumber = _jerseyNumber;
        teamName = _teamName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getTeamName() {
        return teamName;
    }
    public int keyComp(Keyed other) {
        if (other instanceof NBAPlayer){
            NBAPlayerKey item = (NBAPlayerKey) other;
            if (teamName.equals(item.teamName) && jerseyNumber == item.jerseyNumber){
                return 0;
            } else if (teamName.equals(item.teamName) && jerseyNumber < item.jerseyNumber) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
    public String briefSummary() {
        return "Jersey Number: " + jerseyNumber + " Team Name: " + teamName.substring(0, 3);
    }
    public String toString(){
        return "Jersey Number: " + jerseyNumber + " Team Name: " + teamName;
    }
}
class NBAPlayer extends NBAPlayerKey implements Keyed {
    private String playerName;
    private double pointsPerGame;

    public NBAPlayer(int _jerseyNumber, String _teamName, String _playerName, double _pointsPerGame) {
        super(_jerseyNumber, _teamName);
        playerName = _playerName;
        pointsPerGame = _pointsPerGame;
    }
    public int keyComp(Keyed other){
        return super.keyComp(other);
    }

    public String getPlayerName() {
        return playerName;
    }

    public double getPointsPerGame() {
        return pointsPerGame;
    }
    public String briefSummary() {
        return super.briefSummary();
    }
    //toString method
    public String toString(){
        return super.toString() + " Player's Name: " + playerName + " Points per Game: " + pointsPerGame;
    }
}

public class YourBinaryTree extends BinaryTree {
    @Override
    protected int countLessThan(Comparable value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        return count(value, root);
    }

    protected int count(Comparable value, Node curr) {
        if (curr == null) {
            return 0;
        }

        if (curr.value.compareTo(value) > 0) {
            return 1 + count(value, curr.right) + count(value, curr.left);
        }

        return count(value, curr.right) + count(value, curr.left);
    }
}


