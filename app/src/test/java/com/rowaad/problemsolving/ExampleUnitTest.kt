package com.rowaad.problemsolving

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun binarySearch() {
        val expec=binarySearch(listOf(1,3,5,7,9),7)
        //assertEquals(3,expec)
        //assertEquals(0,binarySearch(listOf(1,3,5,7,9),1))
        //assertEquals(2,binarySearch(listOf(1,3,5,7,9),5))
        //assertEquals(-1,binarySearch(listOf(1,3,5,7,9),4))
        assertEquals(4,binarySearch(listOf(1,3,5,7,9),9))

    }
    @Test
    fun binarySearchApply() {
        assert(isPerfectSquareBinary(listOf(1,2,3,4,8,10,16,21,64),64))
    }


    @Test
    fun rotatedBinaryArray() {
        assertEquals(1,sortedRotatedArray(listOf(4,5,6,7,8,0,1,2),5))
        //assertEquals(1,sortedRotatedArray(listOf(2,3,4,8,0,1),3))
    }
    @Test
    fun sorted2dBinaryArray() {

        //assertEquals(1,sortedRotatedArray(listOf(2,3,4,8,0,1),3))
        val matrix=arrayOf(arrayOf(1,2,3),arrayOf(4,5,6),arrayOf(7,8,9))
        val exp=sorted2dArray(matrix,3)
        //assertEquals(2,exp)
    }



    fun sorted2dArray(matrix: Array<Array<Int>>,target: Int):Int {
        var startIndex=0
        //rows
        var r=matrix.size
        //cols
        var j=matrix[0].size
        //end position
        var endIndex=(r*j)-1

        var keyPosition=-1
        while (startIndex<=endIndex) {
            val midIndex = (startIndex + endIndex) / 2
            when {
                //a[i]=M[I/c][i%c]

                target > matrix[midIndex/j][midIndex%j] -> {
                    startIndex=midIndex+1
                }
                //inCase key < mid index value -> end index shift to mid - 1
                target < matrix[midIndex/j][midIndex%j] -> {
                    endIndex=midIndex-1
                }
                //inCase key == mid index value -> end index shift to mid - 1
                target==matrix[midIndex/j][midIndex%j] -> {
                    keyPosition=midIndex
                    startIndex=endIndex+1
                }
            }
        }

        return keyPosition
    }

    fun binarySearch(numbers:List<Int>,key:Int) :Int{
        var startIndex=0
        var endIndex=numbers.lastIndex
        var keyPosition=-1

        while (startIndex<=endIndex){

            val midIndex=(startIndex+endIndex)/2

            //inCase key > mid index value -> start index shift to mid + 1
            when {
                key > numbers[midIndex] -> {
                    startIndex=midIndex+1
                }
                //inCase key < mid index value -> end index shift to mid - 1
                key < numbers[midIndex] -> {
                    endIndex=midIndex-1
                }
                //inCase key == mid index value -> end index shift to mid - 1
                key==numbers[midIndex] -> {
                    keyPosition=midIndex
                    startIndex=endIndex+1
                }
            }
        }
        return keyPosition
    }

    fun isPerfectSquareBinary(numbers:List<Int>,key:Int) :Boolean{
        var startIndex=0
        var endIndex=numbers.lastIndex
        var keyPosition=false

        while (startIndex<=endIndex){

            val midIndex=(startIndex+endIndex)/2

            //inCase key > mid index square value -> start index shift to mid + 1
            when {
                key > numbers[midIndex]*numbers[midIndex]  -> {
                    startIndex=midIndex+1
                }
                //inCase key < mid index value square -> end index shift to mid - 1
                key < numbers[midIndex]*numbers[midIndex] -> {
                    endIndex=midIndex-1
                }
                //inCase key == mid index value square -> end index shift to mid - 1
                key==numbers[midIndex]*numbers[midIndex] -> {
                    keyPosition=true
                    startIndex=endIndex+1
                }
            }
        }
        return keyPosition
    }

    //4,5,6,7,0,1,2

    fun sortedRotatedArray(numbers:List<Int>,target:Int) :Int {
        var startIndex = 0
        var endIndex = numbers.lastIndex
        var targetPosition = -1

        while (startIndex <= endIndex) {
            val midIndex=(startIndex+endIndex)/2

            if (numbers[midIndex]==target)   targetPosition=midIndex
            //if right part is sorted
            if (numbers[midIndex] >= numbers[startIndex]){
                if (target < numbers[midIndex] && target >= numbers[startIndex]){
                    endIndex=midIndex-1
                }
                else{
                    startIndex=midIndex+1
                }
            }
            //if left part is sorted
            else{
                if (target > numbers[midIndex] && target <= numbers[endIndex]){
                    startIndex=midIndex+1
                }
                else{
                    endIndex=midIndex-1
                }
            }
        }
        return targetPosition
    }

}