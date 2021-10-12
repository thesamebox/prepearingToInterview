package ru.geekbrains.prepearingToInterview.lesson1;

public class Polymorphism {
    public static void main(String[] args) {
        Figure t = new Triangle();
        System.out.println(t.angle);

        Figure c = new Circle();
        System.out.println(c.angle);

        Figure r = new Rectangle();
        System.out.println(r.angle);
    }


}
abstract class Figure {
    int angle;
}

class Triangle extends Figure {

    public Triangle() {
        super.angle = 3;
    }
}

class Circle extends Figure {

    public Circle() {
        super.angle = 0;
    }
}

class Rectangle extends Figure {

    public Rectangle() {
        super.angle = 4;
    }
}