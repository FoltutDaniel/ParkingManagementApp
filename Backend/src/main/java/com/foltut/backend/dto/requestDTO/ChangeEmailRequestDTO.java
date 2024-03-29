package com.foltut.backend.dto.requestDTO;

public class ChangeEmailRequestDTO {
    private String oldEmail;
    private String newEmail;
    private String password;

    public ChangeEmailRequestDTO() {
    }

    public ChangeEmailRequestDTO(String oldEmail, String newEmail, String password) {
        this.oldEmail = oldEmail;
        this.newEmail = newEmail;
        this.password = password;
    }

    public String getOldEmail() {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
