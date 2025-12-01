import java.io.File

fun main(args: Array<String>) {
	require(args.size == 1) { "You must give one argument only." }	
	readFile(args[0]);
	println("pointingTo = ${Count.pointingTo}")
	println("numberOfZero = ${Count.numberOfZero}")

}

fun readFile(fileName: String) {
	File(fileName).forEachLine { 
		rotationAction(it)
	}
}

fun rotationAction(action: String)
{
	val number = action.drop(1).toInt()
	val start = Count.pointingTo

	var zeroCount = 0
	if (action[0] == 'R') {
		repeat(number) { step ->
			Count.pointingTo = (Count.pointingTo + 1) % 100
			if (Count.pointingTo == 0) zeroCount++
		}
	} else if (action[0] == 'L') {
		repeat(number) { step ->
			Count.pointingTo = (Count.pointingTo - 1 + 100) % 100
			if (Count.pointingTo == 0) zeroCount++
		}
	}
	Count.numberOfZero += zeroCount
}

object Count {
	var pointingTo = 50;
	var numberOfZero = 0;
}
