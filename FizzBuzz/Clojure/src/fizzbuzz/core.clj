(ns fizzbuzz.core)

(defn -main []
	(println
		(for [x (range 1 100)]	
			(if (and (= (mod x 3) 0) (= (mod x 5) 0)) "FizzBuzz"
				(if (= (mod x 3) 0) "Fizz"
					(if (= (mod x 5) 0) "Buzz" x)
				)
			)
		)
	)
)