abstract class shape {
    protected int width;
    protected int height;

    public shape(int width,int height){
        this.width=width;
        this.height=height;

    }
    abstract void printArea();
}
