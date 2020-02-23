package coinToss

import scala.util.Random
import scala.io.StdIn.readLine

object coinTossUtils {

  def tossCoin(r: Random): String = {
      val i = r.nextInt(2)
      i match {
          case 0 => "H"
          case 1 => "T" }
        }

  def showPrompt: Unit = { print("\n(h)eads, (t)ails, or (q)uit: ") }

  def getUserInput: String = readLine.trim.toUpperCase

  def printableFlipResult(flip: String) = flip match { case "H" => "Heads"
  case "T" => "Tails"
  }

  def printGameState(printableResult: String, gameState: GameState): Unit = { print(s"Flip was $printableResult. ")
  printGameState(gameState)
  }

  def printGameState(gameState: GameState): Unit = {
  println(s"#Flips: ${gameState.numFlips}, #Correct: ${gameState.numCorrectGuesses}")
  }

  def printGameOver: Unit = println("\n=== GAME OVER ===")

  def boolToInt(bool: Boolean): Integer = if (bool) 1 else 0

}
