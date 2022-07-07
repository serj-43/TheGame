import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    Player player1 = new Player(1, "Sergey", 10);
    Player player2 = new Player(2, "Roman", 6);
    Player player3 = new Player(3, "Fedor", 8);
    Player player4 = new Player(4, "Danila", 9);
    Player player5 = new Player(5, "Max", 3);
    Player player6 = new Player(6, "Leha", 20);
    Player player7 = new Player(7, "Vitek", 10);

    @Test
    public void FirstWinTest() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Sergey", "Roman");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondWinTest() {
        Game game = new Game();
        game.register(player6);
        game.register(player1);
        int actual = game.round("Sergey", "Leha");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EqualTest() {
        Game game = new Game();
        game.register(player1);
        game.register(player7);
        int actual = game.round("Vitek", "Sergey");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ErrorThrowTest2() {
        Game game = new Game();
        game.register(player2);
        game.register(player5);
        game.deleteById(5);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Roman", "Max");
        });
    }

    @Test
    public void ErrorThrowTest1() {
        Game game = new Game();
        game.register(player3);
        game.register(player4);
        game.deleteById(3);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Fedor", "Danila");
        });
    }
}
