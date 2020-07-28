package notegenerator;

import java.io.IOException;

/**
 * Tone generator and player.
 *
 * @author Cesar Vezga vcesar@yahoo.com
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Player player = new Player();

        player.play(BeachRock.getTack1(),BeachRock.getTack2());

    }
}