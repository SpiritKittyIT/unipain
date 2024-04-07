import cards.Card;
import cards.Attack;

public class Main {

    public static void main(String[] args) {
        Card attBackhand = new Attack("Backhand slap", "Give your opponent a backhand slap dealing {d} damage and lowering their self esteem", 3);
        System.out.println(attBackhand.getDescription());
    }
}