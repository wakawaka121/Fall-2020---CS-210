import java.util.ArrayList;
import java.util.List;

public class Flower extends Plant {
    
    private FlowerType name;
    private List<String> growPattern;

    public Flower(int row, int col, FlowerType name) {
        super(PlantType.FLOWER, row, col);
        this.name = name;
        growPattern = new ArrayList<String>();
        String flowerInitial = name.toString().substring(0, 1).toLowerCase();
        growPattern.add(".....");
        growPattern.add(String.format("..%s..", flowerInitial));
        growPattern.add(String.format(".%s%s%s.", flowerInitial, flowerInitial,
                flowerInitial));
        growPattern.add(String.format("%s%s%s%s%s", flowerInitial,
                flowerInitial, flowerInitial, flowerInitial, flowerInitial));
        this.cellGrid[2] = ".." + flowerInitial + "..";
    }
    
    public void grow(int size) {
        int grow = 0;
        while (grow < size) {

            for (int i = 0; i < 3; i++) {
                int stage = growPattern.indexOf(cellGrid[i]);
                int maxStage = 3;
                int realStage = stage + 1;
                if (realStage > maxStage) {
                    realStage = maxStage;
                }
                if (!cellGrid[i + 1].equals(growPattern.get(0)) || i == 2) {

                    cellGrid[i] = growPattern.get(realStage);
            }

        }
        for (int i = 4; i > 2; i--) {
            int stage = growPattern.indexOf(cellGrid[i]);
            int maxStage = 3;
            int realStage = stage + 1;
            if (realStage > maxStage) {
                realStage = maxStage;
            }
            if (!cellGrid[i - 1].equals(growPattern.get(0))) {
                cellGrid[i] = growPattern.get(realStage);
            }
        }
        grow++;
    }
    }

    @Override
    public String getName() {
        return name.toString();
    }
}

