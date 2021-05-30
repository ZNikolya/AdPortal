package homework.adPortal.impl;

public interface Commands {

    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;


    int LOGOUT = 0;
    int ADD_NEW_AD = 1;
    int PRINT_MY_ALL_ADS = 2;
    int PRINT_ALL_ADS = 3;
    int PRINT_AD_BY_CATEGORY = 4;
    int DELETE_MY_ALL_ADS = 5;
    int DELETE_AD_BY_TITLE = 6;



    static void printSecondPageCommands() {

        System.out.println("Ներմուծեք " + EXIT + " դուրս գալու համար");
        System.out.println("Ներմուծեք " + LOGIN + " մուտք գործելու համար");
        System.out.println("Ներմուծեք " + REGISTER + " գրանցվելու համար");
    }

    static void printUserCommands() {
        System.out.println("Ներմուծեք " + LOGOUT + " առաջին էջ վերադառնալու համար");
        System.out.println("Ներմուծեք " + ADD_NEW_AD + " հայտարարություն ավելացնելու համար");
        System.out.println("Ներմուծեք " + PRINT_MY_ALL_ADS + " ձեր հայտարաությունները տեսնելու համար");
        System.out.println("Ներմուծեք " + PRINT_ALL_ADS + " բոլոր հայտարարությունները տեսնելու համար");
        System.out.println("Ներմուծեք " + PRINT_AD_BY_CATEGORY + " տեսնել հայտարարությունները ըստ տրված կատեգորիաի");
        System.out.println("Ներմուծեք " + DELETE_MY_ALL_ADS + " ձեր հայտարարությունները ջնջելու համար");
        System.out.println("Ներմուծեք " + DELETE_AD_BY_TITLE + " տրված վերնագրով հայտարարությունները ջնջելու համար");
    }

}
