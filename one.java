
class rectangle extends shape{
    public rectangle(int width,int height){
        super(width, height);
    }
    void printArea(){
        System.out.println("Area Rectangle:"+(width*height));
    }
}

class triangle extends shape{
    public triangle(int width,int height){
        super(width, height);
    }
    void printArea(){
        System.out.println("Area Triangle:"+((width*height)/2));
    }
}

class circle extends shape{
    private final double pi=3.141;
    private int radius;

    public circle(int radius){
        super(radius,radius);
        this.radius = radius;
    }
    void printArea(){
        System.out.println("Area circle:"+(pi*radius*radius));
    }
}


public class one{
    public static void main(String[] args){
        shape rec=new rectangle(5, 4);
        shape tri=new triangle(6, 8);
        shape cir=new circle(3);

        rec.printArea();
        tri.printArea();
        cir.printArea();



    }
}

