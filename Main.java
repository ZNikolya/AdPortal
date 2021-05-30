package homework.adPortal;

import homework.adPortal.enums.Category;
import homework.adPortal.enums.Gender;
import homework.adPortal.exception.TypeNotFoundException;
import homework.adPortal.impl.Commands;
import homework.adPortal.model.Advertisment;
import homework.adPortal.model.User;
import homework.adPortal.storage.OverallStorage;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main implements Commands{

    private static final Scanner scanner = new Scanner(System.in);
    private static final OverallStorage overallStorage = new OverallStorage();
    private static User users;

    public static void main(String[] args) {
        firtsPage();
    }

    private static void firtsPage() {
        boolean run = true;
        while (run) {

            Commands.printSecondPageCommands();

            int commands;
            try {

                commands = Integer.parseInt(scanner.next());
                switch (commands) {
                    case EXIT -> run = false;
                    case LOGIN -> login();
                    case REGISTER -> register();
                    default -> System.out.println("Սխալ հրաման");
                }
            } catch (NumberFormatException e) {
                commands = -1;
            }
        }
    }

    private static void register() {
        try {
            System.out.println("Ներմուծեք տվյալները՝ name,surname,gender,age,phoneNumber,password");
            String userData = scanner.next();
            String[] userDataStr = userData.split(",");
            User userByPhoneNumber = overallStorage.getUserByPhoneNumber(userDataStr[4]);
            if (userByPhoneNumber != null) {
                System.out.println("Հեռախոսահամարի կրկնություն");
            } else {
                User user = new User();
                user.setName(userDataStr[0]);
                user.setSurname(userDataStr[1]);
                user.setGender(Gender.valueOf(userDataStr[2].toUpperCase()));
                user.setAge(Integer.parseInt(userDataStr[3]));
                user.setPhoneNumber(userDataStr[4]);
                user.setPassword(userDataStr[5]);
                overallStorage.addUsers(user);
                overallStorage.addMap(userDataStr[4], user);
                System.out.println("Օգտատերը գրանցված է");
            }
        } catch (Exception e) {
            System.out.println(" Սխալ ներմուծված տվյալներ՝ Խնդրում եմ փորձեք նորից");
            register();
        }
    }

    private static void login() {
        System.out.println(" Ներմուծեք հեռախոսահամար,գաղտնաբառ");
        String userData = scanner.next();
        String[] userDataStr = userData.split(",");
        try {
            users = overallStorage.getUserByPhoneNumberAndPassword(userDataStr[0], userDataStr[1]);
            loginUser();
        } catch (TypeNotFoundException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Տվյալի սխալ, ներմուծեք նորից");
            login();
        }
    }

    private static void loginUser() {
        boolean run = true;
        while (run) {
            Commands.printUserCommands();
            int userCommand;
            try {
                userCommand = Integer.parseInt(scanner.next());

                switch (userCommand) {
                    case LOGOUT -> {
                        run = false;
                        firtsPage();
                    }
                    case ADD_NEW_AD -> addNewAd();
                    case PRINT_MY_ALL_ADS -> overallStorage.printMyAllADS(users);
                    case PRINT_ALL_ADS -> overallStorage.printAllADS();
                    case PRINT_AD_BY_CATEGORY -> printAdByCategory();
                    case DELETE_MY_ALL_ADS -> overallStorage.deleteMyAllADS(users);
                    case DELETE_AD_BY_TITLE -> deleteAdByTitle();
                }
            } catch (NumberFormatException e) {
                userCommand = -1;
            }
        }
    }

    private static void deleteAdByTitle() {
        System.out.println("Ներմուծեք վերնագիր՝ հայտարարությունը ջնջելու համար");
        String title = scanner.next();
        overallStorage.deleteADByTitle(title, users);
    }


    private static void printAdByCategory() {
        System.out.println("Ներմուծեք կատեգորիան");
        try {
            String category = scanner.next();
            overallStorage.printADByCategory(Category.valueOf(category.toUpperCase()));
        } catch (TypeNotFoundException e) {
            System.out.println("Tրված կատեգորիաով հայտարարություն չկա");
        }
    }

    private static void addNewAd() {
        try {
            System.out.println("Ներմուծեք հայտարարություն՝ title,text,price,category");
            System.out.println(Arrays.toString(Category.values()));
            String adData = scanner.next();
            String[] adDataStr = adData.split(",");
            Advertisment advertisment = new Advertisment();
            advertisment.setTitle(adDataStr[0]);
            advertisment.setText(adDataStr[1]);
            advertisment.setPrice(Integer.parseInt(adDataStr[2]));
            advertisment.setDate(new Date());
            advertisment.setCategory(Category.valueOf(adDataStr[3].toUpperCase()));
            advertisment.setUser(users);
            overallStorage.addAds(advertisment);
            System.out.println("Հայտարարությունը ավելացված է");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Սխալ ներմուծված տվյալներ՝ Խնդրում եմ փորձեք նորից");
            addNewAd();
        }
    }
}
