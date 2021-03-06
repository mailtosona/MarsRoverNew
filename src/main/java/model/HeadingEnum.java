package model;

public enum HeadingEnum {
    NORTH ('N', "WEST", "EAST"),
    EAST ('E', "NORTH",  "SOUTH"),
    SOUTH ('S', "EAST", "WEST"),
    WEST ('W', "SOUTH", "NORTH");

    private final char headingInitial;
    private final String headingLeft;
    private final String headingRight;

    HeadingEnum(char headingInitial, String headingLeft, String headingRight) {
        this.headingInitial = headingInitial;
        this.headingLeft = headingLeft;
        this.headingRight = headingRight;
    }

    public char getHeadingInitial() {
        return this.headingInitial;
    }

    public static HeadingEnum getByInitial(char headingInitial) {
        HeadingEnum heading;
        switch (headingInitial) {
            case 'N' -> heading = HeadingEnum.NORTH;
            case 'S' -> heading = HeadingEnum.SOUTH;
            case 'E' -> heading = HeadingEnum.EAST;
            case 'W' -> heading = HeadingEnum.WEST;
            default -> throw new IllegalArgumentException("Invalid heading initial");
        }
        return heading;
    }

    public HeadingEnum getNewHeading(DirectionEnum direction) {
        HeadingEnum newHeading;
        if (direction == DirectionEnum.LEFT) {
            newHeading = HeadingEnum.valueOf(this.headingLeft);
        }
        else {
            newHeading = HeadingEnum.valueOf(this.headingRight);
        }
        return newHeading;
    }
}
