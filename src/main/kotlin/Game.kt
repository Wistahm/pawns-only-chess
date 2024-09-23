import kotlin.system.exitProcess

class Game {
    private val board = Board()
    private val moveParser = MoveParser()

    fun play() {
        board.printBoard()

        while (true) {
            try {
                promptPlayerTurn()
                val theMove = readln()
                val (fromRow, fromCol, toRow, toCol) = moveParser.parseMove(theMove)

                // Move the pawn and print the board right after the move.
                board.movePawn(fromRow, fromCol, toRow, toCol)
                board.printBoard()

                // Check the final result of the game.
                checkGameResult()
            } catch (e: IllegalArgumentException) {
                println("Please enter a legal move.")
            }
        }
    }

    private fun promptPlayerTurn() {
        val player = if (board.playerTurn == WHITE_PAWN) "White" else "Black"
        print("$player's turn. Enter your move: ")
    }

    private fun checkGameResult() {
        when (board.checkGameFinalResult()) {
            WHITE_PAWN -> {
                println("White won!")
                exitProcess(0)
            }
            BLACK_PAWN -> {
                println("Black won!")
                exitProcess(0)
            }
            "_" -> {
                println("Stalemate, draw.")
                exitProcess(0)
            }
        }
    }
}
