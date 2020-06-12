package thirtydaychallenge

object SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var result: Int = nums[0]
        for (i in 1 until nums.size) {
            result = result xor nums[i]
        }

        return result
    }
}
