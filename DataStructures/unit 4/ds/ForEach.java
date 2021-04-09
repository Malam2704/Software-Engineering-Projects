package ds;

public class ForEach {
    public static void forArray(String[] array) {
        for(String value : array){
            System.out.println(value);
        }
    }

    public static void forList(List<String> list) {
        for(String value : list){
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        String[] strings = {"abc","def","ghi"};
        forArray(strings);

        List<String> one = new LinkedList<>();
        one.append("abc");
        one.append("def");
        one.append("ghi");
        forList(one);

        List<String> two = new ArrayList<>();
        two.append("123");
        two.append("456");
        two.append("789");
        forList(two);
    }
}
