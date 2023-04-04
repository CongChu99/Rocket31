public class StringDemo {
    public static void main(String[] args) {
        // Primitive & Object

        // Primitive
        String s1 = "Java";
        String s4 = "Java";

        // Object
        String s2 = new String("Java");
        String s3 = new String("Java");

        boolean r1 = s1.equals(s4);
        boolean r2 = s1.equals(s3);
        boolean r3 = s2.equals(s3);

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);

        // == : So sánh địa chỉ
        // equals: So sánh nội dung

        // method
        String name = "khoa";
        String upper = name.toUpperCase();
        System.out.println("name = " + name);
        System.out.println("upper = " + upper);
    }
}
