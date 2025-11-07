public class King extends Piece {

    public King(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE) {
            image = getImage("/piece/w-king");
        } else {
            image = getImage("/piece/b-king");
        }
    }

    @Override
    public boolean canMove(int targetCol, int targetRow) {
        return (isWithinBoard(targetCol, targetRow) &&
        (Math.abs(targetCol - preCol) + Math.abs(targetRow - preRow) == 1 ||
        Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 1) &&
        isValidSquare(targetCol, targetRow));
    }
}
