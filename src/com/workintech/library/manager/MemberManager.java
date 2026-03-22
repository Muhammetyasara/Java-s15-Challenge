package com.workintech.library.manager;

import com.workintech.library.model.MemberRecord;
import com.workintech.library.model.Reader;

import java.util.HashMap;
import java.util.Map;

public class MemberManager {

    private Map<Long, Reader> members = new HashMap<>();

    public void addMember(Reader member) {
        if (!members.containsKey(member.getMemberRecord().getId()))
            members.put(member.getMemberRecord().getId(), member);
    }

    public void removeMember(long id){
        members.remove(id);
    }

    public Reader findById(long id){
        if (!members.containsKey(id)){
            System.out.println("There is no member with id!");
            return null;
        }

        return members.get(id);
    }

    public void listAll(){
        if (members.isEmpty()){
            System.out.println("No members in the system.");
            return;
        }

        for (Reader member: members.values()){
            System.out.println(member.getMemberRecord().getMember());
        }
    }
}
