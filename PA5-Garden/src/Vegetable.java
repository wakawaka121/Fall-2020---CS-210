
public class Vegetable extends Plant {

    private VegetableType name;
    private int vegetableLength;


    public Vegetable(int row, int col, VegetableType name) {
        super(PlantType.VEGETABLE, row, col);
        this.name = name;
        this.vegetableLength = 0;
        this.cellGrid[0] = ".." + name.toString().substring(0, 1).toLowerCase()
                + "..";
    }

    public void grow(int size) {
        int growth = 0;
        String rowWithPlant = cellGrid[0];
        while (growth < size && vegetableLength < 4) {
            vegetableLength = vegetableLength + 1;
            growth++;
            cellGrid[vegetableLength] = rowWithPlant;
        }
    }


    @Override
    public String getName() {
        return name.toString();
    }
}
