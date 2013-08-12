numberToRomanMap = [
		1000:"M", 
		900:"CM", 500:"D", 400:"CD", 100:"C",
		90:"XC", 50:"L", 40:"XL", 10:"X",
		9:"IX", 5:"V", 4:"IV", 1:"I"
	]

def toRomanNumber(int number) {
	def sortedKeys = numberToRomanMap.keySet().sort().reverse()
	String roman = ""
	while (number > 0) {		
		def digit = sortedKeys.find { it <= number }
		number -= digit
		roman += numberToRomanMap.get(digit)
	}
	roman
}

def toNumber(String romanNumber) {
	def sum = 0
	def maxIndex = romanNumber.length() - 1
	def sumArray = [] as List
	romanNumber.eachWithIndex { it, ix ->
		numberToRomanMap.each { key, value -> 
			if (value == it) {
				sumArray << key
				if (sumArray.size() >= 2) {
					def test = sumArray[sumArray.size() - 2] - sumArray[sumArray.size() - 1]
					// si la suma es negativa es porque el ultimo valor es mayor al penultimo valor insertado en sumArray
					if (test < 0) {
						// anular los dos valores anteriores
						sumArray << (sumArray[sumArray.size() - 1] + sumArray[sumArray.size() - 2]) * -1
						// dejar el valor bueno
						sumArray << test * -1
					}
				}
			}
		}	
	}
	sumArray.each { sum += it }
	sum
}

assert toRomanNumber(3) == "III"
assert toRomanNumber(5) == "V"
assert toRomanNumber(6) == "VI"
assert toRomanNumber(61) == "LXI"
assert toRomanNumber(1000) == "M"
assert toRomanNumber(2000) == "MM"
assert toRomanNumber(3001) == "MMMI"
assert toRomanNumber(5000) == "MMMMM"

assert toNumber('I') == 1
assert toNumber('II') == 2
assert toNumber('III') == 3
assert toNumber('IV') == 4
assert toNumber('VI') == 6
assert toNumber('XVI') == 16
assert toNumber('CM') == 900
assert toNumber('CMI') == 901