import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class MainDG extends JPanel implements KeyListener {

    static David d;
    static Goliath gl;
    ArrayList<Stone> st;
    static ArrayList<Room> rooms;
    ArrayList<Drawable> dra;

    ArrayList list;

    RandomNum randomNum = new RandomNum();


    public static void main(String[] args){
        //window
        var window = new JFrame();
        window.setSize(450, 450);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new MainDG());
        window.setVisible(true);


        }

    //Constructor
    public MainDG(){
        rooms = new ArrayList<>();
        st = new ArrayList<>();
        dra = new ArrayList<>();

        //Instantiation
        //Room
        //00 - 04
        rooms.add(new Room(60, 60));
        rooms.add(new Room(120, 60));
        rooms.add(new Room(180, 60));
        rooms.add(new Room(240, 60));
        rooms.add(new Room(300, 60));
        //10 -14
        rooms.add(new Room(60, 120));
        rooms.add(new Room(120, 120));
        rooms.add(new Room(180, 120));
        rooms.add(new Room(240, 120));
        rooms.add(new Room(300, 120));
        //20 - 24
        rooms.add(new Room(60, 180));
        rooms.add(new Room(120, 180));
        rooms.add(new Room(180, 180));
        rooms.add(new Room(240, 180));
        rooms.add(new Room(300, 180));
        //30 - 34
        rooms.add(new Room(60, 240));
        rooms.add(new Room(120, 240));
        rooms.add(new Room(180, 240));
        rooms.add(new Room(240, 240));
        rooms.add(new Room(300, 240));
        //40 - 44
        rooms.add(new Room(60, 300));
        rooms.add(new Room(120, 300));
        rooms.add(new Room(180, 300));
        rooms.add(new Room(240, 300));
        rooms.add(new Room(300, 300));

        //Set exist of Rooms
        rooms.get(0).setEastExist(rooms.get(1));
        rooms.get(0).setSouthExist(rooms.get(5));
        rooms.get(1).setEastExist(rooms.get(2));
        rooms.get(2).setEastExist(rooms.get(3));
        rooms.get(3).setSouthExist(rooms.get(8));
        rooms.get(4).setSouthExist(rooms.get(9));
        rooms.get(6).setSouthExist(rooms.get(11));
        rooms.get(7).setSouthExist(rooms.get(12));
        rooms.get(7).setEastExist(rooms.get(8));
        rooms.get(8).setEastExist(rooms.get(9));
        rooms.get(5).setSouthExist(rooms.get(10));
        rooms.get(6).setSouthExist(rooms.get(11));
        rooms.get(9).setSouthExist(rooms.get(14));
        rooms.get(12).setEastExist(rooms.get(13));
        rooms.get(13).setEastExist(rooms.get(14));
        rooms.get(10).setSouthExist(rooms.get(15));
        rooms.get(11).setSouthExist(rooms.get(16));
        rooms.get(13).setSouthExist(rooms.get(18));
        rooms.get(16).setEastExist(rooms.get(17));
        rooms.get(18).setEastExist(rooms.get(19));
        rooms.get(15).setSouthExist(rooms.get(20));
        rooms.get(16).setSouthExist(rooms.get(21));
        rooms.get(17).setSouthExist(rooms.get(22));
        rooms.get(19).setSouthExist(rooms.get(24));
        rooms.get(20).setEastExist(rooms.get(21));
        rooms.get(22).setEastExist(rooms.get(23));
        rooms.get(23).setEastExist(rooms.get(24));

        //Instantiation
        //Stone
        st.add(new Stone());
        st.add(new Stone());
        st.add(new Stone());
        st.add(new Stone());
        st.add(new Stone());

        //David
        d = new David();

        //Goliath
        gl = new Goliath();


        //Set the random location of Sprite
        list = randomNum.getRandomNonRepeatingIntegers(7, 0, 24);
        st.get(0).setCurrentRoom(rooms.get((Integer) list.get(0)));
        st.get(1).setCurrentRoom(rooms.get((Integer) list.get(1)));
        st.get(2).setCurrentRoom(rooms.get((Integer) list.get(2)));
        st.get(3).setCurrentRoom(rooms.get((Integer) list.get(3)));
        st.get(4).setCurrentRoom(rooms.get((Integer) list.get(4)));

        d.setCurrentRoom(rooms.get((Integer) list.get(5)));

        gl.setCurrentRoom(rooms.get((Integer) list.get(6)));


        //Add all the Room and sprite to Drawable ArrayList
        dra.addAll(rooms);
        dra.addAll(st);

        dra.add(d);

        dra.add(gl);


        //KeyListener
        addKeyListener(this);
    }

    //Methods
    @Override
    public void paintComponent(Graphics g){
        requestFocusInWindow();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 650, 650);

        for (Drawable draweach : dra){
            draweach.draw(g);
        }

        //Timer
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (gl.currentRoom != d.currentRoom) {
                    ArrayList<Room> randomMove = new ArrayList<>();
                    if (gl.currentRoom.hasNorthExit()) {
                        randomMove.add(gl.currentRoom.getNorthExit());
                    }
                    if (gl.currentRoom.hasSouthExit()) {
                        randomMove.add(gl.currentRoom.getSouthExit());
                    }
                    if (gl.currentRoom.hasWestExit()) {
                        randomMove.add(gl.currentRoom.getWestExit());
                    }
                    if (gl.currentRoom.hasEastExit()) {
                        randomMove.add(gl.currentRoom.getEastExit());
                    }
                    int ranNum = (int) (Math.random() * randomMove.size());
                    gl.setCurrentRoom(randomMove.get(ranNum));
                    repaint();

                } else if (gl.currentRoom == d.currentRoom) {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000000000 );
    }


    private void reset(){
        //Reset the location of stone
        list = randomNum.getRandomNonRepeatingIntegers(7, 0, 24);
        st.get(0).setCurrentRoom(rooms.get((Integer) list.get(0)));
        st.get(1).setCurrentRoom(rooms.get((Integer) list.get(1)));
        st.get(2).setCurrentRoom(rooms.get((Integer) list.get(2)));
        st.get(3).setCurrentRoom(rooms.get((Integer) list.get(3)));
        st.get(4).setCurrentRoom(rooms.get((Integer) list.get(4)));

        //Reset David
        d.reset();
        d.setCurrentRoom(rooms.get((Integer) list.get(5)));

        //Reset Goliath
        gl.setCurrentRoom(rooms.get((Integer) list.get(6)));
    }


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        switch (k) {
            //case KeyEvent.VK_W -> gl.moveNorth();
            case KeyEvent.VK_UP -> d.moveNorth();
            //case KeyEvent.VK_S -> gl.moveSouth();
            case KeyEvent.VK_DOWN -> d.moveSouth();
            //case KeyEvent.VK_A -> gl.moveWest();
            case KeyEvent.VK_LEFT -> d.moveWest();
            //case KeyEvent.VK_D -> gl.moveEast();
            case KeyEvent.VK_RIGHT -> d.moveEast();
        }
        //David pickUp stone
        for (Stone st1 : st){
            if (d.currentRoom == st1.currentRoom){
                d.pickUpStone();
                st1.currentRoom = null;
            }
        }
        if (d.currentRoom == gl.currentRoom && gl.currentRoom == d.currentRoom){
            if (d.isArmed()){
                JOptionPane.showMessageDialog(null, "Congratulations David! You slew Goliath!");
            } else{
                JOptionPane.showMessageDialog(null, "Oh no!!! You make Goliath rewrite the history of bible!!!");
            }
            d.reset();
            reset();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}


    public int randomNum(){
        int randomPos = (int)(Math.random() * 32 + 1);
        return randomPos;
    }
}