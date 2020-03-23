public class HondaEngineVer2 extends HondaEngine {
    //생성자
    public HondaEngineVer2(){
        super();
    }

    @Override
    public void boot(){
        System.out.println("혼다 엔진 가동(Ver2).");
    }

    @Override
    public void stop(){
        System.out.println("혼다 엔진 정지(Ver2).");
    }
}
