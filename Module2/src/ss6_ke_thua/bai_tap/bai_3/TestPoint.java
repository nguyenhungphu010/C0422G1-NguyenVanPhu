package ss6_ke_thua.bai_tap.bai_3;

public class TestPoint {
    public static void main(String[] args) {
        Point point1 = new MoveablePoint(1,2,3,4); 
        ((MoveablePoint)point1).move();
        System.out.println(point1);
    }
}