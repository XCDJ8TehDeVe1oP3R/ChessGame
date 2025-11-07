import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        JFrame window = new JFrame("Chess Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel game = new GamePanel();
        window.add(game);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        game.launchChess();
    }
}