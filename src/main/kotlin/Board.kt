// Pawns
private const val WHITE_PAWN = "W"
private const val BLACK_PAWN = "B"

class Board {
    private val size = 8
    private val board = Array(size) { Array(size) { " " } }

    // Flag variable to check whether each pawn ha already moved or not.
    private val isWhitesFirstMove = Array(8) { BooleanArray(8) }
    private val isBlacksFirstMove = Array(8) { BooleanArray(8) }

    // As default, white always goes first.
    var playerTurn = WHITE_PAWN

    init {
        // Initialize the staring position of pawns.
        for (col in 0 until size) {
            board[size - 2][col] = BLACK_PAWN
            board[1][col] = WHITE_PAWN
        }

        // Initialize the first move for all the pawns.
        for (row in board.indices) {
            for (col in board[row].indices) {
                if (board[row][col] == WHITE_PAWN) {
                    isWhitesFirstMove[row][col] = true
                } else if (board[row][col] == BLACK_PAWN) {
                    isBlacksFirstMove[row][col] = true
                }
            }
        }
    }

    fun printBoard() {
        // Just printing the board with a bunch of loops.
        println("  +---+---+---+---+---+---+---+---+")
        for (row in size downTo 1) {
            print("$row ")
            for (col in 0 until size) {
                print("| ${board[row - 1][col]} ")
            }
            println("|")
            println("  +---+---+---+---+---+---+---+---+")
        }

        print("    ")
        for (c in 'a'..'h') {
            print("$c   ")
        }
        println()
    }

    fun movePawn(fromRow: Int, fromCol: Int, toRow: Int, toCol: Int) {
        val piece = board[fromRow][fromCol]

        if (piece != WHITE_PAWN && piece != BLACK_PAWN) {
            // First we check if the considered position is empty or there's a pawn.
            // If there is no pawn, throw an exception.
            throw IllegalArgumentException("No pawn at the considered position.")
        }

        if (toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
            // Check if entered numbers are in range of 0 to 7 or not.
            throw IllegalArgumentException("Invalid position entered.")
        }

        // Take turns and play.
        playerTurn = if (playerTurn == WHITE_PAWN && piece == WHITE_PAWN) {
            whiteToPlay(piece, fromRow, fromCol, toRow, toCol)
            BLACK_PAWN
        } else if (playerTurn == BLACK_PAWN && piece == BLACK_PAWN) {
            blackToPlay(piece, fromRow, fromCol, toRow, toCol)
            WHITE_PAWN
        } else {
            throw IllegalArgumentException("Illegal move found.")
        }

    } // End of movePawn()

    private fun whiteToPlay(piece: String, fromRow: Int, fromCol: Int, toRow: Int, toCol: Int) {
        if (piece == WHITE_PAWN) {
            // If the considered piece is white...
            if (toRow == fromRow + 1 && toCol == fromCol && board[toRow][toCol] == " ") {
                // Move the pawn forward one square.
                board[toRow][toCol] = piece
                board[fromRow][fromCol] = " "
                // Mark the pawn's first move as completed.
                isWhitesFirstMove[toRow][toCol] = false
            } else if (toRow == fromRow + 2 && toCol == fromCol && isWhitesFirstMove[fromRow][fromCol]) {
                // If it's the pawn's first move, we can move it two squares forward.
                board[toRow][toCol] = piece
                board[fromRow][fromCol] = " "
                // Mark the pawn's first move as completed.
                isWhitesFirstMove[toRow][toCol] = false
            } else if (toRow == fromRow + 1 && (toCol == fromCol + 1 || toCol == fromCol - 1)
                && board[toRow][toCol] == BLACK_PAWN
            ) {
                // Capturing the enemy piece.
                // We also have to make sure that the square has a black pawn in it, and it's not empty.
                board[toRow][toCol] = piece
                board[fromRow][fromCol] = " "
            } else {
                // If player tries to enter invalid inputs, throw exception.
                throw IllegalArgumentException(
                    "Pawns can only move one square forward at a time, " +
                            "unless it's their first move so they can move tow squares.\n" +
                            "Also pawns cannot move forward if there's another pawn in front of them.\n" +
                            "Pawns can capture the enemy piece one square diagonally."
                )
            }
        }
    }

    private fun blackToPlay(piece: String, fromRow: Int, fromCol: Int, toRow: Int, toCol: Int) {
        if (piece == BLACK_PAWN) {
            // If the considered piece is black...
            if (toRow == fromRow - 1 && toCol == fromCol && board[toRow][toCol] == " ") {
                // Black pawns move downwards unlike white pawns which they move upwards.
                // So we have to move it in negative direction.
                board[toRow][toCol] = piece
                board[fromRow][fromCol] = " "
                // Mark the pawn's first move as completed.
                isBlacksFirstMove[toRow][toCol] = false
            } else if (toRow == fromRow - 2 && toCol == fromCol && isBlacksFirstMove[fromRow][fromCol]) {
                // Two square move for black pawns.
                board[toRow][toCol] = piece
                board[fromRow][fromCol] = " "
                // Mark the pawn's first move as completed.
                isBlacksFirstMove[toRow][toCol] = false
            } else if (toRow == fromRow - 1 && (toCol == fromCol + 1 || toCol == fromCol - 1)
                && board[toRow][toCol] == WHITE_PAWN
            ) {
                // Diagonally move for black pawns.
                board[toRow][toCol] = piece
                board[fromRow][fromCol] = " "
            } else {
                throw IllegalArgumentException(
                    "Pawns can only move one square forward at a time, " +
                            "unless it's their first move so they can move tow squares.\n" +
                            "Also pawns cannot move forward if there's another pawn in front of them.\n" +
                            "Pawns can capture the enemy piece one square diagonally."
                )
            }
        }
    }

    fun checkGameFinalResult(): String {
        // First winning condition:
        //  If either player succeeds in moving one of their pawns to the last opposite
        //  rank (rank 8 for white, rank 1 for black), wins the game.
        for (col in 0 until size) {
            // Iterate over the first rank and the last rank of the board.
            if (board[size - 1][col] == WHITE_PAWN) {
                // A white pawn reaches to the last/8th rank, so white wins.
                return WHITE_PAWN
            }
            if (board[0][col] == BLACK_PAWN) {
                // A black pawn reaches to the first rank, so black wins.
                return BLACK_PAWN
            }
        }

        // Second winning condition:
        //  If one of the players runs out of pawns, the other player is the winner.
        var whitePawnsCount = 0
        var blackPawnsCount = 0
        for (row in board.indices) {
            for (col in board[row].indices) {
                if (board[row][col] == WHITE_PAWN) {
                    // Count all the current white pawns on the board.
                    whitePawnsCount++
                } else if (board[row][col] == BLACK_PAWN) {
                    // Count all the current black pawns on the board.
                    blackPawnsCount++
                }
            }
        }

        if (blackPawnsCount == 0 && whitePawnsCount > 0) {
            // Black player runs out of pawns, so white wins.
            return WHITE_PAWN
        }
        if (whitePawnsCount == 0 && blackPawnsCount > 0) {
            // White player runs out of pawns, so black wins.
            return BLACK_PAWN
        }



        // Third condition: Stalemate or Draw
        //  Stalemate or draw occurs when a player can't make a valid
        //  move on his/her turn.
        if (checkDraw()) {
            return "_"
        }

        return ""
    }

    private fun checkDraw(): Boolean {
        var whiteCanMove = false
        var blackCanMove = false
        for (row in board.indices) {
            for (col in board[row].indices) {
                if (board[row][col] == WHITE_PAWN) {
                    // Check for the white pawns
                    if (board[row + 1][col] == " ") {
                        // If any white pawn can move one square forward.
                        whiteCanMove = true
                    } else if (board[row + 2][col] == " " && isWhitesFirstMove[row][col]) {
                        // If any white pawn can move two squares forward on its first move.
                        whiteCanMove = true
                    } else if (col in 1..6 && (board[row + 1][col + 1] == BLACK_PAWN || board[row + 1][col - 1] == BLACK_PAWN)) {
                        // If any white pawn is on 'b' to 'g' file, so it has access to two diagonals,
                        //  one to the right side, one to the left side.
                        whiteCanMove = true
                    } else if (col == 0 && board[row + 1][col + 1] == BLACK_PAWN) {
                        // If the white pawn is on the 'a' file, it only has access
                        //  to the right side diagonal.
                        whiteCanMove = true
                    } else if (col == 7 && board[row + 1][col - 1] == BLACK_PAWN) {
                        // If the white pawn is on the 'h' file, it only has access
                        //  to the left side diagonal.
                        whiteCanMove = true
                    }
                } else if (board[row][col] == BLACK_PAWN) {
                    // Check for the black pawns
                    if (board[row - 1][col] == " ") {
                        blackCanMove = true
                    } else if (board[row - 2][col] == " " && isBlacksFirstMove[row][col]) {
                        blackCanMove = true
                    } else if (col in 1..6 && (board[row - 1][col + 1] == WHITE_PAWN || board[row - 1][col - 1] == WHITE_PAWN)) {
                        blackCanMove = true
                    } else if (col == 0 && board[row - 1][col + 1] == WHITE_PAWN) {
                        blackCanMove = true
                    } else if (col == 7 && board[row - 1][col - 1] == WHITE_PAWN) {
                        blackCanMove = true
                    }
                }
            }
        }

        if (!whiteCanMove) return true
        if (!blackCanMove) return true

        return false
    } // End of checkDraw()

} // End of Board class