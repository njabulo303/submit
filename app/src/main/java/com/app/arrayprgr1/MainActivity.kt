package com.app.arrayprgr1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Declarations
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val tvResult2 = findViewById<TextView>(R.id.tvResult2)
        val tvResult3 = findViewById<TextView>(R.id.tvResult3)
        val tvResult4 = findViewById<TextView>(R.id.tvResult4)
        val tvResult5 = findViewById<TextView>(R.id.tvResult5)
        val tvResult6 = findViewById<TextView>(R.id.tvResult6)
        val tvResult7 = findViewById<TextView>(R.id.tvResult7)

        //array declaration
        val numbers = arrayOf(1, 5, 12, 13, 10, 0, 8, 5, 6, 77, 100, 45, 76, 54, 99)

        //SIZE start
        var size = determineArraySize(numbers)
        tvResult.text = "The size of the array is ${size}"
        //SIZE end


        determineFirstAndLastElement(numbers, tvResult2)


        //SUM e and o, counter start
        var counter = 0
        var countOdd = 0
        var sumOdd = 0
        var sumEven = 0
        var avgEven = 0
        var avgOdd = 0
        for (number in numbers) {
            if (number % 2 == 0) {
                sumEven += number
                counter++
            } else {
                sumOdd += number
                countOdd++
            }
        }
        avgEven = sumEven / counter
        avgOdd = sumOdd / countOdd
        tvResult5.text = "The sum of even numbers is ${sumEven} and the avg is ${avgEven}"
        tvResult6.text = "The sum of odd numbers is ${sumOdd} and the avg is ${avgOdd}"

        tvResult3.text = "The array has ${countOdd} odd numbers and ${counter} even numbers."
        //SUM e and o, counter end


        //SUM all start
        var sum = 0
        var average = 0
        for (number in numbers) {
            sum += number
        }
        average = sum / size
        tvResult4.text = "The sum of all element is ${sum} and the average is ${average}"
        //SUM all end


        //HIghest start
        var highest = numbers[0]
        var multipleOf3 = false
        for (number in numbers) {
            if (number > highest) {
                highest = number

            }
        }

        //HIghest end

        //Multiple of 3 start
        if (highest % 3 == 0) {
            multipleOf3 = true
        }

        if (multipleOf3) {
            tvResult7.text = "Hightest is $multipleOf3 and it is a mukltiple of 3"
        } else {
            tvResult7.text = "Hightest is and it is not a mukltiple of 3"
        }


        //Multiple of 3 end
    }

    fun determineArraySize(numbers: Array<Int>): Int {
        return numbers.size
    }


    fun calculateTax(salary: Double, insurance: Double, comm: Double): Double {
        var tax = salary - insurance + comm
        return tax
    }

    fun determineFirstAndLastElement(numbers: Array<Int>, textView: TextView) {
        var size = numbers.size
        //FIRST and LAST start
        var firstNumber = numbers[0]
        var lastNumber = numbers[size - 1]

        textView.text = "The first element is ${firstNumber} and the last element is ${lastNumber}"
        //FIRST and LAST end
    }
}