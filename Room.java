import java.awt.*;

public class Room implements Drawable {
    //Fields
    private Point pos;
    private Room exitEast;
    private Room exitWest;
    private Room exitNorth;
    private Room exitSouth;
    public static final int SIZE = 50;


    //Constructor
    public Room(int x, int y){
        pos = new Point(x, y);
    }

    //Method
    @Override
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.drawRect(pos.x, pos.y, SIZE, SIZE);
        //East
        if (exitEast != null){
            g.setColor(Color.GRAY);
            g.drawLine(pos.x + SIZE, pos.y + 20, pos.x + SIZE, pos.y + 30 );
            g.setColor(Color.BLUE);
            g.drawLine(pos.x + SIZE, pos.y + 20, pos.x + 60, pos.y + 20 );
            g.drawLine(pos.x + SIZE, pos.y + 30, pos.x + 60, pos.y + 30 );
        }

        //West
        if(exitWest !=null){
            g.setColor(Color.GRAY);
            g.drawLine(pos.x, pos.y + 20, pos.x, pos.y + 30);
        }

        //North
        if (exitNorth != null){
            g.setColor(Color.GRAY);
            g.drawLine(pos.x + 20, pos.y, pos.x + 30, pos.y);
        }

        //South
        if (exitSouth != null){
            g.setColor(Color.GRAY);
            g.drawLine(pos.x + 20, pos.y + SIZE  , pos.x + 30,  pos.y + SIZE);
            g.setColor(Color.BLUE);
            g.drawLine(pos.x + 20, pos.y + SIZE  , pos.x + 20,  pos.y + 60);
            g.drawLine(pos.x + 30, pos.y + SIZE  , pos.x + 30,  pos.y + 60);

        }
    }

    public void setEastExist(Room r){
        exitEast = r;
        r.exitWest = this;
    }

    public void setNorthExist(Room r){
        exitNorth = r;
        r.exitSouth = this;
    }

    public void setWestExist(Room r){
        exitWest = r;
        r.exitEast = this;
    }

    public void setSouthExist(Room r){
        exitSouth = r;
        r.exitNorth = this;
    }

    public Point getPosition() {
        return pos;
    }

    public boolean hasNorthExit(){
        if (exitNorth == null){
            return false;
        } else{
            return true;
        }
    }

    public boolean hasSouthExit(){
        if (exitSouth == null){
            return false;
        } else{
            return true;
        }
    }

    public boolean hasEastExit(){
        if (exitEast == null){
            return false;
        } else{
            return true;
        }
    }

    public boolean hasWestExit(){
        if (exitWest == null){
            return false;
        } else{
            return true;
        }
    }

    public Room getNorthExit(){
        return exitNorth;
    }

    public Room getSouthExit(){
        return exitSouth;
    }

    public Room getEastExit(){
        return exitEast;
    }

    public Room getWestExit(){
        return exitWest;
    }
}