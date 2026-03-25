    package com.workintech.library.model;

    import com.workintech.library.enums.MemberType;

    public class Reader extends Person {

        private final MemberRecord memberRecord;

        public Reader(String name,
                      long id,
                      MemberType memberType,
                      String address,
                      String phoneNo
        ) {

            super(name);
            this.memberRecord = new MemberRecord(
                    id,
                    memberType,
                    address,
                    phoneNo);
        }

        public MemberRecord getMemberRecord() {
            return memberRecord;
        }

        @Override
        public String whoYouAre() {
            return "I'm a reader. My name is " + getName();
        }
    }
