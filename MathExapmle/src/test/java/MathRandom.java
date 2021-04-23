public class MathRandom {

    public static void main(String[] args) {
        MathRandomInteger();
    }

    public static void MathRandomInteger(){

        for(int i = 0; i <10; i++){
            int a = (int) (Math.random() *(50));
            System.out.println(a);
        }

    }
}
