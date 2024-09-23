const val WHITE_PAWN = "W"
const val BLACK_PAWN = "B"

class Pawn(val color: String) {
    val isWhite: Boolean
        get() = color == WHITE_PAWN

    val isBlack: Boolean
        get() = color == BLACK_PAWN
}
