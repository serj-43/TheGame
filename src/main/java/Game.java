import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Game {

    private Collection<Player> games;

    public Game() {
        this.games = new ArrayList<>();
    }

    public void register(Player player) {
        games.add(player);
    }

    public void deleteById(int id) {
        games.removeIf(element -> element.getId() == id);
    }

    public boolean matches(Player player, String search) {
        return player.getName().equals(search);
    }


    public Player findByName(String name) {
        for (Player player : games) {
            if (matches(player, name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (this.findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }
        if (this.findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }

        int str1 = this.findByName(playerName1).getStrength();
        int str2 = this.findByName(playerName2).getStrength();

        if (str1 > str2) {
            return 1;
        } else if (str1 < str2) {
            return 2;
        } else {
            return 0;
        }
    }
}
