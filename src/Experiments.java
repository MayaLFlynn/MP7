public class Experiments {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        byte[] b = "alyssa".getBytes();
        System.out.println((new Hash (b)).getData());
        System.out.println((new Hash (b)).toString());
        System.out.println((new Hash (b)).isValid());
        System.out.println((new Hash (b)).equals(new Hash (b))); 
    }
}
