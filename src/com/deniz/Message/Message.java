package com.deniz.Message;

public class Message {
    public void divider() {
        System.out.println("-------------------------------------");
    }

    public void empty() {
        System.out.println();
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void rules() {
        System.out.println("=============>  KURALLAR  <=============");
        System.out.println("Oyun paneli genisligi min 3, max 7 olabilir.");
        System.out.println("Oyun insana karsi bilgisayar karsilasmasi seklindedir.");
        System.out.println("Oyuna once kimin baslayacagi ve kullanilacak karakterler sistem tarafindan otomatik atanmaktadir.");
        System.out.println("Karakterinizi koymak istediginiz yeri belirlediginizde once satir bilgisini sonrasinda sutun bilgisini giriniz.");
        System.out.println("Satir ve sutun bilgilerinin sayisal deger olmamasi durumunda oyun tamamen sonlanacaktir. Bu duruma dikkat edilmelidir.");
        System.out.println("Oynanmis olan karakter sonucunda herhangi bir SOS olmasi durumu var ise yapan taraf 1 puan kazanir ve bir oyun hakki daha kazanir.");
        System.out.println("Her asamada ust tarafta puanlar ve oyun alaninin son hali size gosterilecektir.");
        System.out.println("Simdi derin bir nefes alin ve eglencenin tadini cikartin...");
        System.out.println("========================================");

    }

}