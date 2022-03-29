package se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto;

import java.time.LocalDate;

public class LibraryUserDTO {

    private int userId;
    private LocalDate regDate;
    private String name;
    private String email;

    public LibraryUserDTO(int userId, LocalDate regDate, String name, String email) {
        this.userId = userId;
        this.regDate = regDate;
        this.name = name;
        this.email = email;
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
}
