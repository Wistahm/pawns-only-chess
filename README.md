# Pawns-Only Chess

Pawns-Only Chess is a unique console-based chess game that I developed in Kotlin and it focuses solely on the pawn pieces.<br>

## Description

The game of chess has many different derivatives, and **Pawns-Only Chess** is one of them. In simple words it's just chess but without other pieces; only pawns. The main difference is in the winning conditions. To see the rules of this game, head to the Rules section below.

## Rules

### Movement
- Just like in chess, pawns move one square forward at a time, unless it's their first move so they can move two squares.
- Also, pawns cannot move forward if there's another pawn in front of them.
- Pawns can capture the enemy piece diagonally.

### Winning and Loosing
- If either player succeeds in moving one of their pawns to the last opposite rank (rank 8 for white and rank 1 for black), wins the game.
```
  +---+---+---+---+---+---+---+---+
8 |   |   |   | W |   |   |   |   |
  +---+---+---+---+---+---+---+---+
7 | B | B | B |   | B |   |   |   |
  +---+---+---+---+---+---+---+---+
6 |   |   |   |   |   |   |   | B |
  +---+---+---+---+---+---+---+---+
5 |   |   |   |   |   | B | B |   |
  +---+---+---+---+---+---+---+---+
4 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
3 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
2 | W | W | W | W |   | W | W | W |
  +---+---+---+---+---+---+---+---+
1 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
    a   b   c   d   e   f   g   h   
White won!
```

- If one of the players runs out of pawns, the other player is the winner.
``` 
  +---+---+---+---+---+---+---+---+
8 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
7 |   |   | B |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
6 |   |   |   |   | B |   | B |   |
  +---+---+---+---+---+---+---+---+
5 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
4 | B |   |   |   |   |   |   | B |
  +---+---+---+---+---+---+---+---+
3 | B |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
2 |   | B |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
1 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
    a   b   c   d   e   f   g   h   
Black won!
```

### Stalemate or Draw
- Stalemate or draw occurs when a player can't make a valid move on his/her turn.
``` 
  +---+---+---+---+---+---+---+---+
8 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
7 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
6 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
5 | B |   | B |   |   |   | B |   |
  +---+---+---+---+---+---+---+---+
4 | W |   | W |   |   |   | W |   |
  +---+---+---+---+---+---+---+---+
3 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
2 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
1 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
    a   b   c   d   e   f   g   h   
Stalemate, draw.
<<<<<<< HEAD
```
=======
```
<br>
[The idea of this project comes from https://hyperskill.org.]
>>>>>>> 6c65dcec10db561dfd6f74a14b3e9abc8b02acf1
