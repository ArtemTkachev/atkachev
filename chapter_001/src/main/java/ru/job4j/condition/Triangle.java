package ru.job4j.condition;

public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double distance(Point left, Point right) {
        return (Math.sqrt(Math.pow(right.getX() - left.getX(),2) + Math.pow(right.getY() - left.getY(),2)));
    }

    public double perimeterh(double ac, double bc, double ab) {
        return (ac + bc + ab)/2;
    }

    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.perimeterh(ac, bc, ab);
        if (this.exist(ab,ac,bc)) {
            rsl = Math.sqrt(p *(p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    private boolean exist(double ab, double ac, double bc) {
        if (ab+ac>bc && ab+bc>ac && ac+bc>ab)
            return true;
        else
            return false;
    }

}