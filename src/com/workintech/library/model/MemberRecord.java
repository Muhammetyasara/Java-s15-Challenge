package com.workintech.library.model;

import com.workintech.library.enums.MemberType;

import java.time.LocalDate;
import java.util.Objects;

public class MemberRecord {

    private long id;
    private MemberType memberType;
    private final LocalDate dateOfMembership;
    private int noBooksIssued;
    private final static int maxBookLimit = 5;
    private String address;
    private String phoneNo;
    private int cash;


    public MemberRecord(long id,
                        MemberType memberType,
                        String address,
                        String phoneNo
    ) {
        this.id = id;
        this.setMemberType(memberType);
        this.dateOfMembership = LocalDate.now();
        this.noBooksIssued = 0;
        this.setAddress(address);
        this.setPhoneNo(phoneNo);
        this.cash = 5;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMember() {
        return toString();
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void incBooksIssued() {
        if (getNoBooksIssued() < maxBookLimit) {
            setNoBooksIssued(getNoBooksIssued() + 1);
        }
    }

    public void decBooksIssued() {
        if (getNoBooksIssued() > 0)
            setNoBooksIssued(getNoBooksIssued() - 1);
    }

    public void payBill() {
        if (cash > 0)
            setCash(getCash() - 1);
    }

    public void refundBill() {
        setCash(getCash() + 1);
    }

    public boolean isMemberBorrow() {
        return !(getNoBooksIssued() < maxBookLimit);
    }

    @Override
    public String toString() {
        return "MemberRecord{" +
                "id=" + id +
                ", memberType=" + memberType +
                ", dateOfMembership=" + dateOfMembership +
                ", noBooksIssued=" + noBooksIssued +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemberRecord that = (MemberRecord) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
