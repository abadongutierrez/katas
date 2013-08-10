def list1 = new ArrayList();
def list2 = new ArrayList();

(1..100).each { i ->
	if (i % 3 == 0 && i % 5 == 0) list1.add("FizzBuzz")
	else if (i % 3 == 0) list1.add("Fizz")
	else if (i % 5 == 0) list1.add("Buzz")
	else list1.add(i)
}

println list1

(1..100).each { i ->
	if (i % (5*3) == 0) list2.add("FizzBuzz")
	else if (i % 3 == 0) list2.add("Fizz")
	else if (i % 5 == 0) list2.add("Buzz")
	else list2.add(i)
}

println list2

(0..99).each { i ->
	if (list1.get(i) != list2.get(i)) throw new Exception("Error")
}

println "Son iguales"