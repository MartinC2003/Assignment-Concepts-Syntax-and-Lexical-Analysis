import java.nio.charset.StandardCharsets;
import java.nio.file.*;


public class Test1{
    public static void main(String[] args) {
        
    
    Path path = Path.of("PartB.java");
    try{
        String code = Files.readString(path, StandardCharsets.UTF_8);
        int pre = code.indexOf("static int[]");
        int post = code.indexOf("x;");

        //System.out.println(pre);
        //System.out.println(post);
        System.out.println(code.substring(pre,post+2));

    }catch(Exception e){

    }


    }
}