class MoveParser {
    private val validMoveForm = Regex("[a-h][1-8][a-h][1-8]")

    fun parseMove(move: String): IntArray {
        if (!move.matches(validMoveForm)) {
            throw IllegalArgumentException("Invalid move format.")
        }

        val fromCol = move[0] - 'a'
        val fromRow = move[1] - '1'
        val toCol = move[2] - 'a'
        val toRow = move[3] - '1'

        return intArrayOf(fromRow, fromCol, toRow, toCol)
    }
}
