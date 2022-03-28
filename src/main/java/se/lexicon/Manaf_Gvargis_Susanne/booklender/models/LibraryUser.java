package se.lexicon.Manaf_Gvargis_Susanne.booklender.models;

import java.time.LocalDate;
import java.util.Objects;

public class LibraryUser {

    private int userId;
    private LocalDate regDate;
    private String name;
    private String email;

    public LibraryUser(LocalDate regDate, String name, String email) {
        this.regDate = regDate;
        this.name = name;
        this.email = email;
    }

    public LibraryUser() {
    }

    public int getUserId() {
        return userId;
    }


    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryUser that = (LibraryUser) o;
        return userId == that.userId && regDate.equals(that.regDate) && name.equals(that.name) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, regDate, name, email);
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "userId=" + userId +
                ", regDate=" + regDate +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
