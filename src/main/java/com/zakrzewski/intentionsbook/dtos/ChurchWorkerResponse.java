package com.zakrzewski.intentionsbook.dtos;

public class ChurchWorkerResponse {

    private String fullName;
    private String churchRole;

    public static class ChurchWorkerResponseBuilder {

        private String fullName;
        private String churchRole;

        public ChurchWorkerResponse.ChurchWorkerResponseBuilder fullName(String fullName){
            this.fullName = fullName;
            return this;
        }
        public ChurchWorkerResponse.ChurchWorkerResponseBuilder churchRole(String churchRole){
            this.churchRole = churchRole;
            return this;
        }

        public ChurchWorkerResponse build(){
            ChurchWorkerResponse churchWorkerResponse = new ChurchWorkerResponse();
            churchWorkerResponse.fullName = this.fullName;
            churchWorkerResponse.churchRole = this.churchRole;

            return churchWorkerResponse;
        }
    }

    @Override
    public String toString() {
        return "ChurchWorkerResponse{" +
                "fullName='" + fullName + '\'' +
                ", churchRole='" + churchRole + '\'' +
                '}';
    }
}
