import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Garden {
    private Map<String, PlantType> plantType;
    // private List<ArrayList<Plant>> plots;
    private List<List<Plant>> plots;
    // private Plant[][] plots;
    private int maxRow;
    private int maxCol;

    public Garden(int row, int col) {
        plantType = new HashMap<String, PlantType>();
        for (TreeType name : TreeType.values()) {
            plantType.put(name.toString(), PlantType.TREE);
        }
        for (VegetableType name : VegetableType.values()) {
            plantType.put(name.toString(), PlantType.VEGETABLE);
        }
        for (FlowerType name : FlowerType.values()) {
            plantType.put(name.toString(), PlantType.FLOWER);
        }
        // for (PlantType name : PlantType.values()) {
        // plantType.put(name.toString(), PlantType.valueOf(name.toString()));
        // }
        plots = new ArrayList<List<Plant>>(row);
        for (int i = 0; i < row; i++) {
            ArrayList<Plant> plotRow = new ArrayList<Plant>();
            for (int width = 0; width < col; width++) {
                plotRow.add(new Plant(PlantType.UNPLANTED, i, width));
            }
            plots.add(plotRow);
        }
        // plots = new ArrayList<ArrayList<Plant>>(row);
        // for (int i = 0; i < row; i++) {
        // plots.add(new ArrayList<Plant>(col));
        // }
        // plots = new ArrayList<Plant>();
        // plots = new Plant[row][col];
        maxRow = row;
        maxCol = col;
    }

    public void print() {
        for (int row = 0; row < maxRow; row++) {
            for (int plotRow = 0; plotRow < 5; plotRow++) {
                String gardenLine = "";
                for (int col = 0; col < plots.get(row).size(); col++) {
                    Plant curPlot = plots.get(row).get(col);

                    gardenLine += curPlot.getPlotRow(plotRow);
                }
                System.out.println(gardenLine);
            }
        }
    }

    public boolean isPlantName(String name) {
        return plantType.containsKey(name.toUpperCase());
    }

    public void plant(int row, int col, String name) {
        String upperCaseName = name.toUpperCase();
        PlantType incomingType = plantType.get(upperCaseName);
        if (incomingType == PlantType.TREE) {
            Tree newTree = new Tree(row, col, TreeType.valueOf(upperCaseName));
            plots.get(row).set(col, newTree);
        } else if (incomingType == PlantType.FLOWER) {
            Flower newFlower = new Flower(row, col,
                    FlowerType.valueOf(upperCaseName));
            plots.get(row).set(col, newFlower);
        } else if (incomingType == PlantType.VEGETABLE) {
            Vegetable newVegetable = new Vegetable(row, col,
                    VegetableType.valueOf(upperCaseName));
            plots.get(row).set(col, newVegetable);
        }
    }
    
    public void growAll(int size) {
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                plots.get(row).get(col).grow(size);
            }
        }
    }

    public void growAt(int size, int row, int col) {
        if (row < maxRow && col < maxCol) {
            if (plots.get(row).get(col) instanceof Plant) {
                plots.get(row).get(col).grow(size);
            } else {
                System.out.println("Can't grow there.");
            }
        }
    }

    public void growType(int size, String type) {
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                Plant curPlot = plots.get(row).get(col);
                if (curPlot.getType().toString().equalsIgnoreCase(type)) {
                    curPlot.grow(size);
                }
            }
        }

    }

    public void growName(int size, String name) {
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                Plant curPlot = plots.get(row).get(col);
                if (curPlot.getName().equalsIgnoreCase(name)) {
                    curPlot.grow(size);
                }
            }
        }
    }

    public void cutAll() {
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                Plant curPlot = plots.get(row).get(col);
                if (curPlot.getType() == PlantType.TREE) {
                    plots.get(row).set(col,
                            new Plant(PlantType.UNPLANTED, row, col));
                }
            }
        }
    }

    public void cutAt(int row, int col) {
        if (row < maxRow && col < maxCol) {
            Plant curPlot = plots.get(row).get(col);
            if (curPlot.getType() == PlantType.TREE) {
                plots.get(row).set(col,
                        new Plant(PlantType.UNPLANTED, row, col));
            } else {
                System.out.println("Can't cut there.");
            }
        }
    }

    public void cutName(String name) {
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                Plant curPlot = plots.get(row).get(col);
                if (curPlot.getName().equalsIgnoreCase(name)) {
                    plots.get(row).set(col,
                            new Plant(PlantType.UNPLANTED, row, col));
                }
            }
        }
    }
    public void harvestAll() {
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                Plant curPlot = plots.get(row).get(col);
                if (curPlot.getType() == PlantType.VEGETABLE) {
                    plots.get(row).set(col,
                            new Plant(PlantType.UNPLANTED, row, col));
                }
            }
        }
    }

    public void harvestAt(int row, int col) {
        if (row < maxRow && col < maxCol) {
            Plant curPlot = plots.get(row).get(col);
            if (curPlot.getType() == PlantType.VEGETABLE) {
                plots.get(row).set(col,
                        new Plant(PlantType.UNPLANTED, row, col));
            } else {
                System.out.println("Can't harvest there.");
            }
        }
    }
    public void harvestName(String name) {
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                Plant curPlot = plots.get(row).get(col);
                if (curPlot.getName().equalsIgnoreCase(name)) {
                    plots.get(row).set(col,
                            new Plant(PlantType.UNPLANTED, row, col));
                }
            }
        }
    }
    
    public void pickAll() {
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                Plant curPlot = plots.get(row).get(col);
                if (curPlot.getType() == PlantType.FLOWER) {
                    plots.get(row).set(col,
                            new Plant(PlantType.UNPLANTED, row, col));
                }
            }
        }
    }

    public void pickAt(int row, int col) {
        if (row < maxRow && col < maxCol) {
            Plant curPlot = plots.get(row).get(col);
            if (curPlot.getType() == PlantType.FLOWER) {
                plots.get(row).set(col,
                        new Plant(PlantType.UNPLANTED, row, col));
            } else {
                System.out.println("Can't pick there.");
            }
        }
    }

    public void pickName(String name) {
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                Plant curPlot = plots.get(row).get(col);
                if (curPlot.getName().equalsIgnoreCase(name)) {
                    plots.get(row).set(col,
                            new Plant(PlantType.UNPLANTED, row, col));
                }
            }
        }
    }


}
