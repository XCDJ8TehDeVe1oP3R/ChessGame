public class Knight extends Piece {
    public Knight(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE) {
            image = getImage("/piece/w-knight");
        } else {
            image = getImage("/piece/b-knight");
        }
    }

    @Override
    public boolean canMove(int targetCol, int targetRow) {
        return isWithinBoard(targetCol, targetRow) &&
        Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 2 && 
        isValidSquare(targetCol, targetRow);
    }
    
}
