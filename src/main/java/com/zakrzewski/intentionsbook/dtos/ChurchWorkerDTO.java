package com.zakrzewski.intentionsbook.dtos;

public class ChurchWorkerDTO {

    private String login;

    private String password;

    private String fullName;

    private String churchRole;

    public static class ChurchWorkerDTOBuilder{

        private String login;

        private String password;

        private String fullName;

        private String churchRole;

        public ChurchWorkerDTOBuilder login(String login){
            this.login = login;
            return this;
        }

        public ChurchWorkerDTOBuilder password(String password){
            this.password = password;
            return this;
        }
        public ChurchWorkerDTOBuilder fullName(String fullName){
            this.fullName = fullName;
            return this;
        }
        public ChurchWorkerDTOBuilder churchRole(String churchRole){
            this.churchRole = churchRole;
            return this;
        }

        public ChurchWorkerDTO build(){
            ChurchWorkerDTO churchWorkerDTO = new ChurchWorkerDTO();
            churchWorkerDTO.login = this.login;
            churchWorkerDTO.password = this.password;
            churchWorkerDTO.fullName = this.fullName;
            churchWorkerDTO.churchRole = this.churchRole;

            return churchWorkerDTO;
        }

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getChurchRole() {
        return churchRole;
    }

    public void setChurchRole(String churchRole) {
        this.churchRole = churchRole;
    }

    @Override
    public String toString() {
        return "ChurchWorkerDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", churchRole='" + churchRole + '\'' +
                '}';
    }
}
