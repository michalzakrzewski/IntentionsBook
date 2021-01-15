package com.zakrzewski.intentionsbook.dtos;

public class ChurchWorkerRequest {

    private String login;
    private String password;
    private String fullName;
    private String churchRole;

    public static class ChurchWorkerRequestBuilder {
        private String login;
        private String password;
        private String fullName;
        private String churchRole;

        public ChurchWorkerRequest.ChurchWorkerRequestBuilder login(String login){
            this.login = login;
            return this;
        }

        public ChurchWorkerRequest.ChurchWorkerRequestBuilder password(String password){
            this.password = password;
            return this;
        }
        public ChurchWorkerRequest.ChurchWorkerRequestBuilder fullName(String fullName){
            this.fullName = fullName;
            return this;
        }
        public ChurchWorkerRequest.ChurchWorkerRequestBuilder churchRole(String churchRole){
            this.churchRole = churchRole;
            return this;
        }

        public ChurchWorkerRequest build(){
            ChurchWorkerRequest churchWorkerRequest = new ChurchWorkerRequest();
            churchWorkerRequest.login = this.login;
            churchWorkerRequest.password = this.password;
            churchWorkerRequest.fullName = this.fullName;
            churchWorkerRequest.churchRole = this.churchRole;

            return churchWorkerRequest;
        }
    }

    public String getLogin() {
        return login;
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
    public String getChurchRole() {
        return churchRole;
    }

    @Override
    public String toString() {
        return "ChurchWorkerRequest{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", churchRole='" + churchRole + '\'' +
                '}';
    }
}
