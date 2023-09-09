/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        /**
         *  == 运算符比较的是对象的引用
         *  在java中，对于基本数据类型的包装类，存在一个缓存的机制。范围在-128到127之间的Integer对象会被缓存
         *  在缓存范围内返回true，因为他们都是对同一个缓存对象的比对
         *  这行代码会在128及以后的判断中返回false，
         */
//        return a == b;
        return a.equals(b);
    }
}
