package lib.edu.libraryapp.controller.dto.loan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;

public class BeginLoanDto {
    @NotBlank(message = "Book is required")
    private BookEntity book;
    @NotBlank(message = "User is required")
    private UserEntity user;

    @NotNull(message = "Number of days is required")
    private int days;

    public BeginLoanDto(BookEntity book, UserEntity user, int days) {
        this.book = book;
        this.user = user;
        this.days = days;
    }

    public BeginLoanDto() {
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
