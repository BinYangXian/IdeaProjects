package castle;

public class Room {
    private String description;
    
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    public void setExits(Room north, Room east, Room south, Room west) {
        if (north != null)
            northExit = north;
        if (east != null)
            eastExit = east;
        if (south != null)
            southExit = south;
        if (west != null)
            westExit = west;
    }

    public String getExitDesc() {
        StringBuffer sb = new StringBuffer();
        if (northExit != null) {
            sb.append("north ");
        }
        if (eastExit != null) {
            sb.append("east ");
        }
        if (southExit != null) {
            sb.append("south ");
        }
        if (westExit != null) {
            sb.append("west ");
        }
        return sb.toString();
    }

    public Room getExit(String description) {
        Room ret = null;
        if (description.equals("north")) {
            ret = northExit;
        }
        if (description.equals("east")) {
            ret = eastExit;
        }
        if (description.equals("south")) {
            ret = southExit;
        }
        if (description.equals("west")) {
            ret = westExit;
        }
        return ret;
    }

    public Room(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
