package homework.adPortal.impl;

import homework.adPortal.enums.Category;
import homework.adPortal.exception.TypeNotFoundException;
import homework.adPortal.model.User;

public interface OverallStorageImpl {

    void printMyAllADS(User user);

    void printAllADS();

    void printADByCategory(Category category) throws TypeNotFoundException;

    void deleteMyAllADS(User user);

    void deleteADByTitle(String title, User user);

    User getUserByPhoneNumber(String phoneNumber);

    User getUserByPhoneNumberAndPassword(String phoneNumber, String password) throws TypeNotPresentException, TypeNotFoundException;


}
