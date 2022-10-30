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
        
    }

}
