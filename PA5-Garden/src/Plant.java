
public class Plant {
    protected PlantType type;
    protected int row;
    protected int col;
    protected String[] cellGrid;
    
    protected Plant(PlantType type, int row, int col) {
        this.type = type;
        this.row = row;
        this.col = col;
        this.cellGrid = new String[5];
        for (int height = 0; height < 5; height++) {
            cellGrid[height] = ".....";
        }
    }
    
    public String getName() {
        return "";
    }

    public PlantType getType() {
        return type;
    }

    public String getPlotRow(int row) {
        return cellGrid[row];
    }

    public void grow(int size) {

    }

    public boolean getName(String type) {
        return false;
    }


}
