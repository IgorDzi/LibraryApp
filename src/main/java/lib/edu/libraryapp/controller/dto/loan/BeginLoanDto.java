package lib.edu.libraryapp.controller.dto.loan;

import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;

public class BeginLoanDto {

    private BookEntity book;
    private UserEntity user;
    private String loanDate;
    private int days;

    public BeginLoanDto(BookEntity book, UserEntity user, String loanDate, int days) {
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
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

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
