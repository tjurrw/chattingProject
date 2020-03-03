public class OpenHash<K, V> {
    //버킷 상태
    enum Status{OCCUPIED, EMPTY, DELETED};

    //버킷
    static class Bucket<K, V>{
        private K key; //키값
        private V data; //데이터
        private Status stat; //상태

        //생성자
        Bucket(){
            stat = Status.EMPTY;
        }

        void set(K key, V data, Status stat){
            this.key = key;
            this.data = data;
            this.stat = stat;
        }

        void setStat(Status stat){
            this.stat = stat;
        }

        K getKey(){
            return key;
        }

        V getValue(){
            return data;
        }

        public int hashCode(){
            return key.hashCode();
        }
    }

    private int size;
    private Bucket<K, V>[] table;

    //생성자
    public OpenHash(int size){
        try{
            table = new Bucket[size];
            for(int i = 0; i < size; i++)
                table[i] = new Bucket<K, V>();
            this.size = size;
        } catch(OutOfMemoryError e){
            this.size = 0;
        }
    }

    //해시값 산출
    public int hashValue(Object key){
        return key.hashCode() % size;
    }

    //해시값 재계산
    public int rehashValue(int hash){
        return (hash + 1) % size;
    }

    //검색값을 보유한 버킷을 검색
    private Bucket<K, V> searchNode(K key){
        int hash = hashValue(key); //탐색할 데이터의 해시값
        Bucket<K, V> p = table[hash]; //검색할 버킷

        for(int i = 0; p.stat != Status.EMPTY && i < size; i++){
            if(p.stat == Status.OCCUPIED && p.getKey().equals(key))
                return p;
            hash = rehashValue(hash);
            p = table[hash];
        }
        return null;
    }

    //검색값 key를 갖는 요소를 반환
    public V search(K key){
        Bucket<K, V> p = searchNode(key);
        if(p != null)
            return p.getValue();
        else
            return null;
    }

    //key, data 값을 갖는 요소의 추가
    public int add(K key, V data){
        if(search(key) != null)
            return 1;

        int hash = hashValue(key);
        Bucket<K, V> p = table[hash];
        for(int i = 0; i < size; i++){
            if(p.stat == Status.EMPTY || p.stat == Status.DELETED){
                p.set(key, data, Status.OCCUPIED);
                return 0;
            }
            hash = rehashValue(hash);
            p = table[hash];
        }
        return 2;
    }

    //검색값을 갖는 요소의 삭제
    public int remove(K key){
        Bucket<K, V> p = searchNode(key);
        if(p == null)
            return 1;

        p.setStat(Status.DELETED);
        return 0;
    }

    //해시값을 덤프
    public void dump(){
        for(int i = 0; i < size; i++){
            System.out.printf("%02d", i);
            switch(table[i].stat){
                case OCCUPIED:
                    System.out.printf("%s (%s)\n", table[i].getKey(), table[i].getValue());
                    break;

                case EMPTY:
                    System.out.println("-- 미등록 --");
                    break;

                case DELETED:
                    System.out.println("-- 삭제완료 --");
                    break;
            }
        }
    }
}