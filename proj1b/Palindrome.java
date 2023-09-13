public class Palindrome {
    /** String -> Deque type */
    public Deque<Character> wordToDeque(String word) {
        assert word != null && !word.equals("");
        Deque<Character> dq = new LinkedListDeque<>();
        int wLen = word.length();
        for (int i = 0; i < wLen; i++) {
            dq.addLast(word.charAt(i));
        }
        return dq;
    }


//    public boolean isPalindrome(String word) {
//        if (word == null || word.length() <= 1) {
//            return true;
//        }
//        Deque<Character> dq = wordToDeque(word);
//        /** 使用双指针法检测字符串是否是回文
//         * dq.size() -1 索引是从0开始的，但是size是从1开始的， 注意-1
//         */
//        int start = 0;
//        int end = dq.size() -1;
//        while (start < end) {
//            boolean b = dq.removeFirst().equals(dq.removeLast());
//            if (!b) {
//                return false;
//            }
//            start += 1;
//            end -= 1;
//        }
//        return true;
//    }


    private String DequeToString(Deque d) {
        String string = "";
        while (d.size() > 0) {
            string += d.removeFirst();
        }
        return string;
    }

    public boolean isPalindrome(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        Deque<Character> worddeque = wordToDeque(word);

        if (worddeque.size() == 0 || worddeque.size() == 1) {
            return true;
        } else {

            if (worddeque.removeFirst() == worddeque.removeLast()) {
                return isPalindrome(DequeToString(worddeque));
            } else {
                return false;
            }
        }
    }


    public boolean isPalindrome(String word, CharacterComparator c) {
        if (word == null || word.length() <= 1) {
            return true;
        }

        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (!c.equalChars(word.charAt(i),word.charAt(len - i - 1))) {
                return false;
            }
        }

        return true;
    }



}

