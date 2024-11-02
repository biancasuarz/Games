package SimpleCarRace;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position += (int) (Math.random() * 5);
    }
}

