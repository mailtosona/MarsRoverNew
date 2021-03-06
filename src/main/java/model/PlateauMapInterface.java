package model;

import java.util.List;

public interface PlateauMapInterface {

    void show(List<RoverDetails> rovers);

    void hide(boolean finish);

    boolean isMapVisible();
}
