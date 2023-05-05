# Pawns-Only Chess

**A console based game called Pawns-Only Chess.**

## Description

The game of chess has many different derivatives, and `Pawns-Only Chess` is one of them. In simple words it's just chess but without other pieces; only pawns. The main difference is in the winning conditions. To see the rules of this game, head to the Rules section below.

## Rules

### Movement
- Just like in chess, pawns move one square forward at a time, unless it's their first move so they can move two squares.
- Also, pawns cannot move forward if there's another pawn in front of them.
- Pawns can capture the enemy piece diagonally.

### Winning and Loosing
- If either player succeeds in moving one of their pawns to the last opposite rank (rank 8 for white and rank 1 for black), wins the game.<br>
`  +---+---+---+---+---+---+---+---+`<br>
`8 |   |   |   | W |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`7 | B | B | B |   | B |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`6 |   |   |   |   |   |   |   | B |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`5 |   |   |   |   |   | B | B |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`4 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`3 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`2 | W | W | W | W |   | W | W | W |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`1 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`    a   b   c   d   e   f   g   h  `<br>
`White won!`

- If one of the players runs out of pawns, the other player is the winner.<br>
`  +---+---+---+---+---+---+---+---+`<br>
`8 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`7 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`6 |   |   | B |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`5 | B |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`4 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`3 |   |   |   |   |   |   | B |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`2 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`1 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`    a   b   c   d   e   f   g   h  `<br>
`Black won!`

### Stalemate or Draw
- Stalemate or draw occurs when a player can't make a valid move on his/her turn.<br>
`  +---+---+---+---+---+---+---+---+`<br>
`8 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`7 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`6 |   |   |   |   |   | B |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`5 | B |   |   | B |   | W | B |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`4 | W |   |   | W |   |   | W |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`3 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`2 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`1 |   |   |   |   |   |   |   |   |`<br>
`  +---+---+---+---+---+---+---+---+`<br>
`    a   b   c   d   e   f   g   h  `<br>
`Stalemate, draw.`
