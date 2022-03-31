package se.lexicon.Manaf_Gvargis_Susanne.booklender.models.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class BookDTO {
    private int bookId;
    @NotBlank(message = "Title can not be empty.")
    @Size(min = 2, max = 100, message = "Need to have between 2 and 100 letters")
    private String title;

    private boolean available;
    private boolean reserved;
    @NotNull
    @Min(value = 3,message = "maxLoanDays should be grater than 3")
    @Max(value = 100, message = "maxLoanDays should be less than 100")
    private int maxLoanDays;

    @NotNull
    @Min(value = 1,message = "finePerDay should be between 1 and 50")
    @Max(value = 50, message = "finePerDay should be between 1 and 50")
    private BigDecimal finePerDay;

    @Size(max = 1500, message = "Need to be less than 1500")
    @NotBlank(message = "Description is mandatory.")
    private String description;

    public BookDTO(int bookId, String title, int maxLoanDays, BigDecimal finePerDay, String description) {
        this.bookId = bookId;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.finePerDay = finePerDay;
        this.description = description;
        this.available = true;
        this.reserved = false;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    public BigDecimal getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(BigDecimal finePerDay) {
        this.finePerDay = finePerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", available=" + available +
                ", reserved=" + reserved +
                ", maxLoanDays=" + maxLoanDays +
                ", finePerDay=" + finePerDay +
                ", description='" + description + '\'' +
                '}';
    }
}
