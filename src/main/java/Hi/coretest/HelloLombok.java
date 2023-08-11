package Hi.coretest;

import lombok.Data;

@Data
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok=new HelloLombok();
        helloLombok.setAge(17);
        int age1 = helloLombok.getAge();

        System.out.println(age1);
    }
}
