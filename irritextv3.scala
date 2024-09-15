//> using scala 3.5

import scala.io.StdIn.readLine


// Välkommen till Slottets Förbannelse
@main 
def run: Unit =
  printWelcomeMessage()
  Thread.sleep(1000) // Väntar 1 sekund
  play()


def printWelcomeMessage(): Unit = println(
  """
    |========================================
    | Välkommen till Slottets Förbannelse!
    | Ett textbaserat äventyr där varje val avgör din överlevnad.
    | Lycka till, och gör dina val med omsorg...
    |========================================
  """.stripMargin)

var isDead = false
var points = 0
var health = 3 //  hälsosystem

// Spelet börjar
def doorChoice(): String = readLine("Skriv in: det magiska ordet, för att starta spelet:\n").trim

def play(): Unit =
  while !isDead do
    val door: String = doorChoice()
    if door.equalsIgnoreCase("det magiska ordet") then
      println("\nOrdet accepterat, låt spelet börja!")
      points += 50*health
      Thread.sleep(1000)
      playFirstRoom()
    else
      health -= 1
      println(s"Fel lösenord! Du har förlorat 1 liv. Du har $health kvar. Prova igen.")
       // Hälsa minskar vid fel lösenord
      if health <= 0 then
        isDead = true
        println("För många fel! Du är nu död... Spelet är över.")

// Rum 1 - Början
def playFirstRoom(): Unit =
  val choice = readLine(
    """
      |Du befinner dig i ett mörkt rum. Framför dig finns två dörrar.
      |En till vänster och en till höger. Vad väljer du?
      |A = Gå igenom vänster dörr.
      |B = Gå igenom höger dörr.
    """.stripMargin).trim

  choice.toLowerCase match
    case "a" =>
      println("Du går in i vänster rum och faller direkt ner i en avgrund. Spelet är över!")
      isDead = true
    case "b" =>
      println("Du öppnar höger dörr och går vidare i den mörka korridoren.")
      Thread.sleep(1000)
      playSecondRoom()
    case _ =>
      println("Ogiltigt val, försök igen.")
      playFirstRoom()

// Rum 2 - Korridoren
def playSecondRoom(): Unit =
  val choice = readLine(
    """
      |Du kommer till en korridor med tre föremål på ett bord framför dig: en kniv, en spegel och en nyckel.
      |Vilket föremål tar du med dig?
      |A = Ta kniven.
      |B = Ta spegeln.
      |C = Ta nyckeln.
    """.stripMargin).trim

  choice.toLowerCase match
    case "a" =>
      println("Du tar kniven och fortsätter framåt. Men snart möter du en mörk varelse. Kniven hjälper dig inte...")
      isDead = true
    case "b" =>
      println("Du tar spegeln. När du möter en mörk varelse, håller du upp spegeln och varelsen försvinner.")
      Thread.sleep(1000)
      points += 50*health
      playBonusRoom()
    case "c" =>
      println("Du tar nyckeln och låser upp en dörr längre fram. Du går vidare...")
      Thread.sleep(1000)
      playBonusRoom()
    case _ =>
      println("Ogiltigt val, försök igen.")
      playSecondRoom()

// Bonus Rum 

def playBonusRoom(): Unit =
  val choice = readLine(
    """
      |På vägen till nästa rum stöter du på en rostig spak i väggen
      |väggen är graverad med orden 'för de som vågar' vad gör du?
      |A = Dra i spaken
      |B = Gå vidare
    """.stripMargin).trim

  choice.toLowerCase match
    case "a" =>
      println("Du drar i spaken, plötsligt rasar vägen och avslöjar en hemligt rum, du går in i rummet och hittar en kista")
      points += 50*health
      Thread.sleep(1000)
      playBonusRound()
    case "b" =>
      println("Du struntar i spaken och går vidare")
      Thread.sleep(1000)
      playThirdRoom()
    case _ =>
      println("Ogiltigt val, försök igen.")
      playBonusRoom()

// Bonus Runda

def playBonusRound(): Unit =
  val choice = readLine(
    """
      |Kistan är märkt med 'Rikedom för 3, död för 1 skall ske' vad gör du?
      |A = Öppna kistan...
      |B = Lämna kistan och gå vidare...
    """.stripMargin).trim


  choice.toLowerCase match
    case "a" =>
      println("Du öppnar kistan...")
      if math.random < 0.75 
      then 
        println("Inuti kistan hittar du guld smycken och diamanter, du tar så mycket du kan och går vidare") 
        points += 250 * health
        Thread.sleep(1000)
        playThirdRoom()
    
      
      else 
        health -= 2
        println(s"Plötsligt hoppar en spindel ut från kistan och biter dig i nacken, du förlorar 1 liv och har $health kvar ")
        if health <= 0 then
            isDead = true
            println("Du är nu död... Spelet är över.")
            else playThirdRoom()
        

    case "b" =>
      println("Du struntar i kistan och går vidare")
      Thread.sleep(1000)
      playThirdRoom()
    case _ =>
      println("Ogiltigt val, försök igen.")
      playBonusRound()

// Rum 3 - Slutet
def playThirdRoom(): Unit =
  val choice = readLine(
    """
      |Du når ett sista rum. Framför dig finns en stor dörr, men det finns också en fälla på golvet.
      |Hur vill du fortsätta?
      |A = Försök att desarmera fällan.
      |B = Smyg försiktigt förbi fällan.
    """.stripMargin).trim

  choice.toLowerCase match
    case "a" =>
      println("Du försöker desarmera fällan, men misslyckas. Du faller ner i en avgrund. Spelet är över!")
      isDead = true
    case "b" =>
      println("Du smyger försiktigt förbi fällan och öppnar dörren. Du ser dagsljuset och inser att du har överlevt!")
      points += 100
      printVictory()
    case _ =>
      println("Ogiltigt val, försök igen.")
      playThirdRoom()

def printVictory(): Unit =
  println(s"\nGrattis! Du har överlevt Slottets Förbannelse med $points poäng av totalt 1300 möjliga poäng!")
