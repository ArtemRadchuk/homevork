public class Age {
    public static void main(String[] args) {
        int vasyaAge = 10;
        int katyaAge = 20;
        int mishaAge = 30;
        int minimalage = -1;
        int middleage = -1;
        int maxage = -1;

        //Ищем кто старше
        if (vasyaAge >= katyaAge & vasyaAge >= mishaAge) {
            maxage = vasyaAge;
        } else if (katyaAge >= vasyaAge & katyaAge >= mishaAge) {
            maxage = katyaAge;
        } else if (mishaAge >= katyaAge & mishaAge >= vasyaAge) {
            maxage = mishaAge;
        }


        //Ищем кто младше
        if (vasyaAge <= katyaAge & vasyaAge <= mishaAge) {
            minimalage = vasyaAge;
        } else if (katyaAge <= vasyaAge & katyaAge <= mishaAge) {
            minimalage = katyaAge;
        } else if (mishaAge <= katyaAge & mishaAge <= vasyaAge) {
            minimalage = mishaAge;
        }

        //Ищем среднего
        if (katyaAge <= mishaAge & katyaAge >= vasyaAge) {
            middleage = katyaAge;
        }else if (katyaAge >= mishaAge & katyaAge <= vasyaAge) {
            middleage = katyaAge;
        }
        else if (mishaAge >= katyaAge & mishaAge <= vasyaAge) {
            middleage = mishaAge;
        }
        else if (mishaAge <= katyaAge & mishaAge >= vasyaAge) {
            middleage = mishaAge;
        } else if (vasyaAge <= mishaAge & vasyaAge >= katyaAge) {
            middleage = vasyaAge;
        }else if (vasyaAge >= mishaAge & vasyaAge <= katyaAge){
            middleage = vasyaAge;
        }


        System.out.println("Младшему");
        System.out.println(minimalage);
        System.out.println("Среднему");
        System.out.println(middleage);
        System.out.println("Старшему");
        System.out.println(maxage);
    }
}

