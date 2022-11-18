import java.util.Timer;
import java.util.TimerTask;

public class Time {
    public static void main(String[] args){

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            int num = 10;
            @Override
            public void run() {
                if (num > 0) {
                    System.out.println("Timer is so funnnn ");
                    num --;
                } else {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
