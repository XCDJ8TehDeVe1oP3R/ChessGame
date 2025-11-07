public class Rook extends Piece {
    public Rook(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE) {
            image = getImage("/piece/w-rook");
        } else {
            image = getImage("/piece/b-rook");
        }
    }

    @Override
    public boolean canMove(int targetCol, int targetRow) {
        return isWithinBoard(targetCol, targetRow) &&
        !isSameSquare(targetCol, targetRow) &&
        (targetCol == preCol || targetRow == preRow) &&
        isValidSquare(targetCol, targetRow)&&
        pieceIsOnStraightLine(targetCol, targetRow);
    }
}
