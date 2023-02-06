public class Square extends Shape {
	
    private double size;

    public Square(double size) {
        this.size = size;
    }

    public double area() {
        return size * size;
    }

    public String toString() {
        return "Square(size = " + size + ")";
    }
}
