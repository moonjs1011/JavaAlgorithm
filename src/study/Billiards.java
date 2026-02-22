package study;

public class Billiards {
    public static void main(String[] args) {
        double []start = {1,1};
        double []end  = {3,3};
        double r = Math.sqrt(Math.pow(start[0]-end[0],2) + Math.pow(start[1]-end[1],2)); // 힘의 세기

        double theta = Math.atan(end[1]-start[1]/end[0]-start[0]);

        System.out.println("R : "+r +"\t theta [radian]: "+theta);
        System.out.println("R : "+r +"\t theta [degrees]: "+Math.toDegrees(theta));

        System.out.println(180/Math.PI);

    }
}
