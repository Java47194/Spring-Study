package Hi.coretest.singleton;

public class SingletonService {
    public static final SingletonService instance = new SingletonService();


    public static SingletonService getInstance(){
        return instance;
    }
    //new 생성자 방지
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 패턴 로직 호출");
    }
}
