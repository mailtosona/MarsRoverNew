package model;

public interface Navigator {
    String getLocation();

    void spin(NASACapcom callingCapcom, DirectionEnum spinDirection);

    void move(NASACapcom callingCapcom);
}
