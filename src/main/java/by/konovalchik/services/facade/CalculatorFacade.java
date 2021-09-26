package by.konovalchik.services.facade;

import by.konovalchik.entity.Address;
import by.konovalchik.entity.Operation;
import by.konovalchik.entity.Telephone;
import by.konovalchik.entity.User;
import by.konovalchik.services.AuthorizationUserService;
import by.konovalchik.services.CalculationService;
import by.konovalchik.services.ChangePasswordService;
import by.konovalchik.services.LogOperationsService;
import by.konovalchik.services.ValueListHandler.OperationsListHandler;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class CalculatorFacade {
    private static final Logger logger = LogManager.getLogger();


//--------------------------------------------------------------------------------------------------------------------//

    public boolean registrationUser(User user, Address address, Telephone telephone) {
        if (!FacadeDependencies.getRegistrationUserService().containUserByEmail(user.getEmail())) {
            FacadeDependencies.getRegistrationUserService().registrationUser(user);
            Optional<User> userOptional = FacadeDependencies.getRegistrationUserService().getUserByEmail(user.getEmail());
            if (userOptional.isPresent()) {
                User userBase = userOptional.get();
                Address addressFull = new Address(address.getCity(), address.getStreet(), address.getHomeNumber(), address.getApartNumber(), userBase);
                Telephone telephoneFull = new Telephone(telephone.getNumber(), userBase);
                if ((!FacadeDependencies.getAddressesUserService().containAddress(addressFull)) && (!FacadeDependencies.getTelephoneUserService().containTelephones(telephoneFull)) ) {
                    FacadeDependencies.getAddressesUserService().addAddress(addressFull);
                    FacadeDependencies.getTelephoneUserService().addTelephone(telephoneFull);
                    logger.info("User {} registered ", user.getName());
                    return true;
                }else {
                    logger.info("Address or telephone already exists");
                    return false;
                }
            } else {
                logger.info("User or address already exists");
                return false;
            }
        }else {
            logger.info("User or address already exists");
            return false;
        }
    }


//--------------------------------------------------------------------------------------------------------------------//

    public Optional<User> authorizationUser (String email, String password) {
        AuthorizationUserService authorization = FacadeDependencies.getAuthorizationUserService();
        return authorization.authorizationUser(email, password);
    }


//--------------------------------------------------------------------------------------------------------------------//

     public Optional<Double> getCalculation (double num1, double num2, String operation, User user){
         Optional<Double> result = CalculationService.getResult(num1, num2, operation);
         if(result.isPresent()){
             LogOperationsService log = FacadeDependencies.getLogOperationsService();
             log.saveOperation(num1, num2, operation, result.get(), user);
             logger.info("Successful calculation operation: num1: {}, num2: {}, operation: {}, result: {}. User: {}.", num1, num2, operation, result.get(), user.getName());
             return result;
         } else
             logger.info("Failed! Math operation not found!");
             return Optional.empty();
     }


//--------------------------------------------------------------------------------------------------------------------//

    public List<Operation> showUserHistory(String email, int page, int valuePage) {
        List<Operation> list = FacadeDependencies.getLogOperationsService().showLogsByEmail(email);
        OperationsListHandler listHandler = new OperationsListHandler(list);
        return listHandler.getListElement(page, valuePage);
    }


//--------------------------------------------------------------------------------------------------------------------//

    public void changeUserName(String email, String name) {
        FacadeDependencies.getChangeNameService().changeName(email, name);
    }


//--------------------------------------------------------------------------------------------------------------------//

    public boolean changeUserPassword(String oldPassword, String newPassword, String confirmPassword, User user) {
        ChangePasswordService changePasswordService = FacadeDependencies.getChangePasswordService();
        if (changePasswordService.checkPassword(user.getPassword(), oldPassword)) {
            if (changePasswordService.checkPassword(newPassword, confirmPassword)) {
                changePasswordService.editUserPassword(user.getEmail(), newPassword);
                logger.info("User {} successful change password.", user.getName());
                return true;
            }else logger.warn("User {} fail attempt to change password. New password and confirmation password do not match!", user.getName());
            return false;
        }else
            logger.warn("User {} fail attempt to change password. Wrong password entered! ", user.getName());
            return false;
    }


//--------------------------------------------------------------------------------------------------------------------//

   public List<Address> showAddresses(String email){
       return FacadeDependencies.getAddressesUserService().findAllAddressesByEmail(email);
   }


    public boolean deleteAddress(int idAddr, int idUser){
        if(FacadeDependencies.getAddressesUserService().isExist(idUser)) {
            if (FacadeDependencies.getAddressesUserService().containAddressById(idAddr, idUser)) {
                FacadeDependencies.getAddressesUserService().deleteAddressById(idAddr);
                return true;
            } else return false;
        }return false;
    }


//--------------------------------------------------------------------------------------------------------------------//

    public boolean editAddress(Address address){
        if(FacadeDependencies.getChangeAddressService().containAddressesById(address.getId(), address.getUser().getId())){
            FacadeDependencies.getChangeAddressService().updateAddressById(address);
            return true;
        }
        return false;
    }

//--------------------------------------------------------------------------------------------------------------------//

    public boolean addAddress(Address address){
        if(!FacadeDependencies.getAddAddressService().containAddress(address)){
            FacadeDependencies.getAddAddressService().addAddress(address);
            return true;
        }else return false;
    }


//--------------------------------------------------------------------------------------------------------------------//

   public List<Telephone> showTelephones(String email){
       return FacadeDependencies.getTelephoneUserService().findTelephoneByEmail(email);
   }

   public boolean deleteTelephone(int idTel, int idUser){
        if(FacadeDependencies.getTelephoneUserService().containTelephoneById(idTel, idUser)){
            FacadeDependencies.getTelephoneUserService().deleteTelephoneById(idTel);
            return true;
        } else return false;
   }


//--------------------------------------------------------------------------------------------------------------------//

    public boolean editTelephone(int idTel, int idUser, long newNumber){
        if(FacadeDependencies.getChangeTelephoneService().containTelephoneById(idTel, idUser)){
            FacadeDependencies.getChangeTelephoneService().updateTelephoneById(idTel, newNumber);
            return true;
        }
        return false;
    }

//--------------------------------------------------------------------------------------------------------------------//

    public boolean addTelephone(Telephone telephone){
        if(!FacadeDependencies.getAddTelephoneService().containTelephone(telephone)){
            FacadeDependencies.getAddTelephoneService().addTelephone(telephone);
            return true;
        }
        return false;
    }

}