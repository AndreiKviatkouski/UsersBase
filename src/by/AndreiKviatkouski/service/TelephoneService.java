package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.console.exception.TelephoneException;
import by.AndreiKviatkouski.domain.Telephone;

public interface TelephoneService {

    Telephone update(long id, Telephone telephone ) throws TelephoneException;

}
