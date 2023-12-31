package Hi.coretest.lifecycle;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("url = " + url);
        connect();
        call("초기호 연결 메시지");
    }


    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect = " + url);
    }

    public void call(String message){
        System.out.println("call = " + url + "message = " + message);
    }

    public void disconnect(){
        System.out.println("close : " + url);
    }
}
