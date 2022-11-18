import javax.swing.*;

public class David extends Sprite{
    //Number of stone for David
    private int numStone;
    public David(){
        super();
        image = new ImageIcon("david.png");
        numStone = 0;
    }

    //Methods
    public void pickUpStone(){
        numStone++;
    }
    public boolean isArmed(){
        switch (numStone){
            case 5:
                return true;
            default:
                return false;
        }
    }
    public void reset(){
        numStone = 0;
    }

}