import scala.io.StdIn.readLine
import scala.util.Random

object Main extends App {
  val speech = """Four score and
                 |seven years ago
                 |our fathers ...""".stripMargin

  System.err.println("yikes, an error happened")

  println(speech)

  print("Enter your first name: ")
  val firstName = readLine()

  print("Enter your last name: ")
  val lastName = readLine()

  if (firstName == lastName) println(s"your first name and last name is $firstName") else println(s"Your name is $firstName $lastName")

  val a = Random.nextInt(500)
  val b = Random.nextInt(500)
  println(s"smallest number out of randomized two is ${if (a < b) a else b} (a = $a, b = $b)")

  val nums = Seq(1,2,3)
  for (n <- nums) println(n)

  val people = List(
    new Person("Bill","One", "child molester"),
    new Person("Candy","Two", "hooker"),
    new Person("Karen","Three", "manager caller"),
    new Person("Leo","Four", " meth addict"),
    new Person("Regina","Five", "pole dancer"))

  for (p <- people) println(p.printFullName())
  //or
  people.foreach(person => println(s"Look who's commin' -  ${person.printFullName()}"))

  val ratings = Map(
    "Lady in the Water"  -> 3.0,
    "Snakes on a Plane"  -> 4.0,
    "You, Me and Dupree" -> 3.5
  )

  for ((name,rating) <- ratings) println(s"Movie: $name, Rating: $rating")
  //or
  ratings.foreach { case(movie, rating) => println(s"key: $movie, value: $rating") }

  //You can create a new list of integers where all of the values are doubled, like this:
  val doubledNums = for (n <- nums) yield n * 2
  doubledNums.foreach(println)

  var names = List("adam", "david", "frank")
  val ucNames = for (name <- names) yield name.capitalize
  ucNames.foreach(println)

  names = List("_adam", "_david", "_frank")

  val capNames = for (name <- names) yield name.drop(1).capitalize

//  or like this
//  val capNames = for (name <- names) yield { name.drop(1).capitalize }

//  or like this
//  val capNames = for (name <- names) yield {
//    val nameWithoutUnderscore = name.drop(1)
//    val capName = nameWithoutUnderscore.capitalize
//    capName
//  }
  capNames.foreach(println)

  val i = Random.nextInt(13)
  val monthName: Unit = i match {
    case 1  => println("January")
    case 2  => println("February")
    case 3  => println("March")
    case 4  => println("April")
    case 5  => println("May")
    case 6  => println("June")
    case 7  => println("July")
    case 8  => println("August")
    case 9  => println("September")
    case 10 => println("October")
    case 11 => println("November")
    case 12 => println("December")
    case _  => println("Invalid month")     // catch the default with a variable so you can print it
  }

  //Scala methods
  def convertBooleanToStringMessage(bool: Boolean): String = {
    if (bool) "true" else "false"
  }
  var answer = convertBooleanToStringMessage(true)
  println(answer)
  answer = convertBooleanToStringMessage(false)
  println(answer)

  //Using a match expression as the body of a method
  def convertBooleanToStringMessage2(bool: Boolean): String = bool match {
    case true => "you said true"
    case false => "you said false"
  }

  answer = convertBooleanToStringMessage2(true)
  println(answer)
  answer = convertBooleanToStringMessage2(false)
  println(answer)

  //Handling alternate cases
  def isTrue(a: Any) = a match {
    case 0 | "" => false
    case _ => true
  }

  println(isTrue(0))
  println(isTrue(""))
  println(isTrue(1.1F))

  //how to handle multiple strings in multiple case statements:
  def takeStringReturnMoreText(str: String): Unit = str match {
    case "start" | "go" => println("starting")
    case "stop" | "quit" | "exit" => println("stopping")
    case _ => println("doing nothing")
  }

  takeStringReturnMoreText("start")
  takeStringReturnMoreText("exit")

  def count(x: Any): Unit = x match {
    case 1 => println("one, a lonely number")
    case x if x == 2 || x == 3 => println("two's company, three's a crowd")
   // case x if x > 3 => println("4+, that's a party")
    case _ => println("i'm guessing your number is zero or less")
  }

  count(5)

  def guessNumber(x: Int): Unit = x match {
    case a if 0 to 9 contains a => println("0-9 range: " + a)
    case b if 10 to 19 contains b => println("10-19 range: " + b)
    case c if 20 to 29 contains c => println("20-29 range: " + c)
    case _ => println("Hmmm...")
  }

  guessNumber(Random.nextInt(40))

}

class Person(var firstName: String, var lastName: String, var job: String) {
  def printFullName(): Unit = println(s"it's a $firstName $lastName, a local $job")
}