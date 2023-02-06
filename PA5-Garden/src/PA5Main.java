import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PA5Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(args[0]));
        String rowAsString = scanner.nextLine().split(" ")[1];
        String colAsString = scanner.nextLine().split(" ")[1];
        scanner.nextLine();
        if (Integer.valueOf(colAsString) < 17) {
        Garden myGarden = new Garden(Integer.valueOf(rowAsString),
                Integer.valueOf(colAsString));
        while (scanner.hasNext()) {
            String[] lineInfo = scanner.nextLine().split(" ");
            if (lineInfo[0].equalsIgnoreCase("plant")) {
                plantCommand(lineInfo, myGarden);
            } else if (lineInfo[0].equalsIgnoreCase("print")) {
                myGarden.print();
            }else if (lineInfo[0].equalsIgnoreCase("grow")) {
                growCommand(lineInfo, myGarden);
                
            }else if(lineInfo[0].equalsIgnoreCase("harvest")) {
                harvestCommand(lineInfo, myGarden);
                
            }else if(lineInfo[0].equalsIgnoreCase("pick")) {
                pickCommand(lineInfo, myGarden);
                
            } else if (lineInfo[0].equalsIgnoreCase("cut")) {
                cutCommand(lineInfo, myGarden);

            }

        }
    } else {
        System.out.println("Too many plot columns.");

    }
}

    public static void plantCommand(String[] lineInfo, Garden myGarden) {
        String[] cordinates = lineInfo[1].split(",");
        int row = Integer.valueOf(cordinates[0].replaceAll("\\(", ""));
        int col = Integer.valueOf(cordinates[1].replaceAll("\\)", ""));
        myGarden.plant(row, col, lineInfo[2]);

    }

    public static void growCommand(String[] lineInfo, Garden myGarden) {
        int size = Integer.valueOf(lineInfo[1]);
        if (lineInfo.length == 2) {
            myGarden.growAll(size);
        } else if (lineInfo[2].contains("(")) {
            String[] cordinates = lineInfo[2].split(",");
            int row = Integer.valueOf(cordinates[0].replaceAll("\\(", ""));
            int col = Integer.valueOf(cordinates[1].replaceAll("\\)", ""));
            myGarden.growAt(size, row, col);
        } else if (myGarden.isPlantName(lineInfo[2])) {
            myGarden.growName(size, lineInfo[2]);
        } else {
            myGarden.growType(size, lineInfo[2]);
        }

    }

    public static void harvestCommand(String[] lineInfo, Garden myGarden) {
        if (lineInfo.length == 1) {
            myGarden.harvestAll();
        } else if (lineInfo[1].contains("(")) {
            String[] cordinates = lineInfo[1].split(",");
            int row = Integer.valueOf(cordinates[0].replaceAll("\\(", ""));
            int col = Integer.valueOf(cordinates[1].replaceAll("\\)", ""));
            myGarden.harvestAt(row, col);
        } else {
            myGarden.harvestName(lineInfo[1]);
        }

    }

    public static void pickCommand(String[] lineInfo, Garden myGarden) {
        if (lineInfo.length == 1) {
            myGarden.pickAll();
        } else if (lineInfo[1].contains("(")) {
            String[] cordinates = lineInfo[1].split(",");
            int row = Integer.valueOf(cordinates[0].replaceAll("\\(", ""));
            int col = Integer.valueOf(cordinates[1].replaceAll("\\)", ""));
            myGarden.pickAt(row, col);
        } else {
            myGarden.pickName(lineInfo[1]);
        }
    }

    public static void cutCommand(String[] lineInfo, Garden myGarden) {
        if (lineInfo.length == 1) {
            myGarden.cutAll();
        } else if (lineInfo[1].contains("(")) {
            String[] cordinates = lineInfo[1].split(",");
            int row = Integer.valueOf(cordinates[0].replaceAll("\\(", ""));
            int col = Integer.valueOf(cordinates[1].replaceAll("\\)", ""));
            myGarden.cutAt(row, col);
        } else {
            myGarden.cutName(lineInfo[1]);
        }
    }

}