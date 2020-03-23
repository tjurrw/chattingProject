public class NissanEngine implements Engine {
    public NissanEngine(){
        super();
    }

    public void boot(){
        System.out.println("닛산 엔진 가동.");
    }

    public void stop(){
        System.out.println("닛산 엔진 정지.");
    }
}