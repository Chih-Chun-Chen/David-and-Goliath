import java.util.ArrayList;
import java.util.Random;

public class RandomNum {

    public static void main(String[] args){
        /*//Select Eight random number without duplicate between 0 and 50
        ArrayList list = getRandomNonRepeatingIntegers(7, 0, 32);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("" + list.get(i));
        }*/
    }

    //Get selected size number without duplicate
    public ArrayList getRandomNonRepeatingIntegers(int size, int min, int max) {
        ArrayList numbers = new ArrayList();
        Random random = new Random();
        while (numbers.size() < size) {
            //Get Random numbers between range
            int randomNumber = random.nextInt((max - min) + 1) + min;
            //Check for duplicate values
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }
    }
