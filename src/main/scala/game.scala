package coinToss

import scala.annotation.tailrec
import scala.util.Random
import coinTossUtils.{showPrompt, getUserInput, tossCoin, boolToInt, printGameState, printableFlipResult, printGameOver}

case class GameState (
    numFlips: Int,
    numCorrectGuesses: Int
)

object CoinFlip extends App {
    val s = GameState(0, 0)
    val r = new Random
    mainLoop(s, r)

  @tailrec
  def mainLoop(gameState: GameState, random: Random) {
      showPrompt
      val input = getUserInput
      input match {
        case "H" | "T" => {
            val toss = tossCoin(random)
            val matches = (input == toss)
            val newGameState = GameState(gameState.numFlips + 1, gameState.numCorrectGuesses + boolToInt(matches))
            printGameState(printableFlipResult(toss), newGameState)
            mainLoop(newGameState, random)
        }
        case _ => {
          printGameState(gameState)
          printGameOver
        }

      }

    }

}
