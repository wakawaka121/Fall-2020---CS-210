
public class Tester {

    public static void main(String[] args) {
        Garden myGarden = new Garden(3, 3);
        myGarden.plant(0, 0, "OAK");
        myGarden.plant(0, 1, "GARLIC");
        myGarden.plant(0, 2, "ROSE");
        myGarden.plant(1, 0, "BANANA");
        myGarden.plant(1, 1, "YAM");
        myGarden.plant(1, 2, "ROSE");
        myGarden.plant(2, 0, "BANANA");
        myGarden.plant(2, 1, "GARLIC");
        myGarden.plant(2, 2, "TULIP");
        // myGarden.cutAt(0, 0);
        myGarden.pickName("rose");
        // myGarden.pickAt(2, 1);
        // myGarden.harvestAll();
        // // myGarden.cutAll();
        // // myGarden.pickAll();
        // // myGarden.growPlant(1, "VEGETABLE");
        // myGarden.growAt(1, 0, 0);
        // myGarden.growAll(1);
        // myGarden.growName(2, "garlic");
        // myGarden.growAt(1, 0, 0);
        // myGarden.growAt(1, 0, 0);
        // myGarden.growAt(1, 0, 0);
        // myGarden.growAt(1, 0, 0);
        // myGarden.growType(1, "BANANA");
        // myGarden.getPlot()[0][2].grow(1);
        // myGarden.getPlot()[0][2].print();
        // myGarden.getPlot()[0][1].grow(12312);
        // myGarden.getPlot()[0][1].print();
        // myGarden.getPlot()[0][0].grow(10012);
        // myGarden.getPlot()[0][0].print();
        // myGarden.printGarden();
        // myGarden.cutAt(0, 0);
        // myGarden.printGarden();
        // myGarden.pickAt(0, 2);
        // myGarden.printGarden();
        // myGarden.harvestAt(0, 1);
        // for (int i = 0; i < 3; i++) {
        // for (int j = 0; j < 3; j++) {
        // System.out.println(myGarden.getPlot().get(i).get(j));
        // }
        // }
        // myGarden.getPlot().get(0).get(0).printPlot();
        myGarden.print();

    }

}
