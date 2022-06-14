package ss6_ke_thua.bai_tap.bai_3;

public class Point {
    float x;
    float y;

    public Point() {

    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        return new float[] {this.x, this.y};
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
