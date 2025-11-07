public class Bishop extends Piece {
    public Bishop(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE) {
            image = getImage("/piece/w-bishop");
        } else {
            image = getImage("/piece/b-bishop");
        }
    }

    @Override
    public boolean canMove(int targetCol, int targetRow) {
        return isWithinBoard(targetCol, targetRow) &&
        !isSameSquare(targetCol, targetRow) &&
        (Math.abs(targetCol - preCol) == Math.abs(targetRow - preRow)) &&
        isValidSquare(targetCol, targetRow) &&
        pieceIsOnDiagonalLine(targetCol, targetRow);
    }
    
}
