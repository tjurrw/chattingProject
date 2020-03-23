public class Car {
    private Engine engine;

    //생성자
    public Car(Engine engine){
        this.engine = engine;
    }

    public void engineStart(){
        engine.boot();
    }

    public void engineStop(){
        engine.stop();
    }
}
