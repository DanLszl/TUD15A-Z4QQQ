# TUD15A-Z4QQQ
Implementation of the Pong Game for the Athens Course TUD15

To start the game the JVM option -Djava.library.path=target/libs has to be set.
This is due to the use of the Slick2D framework, which needs native libraries depending on the OS.



We used the Singleton Pattern for the Gamestates (WelcomeState, PlayingState, and GameOverState)
Furthmore, we used it for the Scoreboard.

WHY: Because then can ensure that there is only one instance of each state during the whole execution.
Moreover, we can now access the scoreboard globally, which makes it very feasible to show the score and get the winner in different states. (Since it is not bound to a state anymore)

HOW: We used the eager init style, in the classes ScoreBoard, GameOverState, WelcomeState and PlayingState.


