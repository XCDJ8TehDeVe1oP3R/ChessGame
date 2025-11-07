public class Queen extends Piece {
    public Queen(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE) {
            image = getImage("/piece/w-queen");
        } else {
            image = getImage("/piece/b-queen");
        }
    }

    @Override
    public boolean canMove(int targetCol, int targetRow) {
        return isWithinBoard(targetCol, targetRow) &&
        !isSameSquare(targetCol, targetRow) &&
        (targetCol == preCol || targetRow == preRow ||
        Math.abs(targetCol - preCol) == Math.abs(targetRow - preRow)) &&
        isValidSquare(targetCol, targetRow) &&
        (pieceIsOnStraightLine(targetCol, targetRow) ||
        pieceIsOnDiagonalLine(targetCol, targetRow));
    }

}
