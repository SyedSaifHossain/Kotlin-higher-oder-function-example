fun main(args: Array<String>) {

    //addition function has been called here and use add function as a parameter
    addition(5,3,{add ->
        println("Sum = ${add}")
    })

    //addition function has been called here and interface use as a parameter
    addition(10,5,object:MySum{
        override fun execute(sum: Int) {
            println("Sum = ${sum}")
        }
    })

    // Make a variable and contain addNumber function

    var add =::addNumber

    //call addingNumber function pass add variabel as a parameter and pass value of a and b.
    addingNUmber(add,15,10)
}
//Higher order functjion using parameter
fun addition(a:Int, b:Int, myAdd:(Int)->Unit){

    var sum  = a+b
    myAdd(sum)
}

//Interface as a higher order function
fun addition(a:Int, b:Int, action:MySum){

    var sum  = a+b
    action.execute(sum)
}

//Interface has been created here
interface MySum{
    fun execute(sum:Int)
}
//Create a function addNumber and return a and b
fun addNumber(a:Int,b:Int):Int{
    return a+b
}
//Create another function and use higher order function as add then print result
fun addingNUmber(add:(Int,Int)->Int,a:Int,b:Int){

    var result = add(a,b)

    println("sum = ${result}")
}