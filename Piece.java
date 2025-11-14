import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Piece {

    public BufferedImage image;
    public int x, y;
    public int col, row, preCol, preRow;
    public int color;
    public Piece hittingP;
    public boolean moved;

    public Piece(int color, int col, int row) {
        this.color = color;
        this.col = col;
        this.row = row;
        x = getX(col);
        y = getY(row);
        preCol = col;
        preRow = row;
    }

    public BufferedImage getImage(String imgPath) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(getClass().getResourceAsStream(imgPath + ".png"));
        } catch (IOException e) {
            System.err.println("Could'nt find image");
        }

        return img;
    }

    public int getX(int col) {
        return col * Board.SQR_SIZE;
    }

    public int getY(int row) {
        return row * Board.SQR_SIZE;
    }

    public int getCol(int x) {
        return (x + Board.HALF_SQR_SIZE) / Board.SQR_SIZE;
    }

    public int getRow(int y) {
        return (y + Board.HALF_SQR_SIZE) / Board.SQR_SIZE;
    }

    public void updatePosition() {
        x = getX(col);
        y = getY(row);
        preCol = getCol(x);
        preRow = getRow(y);
        moved = true;
    }

    public boolean canMove(int targetCol, int targetRow) {
        return false;
    }

    public boolean isWithinBoard(int targetCol, int targetRow) {
        return targetCol >= 0 && targetRow >= 0. && targetCol <= 7 && targetRow <= 7;
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(image, x, y, Board.SQR_SIZE, Board.SQR_SIZE, null);
    }

    public void resetPosition() {
        col = preCol;
        row = preRow;
        x = getX(col);
        y = getY(row);
    }

    public boolean isValidSquare(int tCol, int tRow) {
        hittingP = getHittingP(tCol, tRow);
        if(hittingP == null) {
            return true;
        } else {
            if(hittingP.color != this.color) {
            return true;
            } else {
                hittingP = null;
            }
        }
        return false;
    }

    public Piece getHittingP(int tCol, int tRow) {
        for(Piece p : GamePanel.simPieces) {
            if(p.col == tCol && p.row == tRow && p != this) {
                return p;
            }
        }
        return null;
    }

    public boolean isSameSquare(int tCol, int tRow) {
        return tCol == preCol && tRow == preRow;
    }

    public boolean pieceIsOnStraightLine(int targetCol, int targetRow) {
        for(int c = preCol -1; c > targetCol; c--) {
            for(Piece p : GamePanel.simPieces) {
                if(p.col == c && p.row == preRow) {
                    hittingP = p;
                    return true;
                }
            }
        }

        for(int c = preCol +1; c < targetCol; c++) {
            for(Piece p : GamePanel.simPieces) {
                if(p.col == c && p.row == preRow) {
                    hittingP = p;
                    return true;
                }
            }
        }
        for(int r = preRow -1; r > targetCol; r--) {
            for(Piece p : GamePanel.simPieces) {
                if(p.col == preCol && p.row == r) {
                    hittingP = p;
                    return true;
                }
            }
        }
        for(int r = preRow +1; r < targetCol; r++) {
            for(Piece p : GamePanel.simPieces) {
                if(p.col == preCol && p.row == r) {
                    hittingP = p;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean pieceIsOnDiagonalLine(int targetCol, int targetRow) {
        if(targetRow < preRow) {
            for(int c = preCol -1; c > targetCol; c--) {
                int diff = Math.abs(c - preCol);
                for(Piece p : GamePanel.simPieces) {
                    if(p.col == c && p.row == preRow - diff) {
                        hittingP = p;
                        return true;
                    }
                }
            }

            for(int c = preCol +1; c < targetCol; c++) {
                int diff = Math.abs(c - preCol);
                for(Piece p : GamePanel.simPieces) {
                    if(p.col == c && p.row == preRow - diff) {
                        hittingP = p;
                        return true;
                    }
                }
            }
        }

        if(targetRow > preRow) {
            for(int c = preCol -1; c > targetCol; c--) {
                int diff = Math.abs(c - preCol);
                for(Piece p : GamePanel.simPieces) {
                    if(p.col == c && p.row == preRow + diff) {
                        hittingP = p;
                        return true;
                    }
                }
            }

            for(int c = preCol +1; c < targetCol; c++) {
                int diff = Math.abs(c - preCol);
                for(Piece p : GamePanel.simPieces) {
                    if(p.col == c && p.row == preRow + diff) {
                        hittingP = p;
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public int getIndex() {
        for(int i = 0; i < GamePanel.pieces.size(); i++) {
            if(GamePanel.pieces.get(i) == this) {
                return i;
            }
        }
        return 0;
    }
}
