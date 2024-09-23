class Board {
    private val size = 8
    private val board = Array(size) { Array(size) { " " } }
    private val isWhitesFirstMove = Array(size) { BooleanArray(size) }
    private val isBlacksFirstMove = Array(size) { BooleanArray(size) }
    var playerTurn = WHITE_PAWN

    init {
        initializeBoard()
    }

    private fun initializeBoard() {
        for (col in 0 until size) {
            board[size - 2][col] = BLACK_PAWN
            board[1][col] = WHITE_PAWN
        }
        for (row in board.indices) {
            for (col in board[row].indices) {
                when (board[row][col]) {
                    WHITE_PAWN -> isWhitesFirstMove[row][col] = true
                    BLACK_PAWN -> isBlacksFirstMove[row][col] = true
                }
            }
        }
    }

    fun printBoard() {
        println("  +---+---+---+---+---+---+---+---+")
        for (row in size downTo 1) {
            print("$row ")
            for (col in 0 until size) {
                print("| ${board[row - 1][col]} ")
            }
            println("|")
            println("  +---+---+---+---+---+---+---+---+")
        }
        printColumnLabels()
    }

    private fun printColumnLabels() {
        print("    ")
        for (c in 'a'..'h') {
            print("$c   ")
        }
        println()
    }

    fun movePawn(fromRow: Int, fromCol: Int, toRow: Int, toCol: Int) {
        val piece = board[fromRow][fromCol]

        validateMove(piece, toRow, toCol)

        playerTurn = when {
            playerTurn == WHITE_PAWN && piece == WHITE_PAWN -> {
                whiteToPlay(piece, fromRow, fromCol, toRow, toCol)
                BLACK_PAWN
            }
            playerTurn == BLACK_PAWN && piece == BLACK_PAWN -> {
                blackToPlay(piece, fromRow, fromCol, toRow, toCol)
                WHITE_PAWN
            }
            else -> throw IllegalArgumentException("Illegal move found.")
        }
    }

    private fun validateMove(piece: String, toRow: Int, toCol: Int) {
        if (piece != WHITE_PAWN && piece != BLACK_PAWN) {
            throw IllegalArgumentException("No pawn at the considered position.")
        }
        if (toRow !in 0 until size || toCol !in 0 until size) {
            throw IllegalArgumentException("Invalid position entered.")
        }
    }

    private fun whiteToPlay(piece: String, fromRow: Int, fromCol: Int, toRow: Int, toCol: Int) {
        when {
            toRow == fromRow + 1 && toCol == fromCol && board[toRow][toCol] == " " -> {
                movePawnToPosition(piece, fromRow, fromCol, toRow, toCol)
            }
            toRow == fromRow + 2 && toCol == fromCol && isWhitesFirstMove[fromRow][fromCol] -> {
                movePawnToPosition(piece, fromRow, fromCol, toRow, toCol)
            }
            toRow == fromRow + 1 && (toCol == fromCol + 1 || toCol == fromCol - 1) && board[toRow][toCol] == BLACK_PAWN -> {
                captureEnemyPiece(piece, fromRow, fromCol, toRow, toCol)
            }
            else -> throwInvalidMoveException()
        }
    }

    private fun blackToPlay(piece: String, fromRow: Int, fromCol: Int, toRow: Int, toCol: Int) {
        when {
            toRow == fromRow - 1 && toCol == fromCol && board[toRow][toCol] == " " -> {
                movePawnToPosition(piece, fromRow, fromCol, toRow, toCol)
            }
            toRow == fromRow - 2 && toCol == fromCol && isBlacksFirstMove[fromRow][fromCol] -> {
                movePawnToPosition(piece, fromRow, fromCol, toRow, toCol)
            }
            toRow == fromRow - 1 && (toCol == fromCol + 1 || toCol == fromCol - 1) && board[toRow][toCol] == WHITE_PAWN -> {
                captureEnemyPiece(piece, fromRow, fromCol, toRow, toCol)
            }
            else -> throwInvalidMoveException()
        }
    }

    private fun movePawnToPosition(piece: String, fromRow: Int, fromCol: Int, toRow: Int, toCol: Int) {
        board[toRow][toCol] = piece
        board[fromRow][fromCol] = " "
        if (piece == WHITE_PAWN) {
            isWhitesFirstMove[toRow][toCol] = false
        } else {
            isBlacksFirstMove[toRow][toCol] = false
        }
    }

    private fun captureEnemyPiece(piece: String, fromRow: Int, fromCol: Int, toRow: Int, toCol: Int) {
        board[toRow][toCol] = piece
        board[fromRow][fromCol] = " "
    }

    private fun throwInvalidMoveException() {
        throw IllegalArgumentException(
            "Pawns can only move one square forward at a time, " +
                    "unless it's their first move to move two squares. " +
                    "They cannot move forward if there's another pawn in front of them. " +
                    "Pawns can capture the enemy piece one square diagonally."
        )
    }

    fun checkGameFinalResult(): String {
        if (checkWinningConditions()) return WHITE_PAWN
        if (checkWinningConditions(false)) return BLACK_PAWN
        return if (checkDraw()) "_" else ""
    }

    private fun checkWinningConditions(isWhite: Boolean = true): Boolean {
        val targetRow = if (isWhite) size - 1 else 0
        return board[targetRow].any { it == (if (isWhite) WHITE_PAWN else BLACK_PAWN) }
    }

    private fun checkDraw(): Boolean {
        val whiteCanMove = canMove(WHITE_PAWN, isWhitesFirstMove)
        val blackCanMove = canMove(BLACK_PAWN, isBlacksFirstMove)
        return !(whiteCanMove || blackCanMove)
    }

    private fun canMove(pawn: String, firstMoveFlags: Array<BooleanArray>): Boolean {
        for (row in board.indices) {
            for (col in board[row].indices) {
                if (board[row][col] == pawn) {
                    if (canMoveForward(row, col, pawn, firstMoveFlags) || canCapture(row, col, pawn)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun canMoveForward(row: Int, col: Int, pawn: String, firstMoveFlags: Array<BooleanArray>): Boolean {
        val direction = if (pawn == WHITE_PAWN) 1 else -1
        return (board[row + direction][col] == " ") ||
                (firstMoveFlags[row][col] && board[row + 2 * direction][col] == " ")
    }

    private fun canCapture(row: Int, col: Int, pawn: String): Boolean {
        val direction = if (pawn == WHITE_PAWN) 1 else -1
        return (col in 1 until size - 1 &&
                (board[row + direction][col + 1] == BLACK_PAWN || board[row + direction][col - 1] == BLACK_PAWN)) ||
                (col == 0 && board[row + direction][col + 1] == BLACK_PAWN) ||
                (col == size - 1 && board[row + direction][col - 1] == BLACK_PAWN)
    }
}
