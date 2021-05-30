package homework.adPortal.storage;

import homework.adPortal.enums.Category;
import homework.adPortal.exception.TypeNotFoundException;
import homework.adPortal.impl.OverallStorageImpl;
import homework.adPortal.model.Advertisment;
import homework.adPortal.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OverallStorage implements OverallStorageImpl {

    List<Advertisment> ads;
    List<User> users;
    Map<String, User> userMap;

    public OverallStorage() {
        ads = new ArrayList<>();
        users = new ArrayList<>();
        userMap = new HashMap<>();
    }

    public void addAds(Advertisment advertisment) {
        ads.add(advertisment);
    }

    public void addUsers(User user) {
        users.add(user);
    }

    public void addMap(String phoneNumber, User user) {
        userMap.put(phoneNumber, user);
    }

    public void printMyAllADS(User user) {
        for (Advertisment ad : ads) {
            if (ad.getUser().equals(user)) {
                System.out.println(ad);
            }
        }
    }

    public void printAllADS() {
        for (Advertisment ad : ads) {
            System.out.println(ad);
        }
    }

    @Override
    public void printADByCategory(Category category) throws TypeNotFoundException {
        for (Advertisment ad : ads) {
            if (ad.getCategory().equals(category)) {
                System.out.println(ad);
            }
        }
    }


    public void deleteMyAllADS(User user) {
        ads.removeIf(ad -> ad.getUser().equals(user));
        System.out.println("Հայտարարությունը ջնջված է");
    }

    public void deleteADByTitle(String title,User user) {
        if (ads.removeIf(ad -> ad.getTitle().equals(title) && ad.getUser().equals(user))){
            System.out.println("տրված վերնագրով հայտարարությունը ջնջված է");
        }
        else System.out.println("տրված վերնագրով հայտարարություն չկա");
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByPhoneNumberAndPassword(String phoneNumber, String password) throws TypeNotFoundException {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new TypeNotFoundException("Սխալ հեռախոսահամար կամ գաղտնաբառ");
    }




}
