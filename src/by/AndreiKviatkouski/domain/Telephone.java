package by.AndreiKviatkouski.domain;

import java.io.Serializable;
import java.util.Objects;

public class Telephone implements Serializable {
    private static long incId = 1;
    private long id = incId++;
    private String homeNumber;
    private String mobileNumber;



    public Telephone() {
    }

    public Telephone(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public Telephone(long id, String mobileNumber) {
        this.id = id;
        this.mobileNumber = mobileNumber;
    }

    public Telephone( String homeNumber, String mobileNumber) {
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "id=" + id +
                ", homeNumber='" + homeNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telephone telephone = (Telephone) o;
        return Objects.equals(homeNumber, telephone.homeNumber) &&
                Objects.equals(mobileNumber, telephone.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeNumber, mobileNumber);
    }
}
