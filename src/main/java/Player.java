import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player implements Comparable<Player>{

    private int id;
    private String name;
    private int strength;

    @Override
    public int compareTo(Player player) {
        if (strength > player.strength) {
            return 1;
        }
        else if (strength < player.strength) {
            return 2;
        }
        else return 0;
    }
}
