package thirtydaychallenge

object HappyNumber {
    private fun numSquared(n: Int): Int {
        var num = n
        var result = 0;
        while (num != 0) {
            result += (num % 10) * (num % 10)
            num /= 10
        }
        return result
    }

    fun isHappy(n: Int): Boolean {
        var slow = n
        var fast = n

        do {
            slow = numSquared(slow)
            fast = numSquared(numSquared(fast))
        } while (slow != fast)

        return slow == 1
    }
}
