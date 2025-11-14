public class Pawn extends Piece {
    public Pawn(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE) {
            image = getImage("/piece/w-pawn");
        } else {
            image = getImage("/piece/b-pawn");
        }
    }

    @Override
    public boolean canMove(int targetCol, int targetRow) {
        if(isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow)) {
            int moveValue;
            
            if(color == GamePanel.WHITE) {
                moveValue = -1;
            } else {
                moveValue = 1;
            }

            hittingP = getHittingP(targetCol, targetRow);
            //1 square move
            if(targetCol == preCol && targetRow == preRow + moveValue && hittingP == null) {
                return true;
            }
            //2 square move
            if(!moved && targetCol == preCol && targetRow == preRow + (2 * moveValue) && hittingP == null
            && !pieceIsOnStraightLine(targetCol, targetRow)) {
                return true;
            }

            //hitting move
            if(!moved && !pieceIsOnStraightLine(targetCol, targetRow) && Math.abs(targetCol - preCol) == 1 && targetRow == preRow + moveValue) {
                return true;
            }

            //en passant
        }
        return false;
    }
}