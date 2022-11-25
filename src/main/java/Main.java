public class Main {
    public static void main(String[] args) {
        
        int i = 0;
        
        try{
            System.out.println("Finally block cant be null bug");
        }catch (Exception e){

        }finally {
            throw new IllegalAccessError();

        }
    }

    public int error(int i){
        return i;
    }

     public int secondBranchInput(int i){
        return i;
    }
}
