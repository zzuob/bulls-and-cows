# Bulls and Cows
A CLI implementation of the code-breaking game, Bulls and Cows.


## Prerequisites
This program is written in Java 17.


## Features
- code generation customisation:
  ```
  Input the length of the secret code:
  > 6
  Input the number of possible symbols in the code:
  > 12
  The secret code is prepared: ****** (0-9, a-b)
  ```
  - can be made from up to 36 symbols (0-9, a-z)
  - as per usual rules, no symbol is repeated twice
- turn counter, track how many guesses per game
- guess grader, giving the number of bulls (correct symbol and placement) and cows (correct symbol with incorrect placement)
- game ends when the code is correctly guessed

## Getting Started
Run Main.java:

```bash
java Main
```

## License
[MIT](https://opensource.org/license/mit/)
