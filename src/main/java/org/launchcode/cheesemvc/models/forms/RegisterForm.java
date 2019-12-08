package org.launchcode.cheesemvc.models.forms;

import javax.validation.constraints.NotNull;

public class RegisterForm extends LoginForm {
    @NotNull(message="Passwords do not match")
    private String verifyPassword;

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
        checkPasswordForRegistration();
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    private void checkPasswordForRegistration() {
        if (!getPassword().equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}
