package thirtydaychallenge

object GroupAnagram {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        strs.forEach {
            val chars = IntArray(26)
            it.chars().forEach { char ->
                chars[char.minus('a'.code)] += 1
            }

            val key = chars.joinToString()
            if(map[key] == null) {
                map[key] = mutableListOf(it)
            } else {
                val list = map[key]!!
                list.add(it)
                map[key] = list
            }
        }

        return map.entries.map { it.value }
    }
}


fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val result = GroupAnagram.groupAnagrams(strs)
    println(result)
}
