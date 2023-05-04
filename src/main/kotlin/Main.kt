import kotlin.system.exitProcess

fun main() {
    val validMoveForm = Regex("[a-h][1-8][a-h][1-8]")
    var fromRow = 0; var fromCol = 0; var toRow = 0; var toCol = 0

    val board = Board()
    board.printBoard()

    while (true) {
        try {
            if (board.playerTurn == "W") {
                print("White's turn. Enter your move: ")
            } else if (board.playerTurn == "B") {
                print("Black's turn. Enter your move: ")
            }
            val theMove = readln()
            if (theMove.matches(validMoveForm)) {
                // We first check that the user input matches our regex variable,
                //  which is the only valid form of input for this game.
                when(theMove[0]) {
                    // The first character stands for home file, a file, b file, etc.
                    'a' -> fromCol = 0
                    'b' -> fromCol = 1
                    'c' -> fromCol = 2
                    'd' -> fromCol = 3
                    'e' -> fromCol = 4
                    'f' -> fromCol = 5
                    'g' -> fromCol = 6
                    'h' -> fromCol = 7
                }
                when(theMove[1]) {
                    // The first character stands for home rank, 1st rant, 2nd rank, etc.
                    '1' -> fromRow = 0
                    '2' -> fromRow = 1
                    '3' -> fromRow = 2
                    '4' -> fromRow = 3
                    '5' -> fromRow = 4
                    '6' -> fromRow = 5
                    '7' -> fromRow = 6
                    '8' -> fromRow = 7
                }
                when(theMove[2]) {
                    // The third character stands for desired file.
                    'a' -> toCol = 0
                    'b' -> toCol = 1
                    'c' -> toCol = 2
                    'd' -> toCol = 3
                    'e' -> toCol = 4
                    'f' -> toCol = 5
                    'g' -> toCol = 6
                    'h' -> toCol = 7
                }
                when(theMove[3]) {
                    // The fourth character stands for desired rank.
                    '1' -> toRow = 0
                    '2' -> toRow = 1
                    '3' -> toRow = 2
                    '4' -> toRow = 3
                    '5' -> toRow = 4
                    '6' -> toRow = 5
                    '7' -> toRow = 6
                    '8' -> toRow = 7
                }
            } else {
                // If the user's move doesn't match the regex.
                println("Please enter a valid form of move.")
                continue
            }

            // Move the pawn and print the board right after the move.
            board.movePawn(fromRow, fromCol, toRow, toCol)
            board.printBoard()

            // Check the final result of the game commonly.
            when(board.checkGameFinalResult()) {
                "W" -> {
                    println("White won!")
                    exitProcess(0)
                }
                "B" -> {
                    println("Black won!")
                    exitProcess(0)
                }
                "_" -> {
                    println("Stalemate, draw.")
                    exitProcess(0)
                }
            }

            continue
        } catch (e: IllegalArgumentException) {
            println("Please enter a legal move.")
            continue
        }

    }
}