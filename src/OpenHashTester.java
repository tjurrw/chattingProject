import java.util.Scanner;

public class OpenHashTester {
    static Scanner sc = new Scanner(System.in);

    //회원번호, 이름
    static class Data{
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        String keyCode(){
            return name;
        }

        public String toString(){
            return Integer.toString(no);
        }

        void scanData(String guide, int sw){
            System.out.println(guide + "할 데이터를 입력해 주십시오.");

            //질문1. 비트 연산자 비교가 필요한 이유
            if((sw & NO) == NO){ //sw = 1, 2, 3(각 수를 이진법으로 풀어볼 것)
                System.out.println("번호 : ");
                no = sc.nextInt();
            }
            if((sw & NAME) == NAME){
                System.out.println("이름 : ");
                name = sc.next();
            }
        }
    }



    //메뉴 열거형
    enum Menu{
        ADD("추가"),
        REMOVE("제거"),
        SEARCH("검색"),
        DUMP("표시"),
        TERMINATE("종료");

        private final String message;

        static Menu MenuAt(int idx){
            for(Menu m : Menu.values())
                if(m.ordinal() == idx)
                    return m;
            return null;
        }

        //생성자
        Menu(String string){
            message = string;
        }

        String getMessage(){
            return message;
        }
    }

    //메뉴 선택
    static Menu SelectMenu(){
        int key;

        do{
            for(Menu m : Menu.values())
                System.out.printf("(%d) %s   ", m.ordinal(), m.getMessage());
            System.out.print(" : ");
            key = sc.nextInt();
        } while(key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }



    public static void main(String[] args){
        Menu menu;
        Data data; //추가용 데이터 참조
        Data temp = new Data();

        OpenHash<String, Data> hash = new OpenHash<String, Data>(13);

        do{
            switch(menu = SelectMenu()){
                case ADD:
                    data = new Data();
                    data.scanData("추가", Data.NO | Data.NAME);
                    int k = hash.add(data.keyCode(), data);
                    switch(k){
                        case 1:
                            System.out.println("해당 키는 이미 등록되어 있습니다.");
                            break;
                        case 2:
                            System.out.println("해시표가 남은 공간이 없습니다.");
                            break;
                    }

                     break;

                case REMOVE:
                    temp.scanData("삭제", Data.NAME);
                    hash.remove(temp.keyCode());
                    break;

                case SEARCH:
                    temp.scanData("탐색", Data.NAME);
                    Data t = hash.search(temp.keyCode());
                    if(t != null)
                        System.out.println("해당 검색값은 " + t + "입니다.");
                    else
                        System.out.println("해당 검색값은 존재하지 않습니다.");
                    break;

                case DUMP:
                    hash.dump();
                    break;
            }
        }while(menu != Menu.TERMINATE);
    }
}
