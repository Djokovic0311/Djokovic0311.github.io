import java.io.File;
import java.util.Scanner;

public class Utils {
    private final Scanner myScanner;

    public Utils(Scanner myScanner) {
        this.myScanner = myScanner;
    }

    public void printFile(String filePath){
        StringBuilder toPrint = new StringBuilder();
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(System.in);
        try{
            fileScanner = new Scanner(file);
        }
        catch (Exception e){
            System.out.println("File not found");
        }
        int count=0;
        while(fileScanner.hasNextLine()){
            if(count>0){
                toPrint.append(" (").append(count).append(") ");
            }
            toPrint.append(fileScanner.nextLine());
            toPrint.append("\n");
            count++;
        }
        fileScanner.close();
        System.out.println(toPrint);
    }

    //get a specific line
    public String getFileLine(int lineNumber, String filePath){
        String output = "";
        File file = new File(filePath);
        Scanner fileScannner = new Scanner(System.in);
        try{
            fileScannner = new Scanner(file);
        }
        catch (Exception e){
            System.out.println("File not found.");
            int count=0;
            while(fileScannner.hasNextLine()){
                output = fileScannner.nextLine();
                if(count == lineNumber){
                    break;
                }
                count++;
            }
        }
        fileScannner.close();
        return output;
    }
    public int getFileLength(String filePath) {
        String line;
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(System.in);
        try {
            fileScanner = new Scanner(file);
        }
        catch (Exception e){
            System.out.println("File not found");
        }
        int count=0;
        while (fileScanner.hasNextLine()){
            line= fileScanner.nextLine();
            count++;
        }
        fileScanner.close();
        return count;
    }

    public int numLines(String filePath){
        int count = 0;
        try{
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("error reading from file");
        }
        return count;
    }

    //get integer input within min and max range
    public int getIntInput(int min, int max){
        int input;
        do{
            while(!myScanner.hasNextInt()){
                System.out.println("Please enter an Integer");
                myScanner.next();
            }
            input = myScanner.nextInt();
            if(input > max || input < min){
                System.out.println("Invalid input. Please try again");
            }
        } while(input > max || input < min);
        return input;
    }

    //get single char input from scanner and return as a String
    public String getCharInput(){
        String input;
        int count=0;
        do{
            if(count>0){
                System.out.println("Wrong input. Try again.");
            }
            input = "";
            input += myScanner.next().charAt(0);
            input = input.toUpperCase();
            count++;
        } while(!(input.equals("W") || input.equals("A") || input.equals("S") || input.equals("D") || input.equals("I")
                || input.equals("Q") || input.equals("E") || input.equals("M")));
        return input;
    }

}
