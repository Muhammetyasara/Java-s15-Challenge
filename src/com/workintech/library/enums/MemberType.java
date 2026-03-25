    package com.workintech.library.enums;

    public enum MemberType {

        STUDENT("Student"),
        FACULTY("Faculty");

        private final String status;

        MemberType(String status) {
            this.status = status;
        }

        public String getStatus(){
            return status;
        }
    }
