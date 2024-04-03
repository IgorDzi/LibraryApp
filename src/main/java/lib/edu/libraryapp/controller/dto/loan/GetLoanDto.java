package lib.edu.libraryapp.controller.dto.loan;

import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;

public class GetLoanDto {

    private long id;

    private BookEntity book;

    private UserEntity user;

    private String loanDate;
    private int days;
    private String returnDate;

    public GetLoanDto(long id, BookEntity book, UserEntity user, String loanDate, int days, String returnDate) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
        this.days = days;
        this.returnDate = returnDate;
    }

    public GetLoanDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBook() {
        return book.getId();
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public long getUser() {
        return user.getId();
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

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

}
