//> using scala 3.5

import scala.io.StdIn.readLine



// Välkommen till irritext
@main 
def run: Unit =
  printWelcomeMessage()
  Thread.sleep(1000) // vänta 1 sekunder
  play()
  //if isDead then printDead() else printSolved(points)
  
def printWelcomeMessage(): Unit = println("""
  |Välkommen till Irritext!
""".stripMargin)


var isDead = false
var isSolved = false
var points = 0

// spelet börjar

def doorChoice(): String = readLine("Vänligen skriv passwordet, för att starta spelet:\n").trim

def play(): Unit =
  while !isDead && !isSolved do
    val door: String = doorChoice()
    if door.equalsIgnoreCase("passwordet") then
      println("passwordet accepterat, låt spelet börja")
      Thread.sleep(1000)
      isSolved = true
      play2()

    else
      println("Fel password\n")



// Eskalering 

def printDead(): Unit = println("Du är nu DÖÖÖÖÖÖD! Tack och hej :(")

def printSolved(points: Int): Unit = println(s"GRATTIS DU FICK $points POÄNG!")



// bana 2

var isDead2 = false
var isSolved2 = false

def doorChoice2(): String = readLine("\nDu vaknar i ett kallt, mörkt rum. En liten ljusstråle tränger in genom en spricka i den gamla stenväggen, men det mesta är insvept i skuggor.\n" +
  "Du hör svaga, oförklarliga ljud från de djupare delarna av slottet, vad gör du?\n" +
  "\nA=Smyg ut genom dörren och lämna rummet så tyst som möjligt. \nB=Tänd ett ljus och undersök rummet.\n").trim

def play2(): Unit =
  while !isDead2 && !isSolved2 do
    val door: String = doorChoice2()
    if door.toLowerCase.startsWith("a") then
      println("\nDu smyger försiktigt ut genom dörren. Slottet verkar övergivet, men du hör svaga steg ekande i korridorerna." +
        "\nFramför dig finns två dörrar: en till vänster och en till höger.")
      isSolved2 = true
      Thread.sleep(1000)
      play3()
    else if door.toLowerCase.startsWith("b") then
      println("\nDu tänder ett ljus och får syn på inskriptioner på väggen. De varnar om ett osynligt hot som lurar i slottets mörka korridorer." +
        "\nPlötsligt faller skuggorna runt omkring dig samman och förvandlas till en mörk varelse.\n" +
        "\nSlut: Du valde att väcka det onda! Skuggvarelsen slukar dig innan du ens hinner reagera. Spelet är över.\n")
      isDead2 = true
    else
      println("Inkorrket alternativ, läs om igen: \n")
      points += 10

// bana 3

var isDead3 = false
var isSolved3 = false

def doorChoice3(): String = readLine("\nA=Öppna den vänstra dörren. \nB=Gå genom den högra dörren.\n").trim

def play3(): Unit =
  while !isDead3 && !isSolved3 do
    val door: String = doorChoice3()
    if door.toLowerCase.startsWith("b") then
      println("\nDen högra dörren leder till en lång korridor med oljelampor som tänds automatiskt när du går." +
        "\nFramför dig ser du ett bord med tre föremål: en kniv, en nyckel och en spegel.")
      isSolved3 = true
      Thread.sleep(1000)
      play4()
    else if door.toLowerCase.startsWith("a") then
      println("Den vänstra dörren leder till ett rum fyllt med fällor, spjut skjuts ut från väggarna så snart du kliver in.\n " +
        "Slut: Du träffas av ett spjut och dör omedelbart. Spelet är över.\n")
      isDead3 = true
    else
      println("Inkorrket alternativ, läs om igen:\n")

  // bana 4

var isDead4 = false
var isSolved4 = false

def doorChoice4(): String = readLine("\nA=Ta spegeln. \nB=Ta kniven.\nC=Ta nyckeln.\n").trim

def play4(): Unit =
  while !isDead4 && !isSolved4 do
    val door: String = doorChoice4()
    if door.toLowerCase.startsWith("a") then
      println("\nDu tar nyckeln och fortsätter framåt tills du når en stor dörr. Dörren är låst, men nyckeln passar perfekt. " +
        "Du låser upp dörren och stiger in i nästa rum. Rummet verkar tomt, men du märker en liten fälla på golvet.")
      isSolved4 = true
      Thread.sleep(1000)
      play5()
    else if door.toLowerCase.startsWith("b") then
      println("\nDu tar kniven och fortsätter framåt. Plötsligt attackerar ett mörkt väsen från skuggorna. " +
        "Du försöker försvara dig, men kniven är värdelös mot skuggvarelsen.\n" +
        "\nSlut: Du blev övermannad av skuggvarelsen. Spelet är över.")
      isDead4 = true
         else if door.toLowerCase.startsWith("c") then
      Thread.sleep(1000)
      println("\nDu tar spegeln och fortsätter framåt. Efter en stund stöter du på en skuggvarelse." +
        "\nDen rör sig mot dig, men du håller upp spegeln. Varelsen ser sin egen reflektion och skriker till innan den försvinner." +
        "\nDu fortsätter vidare och finner en dörr som leder ut ur slottet.\n" +
        "\nDu öppnar dörren och stiger ut i den fria luften. Bakom dig kollapsar slottet in i sig självt, och du inser att du har överlevt förbannelsen. Du är fri!")
      isSolved4 = true
    else
      println("Inkorrket alternativ, läs om igen:\n")

// bana 5

var isDead5 = false
var isSolved5 = false

def doorChoice5(): String = readLine("\nA=Försök desarmera fällan.\nB=Gå försiktigt runt fällan.\n").trim

def play5(): Unit =
  while !isDead5 && !isSolved5 do
    val door: String = doorChoice5()
    if door.toLowerCase.startsWith("b") then
      Thread.sleep(1000)
      println("\nDu lyckas smyga förbi fällan och hittar en trappa som leder uppåt. " +
        "\nDu börjar klättra uppåt och känner vinden mot ditt ansikte. Du inser att du är nära slottets utgång." +
        "\nDu öppnar dörren och stiger ut i den fria luften. Bakom dig kollapsar slottet in i sig självt, och du inser att du har överlevt förbannelsen. Du är fri!\n")
      isSolved5 = true
    else if door.toLowerCase.startsWith("a") then
      println("\nNär du försöker desarmera fällan hör du ett klick, och plötsligt slås golvet upp under dig. " +
        "\nDu faller ner i en djup avgrund.\n" +
        "\nSlut: Du faller till din död. Spelet är över.\n")
      isDead5 = true
    else
      println("Inkorrket alternativ, läs om igen:\n")