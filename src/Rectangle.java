public class Rectangle{
    private double width;
    private double height;
    private int id;
    private static int idGen;
    public Rectangle(){
        width = 1.0;
        height = 1.0;
        id = idGen++;
    }

    public Rectangle(double width , double height){
        this();
        setWidth(width);
        setHeight(height);
    }

    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        if ( width > 0 ){
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        if ( height > 0 ){
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height  must be greater than 0");
        }
    }
    public double area(){
        return width * height;
    }

    public double perimeter(){
        return 2 * (width + height);
    }

    @Override
    public String toString(){
        return "Rectangle{id=" + id + ", width=" + width + ", height=" + height + "}";


    }

}
