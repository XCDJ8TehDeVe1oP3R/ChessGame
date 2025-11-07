
import java.awt.Color;
import java.awt.Graphics2D;

public class Board {
    final int MAX_COL = 8;
    final int MAX_ROW = 8;

    public static final int SQR_SIZE = 100;
    public static final int HALF_SQR_SIZE = SQR_SIZE / 2;

    public void draw(Graphics2D g2) {
        int c = 0;
        Color lightColor = new Color(0xfcdcbb);
        Color darkColor = new Color(0x9c5407);
        for(int col = 0; col < MAX_COL; col++) {
            for(int row = 0; row < MAX_ROW; row++) {
                int x = col * SQR_SIZE;
                int y = row * SQR_SIZE;

                if((col + row) % 2 == 0) {
                    g2.setColor(lightColor);
                    c = 1;
                } else {
                    g2.setColor(darkColor);
                    c = 0;
                }
                g2.fillRect(x, y, SQR_SIZE, SQR_SIZE);
            }

            if(c == 0) {
                c = 1;
            } else {
                c = 0;
            }
        }
    }
}
