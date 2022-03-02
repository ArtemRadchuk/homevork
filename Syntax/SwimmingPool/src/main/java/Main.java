public class Main {
    public static void main(String[] args) {
        int volume = 1200; //litres
        int fillingSpeed = 30; //30 litres per minute
        int devastationSpeed = 10; //10 litres per minute
        int tvolume = 0;
        int t = 0;
        while (tvolume < volume){
            tvolume = tvolume + fillingSpeed - devastationSpeed;
            t++;
            if(tvolume ==volume){}
            System.out.println(t+ " minutes");
        }
    }
}
