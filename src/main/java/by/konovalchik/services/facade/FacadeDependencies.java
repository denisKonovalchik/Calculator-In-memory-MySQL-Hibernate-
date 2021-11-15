package by.konovalchik.services.facade;

import by.konovalchik.dao.*;
import by.konovalchik.services.*;
import lombok.Getter;



public class FacadeDependencies {
    @Getter
    private static final RegistrationUserService registrationUserService = new RegistrationUserService(new UsersHibernateDAOImp());
    @Getter
    private static final AuthorizationUserService authorizationUserService = new AuthorizationUserService(new UsersHibernateDAOImp());
    @Getter
    private static final LogOperationsService logOperationsService = new LogOperationsService(new LogOperationsHibernateDAOImp());
    @Getter
    private static final ChangeNameService changeNameService = new ChangeNameService(new UsersHibernateDAOImp());
    @Getter
    private static final ChangePasswordService changePasswordService = new ChangePasswordService(new UsersHibernateDAOImp());
    @Getter
    private static final AddressesUserService addressesUserService = new AddressesUserService(new UsersAddressesHibernateDAOImp());
    @Getter
    private static final ChangeAddressService changeAddressService = new ChangeAddressService(new UsersAddressesHibernateDAOImp());
    @Getter
    private static final AddAddressService addAddressService = new AddAddressService(new UsersAddressesHibernateDAOImp());
    @Getter
    private static final TelephonesUserService telephoneUserService = new TelephonesUserService(new UsersTelephonesHibernateDAOImp());
    @Getter
    private static final ChangeTelephoneService changeTelephoneService = new ChangeTelephoneService(new UsersTelephonesHibernateDAOImp());
    @Getter
    private static final AddTelephoneService addTelephoneService = new AddTelephoneService(new UsersTelephonesHibernateDAOImp());

}

