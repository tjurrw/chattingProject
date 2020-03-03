import java.util.Scanner;

public class algorithm {
    static Scanner sc = new Scanner(System.in);

    //회원번호, 이름
    static class Data{
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        Integer keyCode(){
            return no;
        }

        public String toString(){
            return name;
        }

        void scanData(String guide, int sw){
            System.out.println(guide + "할 데이터를 입력해 주십시오.");

            //질문1. 비트 연산자 비교가 필요한 이유
            if((sw & NO) == NO){
                System.out.println("번호 : ");
                no = sc.nextInt();
            }
            if((sw & NAME) == NAME){
                System.out.println("이름 : ");
                name = sc.next();
            }
        }
    }

    //메뉴 열거
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

    public static void main(String[] args) {
        Menu menu;
        Data data;
        Data temp = new Data();

        ChainHash<Integer, Data> hash = new ChainHash<Integer, Data>(13);

        do{
            switch(menu = SelectMenu()){
                case ADD:
                    data = new Data();
                    data.scanData("추가", Data.NO | Data.NAME);
                    hash.add(data.keyCode(), data);
                    break;

                case REMOVE:
                    temp.scanData("삭제", Data.NO);
                    hash.remove(temp.keyCode());
                    break;

                case SEARCH:
                    temp.scanData("검색", Data.NO);
                    Data t = hash.search(temp.keyCode());
                    if(t != null)
                        System.out.println("해당 검색값을 갖는 데이터는 " + t + "입니다.");
                    else
                        System.out.println("해당 데이터는 존재하지 않습니다.");
                    break;

                case DUMP:
                    hash.dump();
                    break;
            }
        }while(menu != Menu.TERMINATE);
    }
}