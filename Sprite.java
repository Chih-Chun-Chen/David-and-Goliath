import javax.swing.*;

import java.awt.*;

public abstract class Sprite implements Drawable {

    //Fields
    protected Room currentRoom;
    protected ImageIcon image;

    //Constructor
    public Sprite(){
        currentRoom = null;
        image = null;
    }

    //Methods

    //Setter
    public void setCurrentRoom(Room r) {
        this.currentRoom = r;
    }

    //Getter
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public Room returnRoom(Room r){
        return r;
    }

    @Override
    public void draw(Graphics g){
        if (currentRoom != null){
            Point p = currentRoom.getPosition();
            image.paintIcon(null, g, p.x + 8, p.y + 8);
        }
    }

    public void moveSouth(){
        if (currentRoom.hasSouthExit() == true){
            currentRoom = currentRoom.getSouthExit();
        }
    }

    public void moveNorth(){
        if (currentRoom.hasNorthExit() == true){
            currentRoom = currentRoom.getNorthExit();
        }
    }

    public void moveEast(){
        if (currentRoom.hasEastExit() == true){
            currentRoom = currentRoom.getEastExit();
        }
    }

    public void moveWest(){
        if (currentRoom.hasWestExit() == true){
            currentRoom = currentRoom.getWestExit();
        }
    }
}