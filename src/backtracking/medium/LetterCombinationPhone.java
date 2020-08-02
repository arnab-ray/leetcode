package backtracking.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhone {
    private void letterCombinationUtil(String digits, int i, List<String> result, Map<Character, List<Character>> map, StringBuilder sb) {
        if(i == digits.length() - 1) {
            for(Character c : map.get(digits.charAt(i))) {
                sb.append(c);
                result.add(sb.toString());
                sb.setLength(sb.length() - 1);
            }
        } else if (i < digits.length() - 1) {
            for(Character c : map.get(digits.charAt(i))) {
                sb.append(c);
                letterCombinationUtil(digits, i + 1, result, map, sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty())
            return new LinkedList<>();
        Map<Character, List<Character>> map = new HashMap<>();
        List<Character> list = new LinkedList<>();
        list.add('a');list.add('b');list.add('c');
        map.put('2', list);

        list = new LinkedList<>();
        list.add('d'); list.add('e'); list.add('f');
        map.put('3', list);

        list = new LinkedList<>();
        list.add('g'); list.add('h'); list.add('i');
        map.put('4', list);

        list = new LinkedList<>();
        list.add('j'); list.add('k'); list.add('l');
        map.put('5', list);

        list = new LinkedList<>();
        list.add('m'); list.add('n'); list.add('o');
        map.put('6', list);

        list = new LinkedList<>();
        list.add('p'); list.add('q'); list.add('r'); list.add('s');
        map.put('7', list);

        list = new LinkedList<>();
        list.add('t'); list.add('u'); list.add('v');
        map.put('8', list);

        list = new LinkedList<>();
        list.add('w'); list.add('x'); list.add('y'); list.add('z');
        map.put('9', list);

        StringBuilder sb = new StringBuilder();
        List<String> result = new LinkedList<>();
        letterCombinationUtil(digits, 0, result, map, sb);

        return result;
    }
}
