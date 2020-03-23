public class Main {
    public static void main(String[] args){
        Engine hondaEngine1 = new HondaEngineVer2();
        Engine hondaEngine2 = new HondaEngineVer2();
        Engine nissanEngine1 = new NissanEngine();

        Car car1 = new Car(hondaEngine1);
        Car car2 = new Car(hondaEngine2);
        Car car3 = new Car(nissanEngine1);
    }
}