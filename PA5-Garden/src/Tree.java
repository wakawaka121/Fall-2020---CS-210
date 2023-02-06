
public class Tree extends Plant {
    private TreeType name;
    private int treeHeight;


    public Tree(int row, int col, TreeType name) {
        super(PlantType.TREE, row, col);
        this.name = name;
        this.treeHeight = 4;
        this.cellGrid[4] = ".." + name.toString().substring(0, 1).toLowerCase()
                + "..";
    }

    public void grow(int size) {
        int growth = 0;
        String rowWithPlant = cellGrid[4];
        while (growth < size && treeHeight >= 1) {
            treeHeight = treeHeight - 1;
            growth++;
            cellGrid[treeHeight] = rowWithPlant;
        }
    }

    @Override
    public String getName() {
        return name.toString();
    }
}
