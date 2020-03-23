public class HondaEngine implements Engine {
    //생성자
    public HondaEngine(){
        super();
    }

    @Override
    public void boot(){
        System.out.println("혼다 엔진 가동.");
    }

    @Override
    public void stop(){
        System.out.println("혼다 엔진 정지.");
    }
}