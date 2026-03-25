package com.workintech.library.manager;

import com.workintech.library.model.Reader;

import java.util.HashMap;
import java.util.Map;

public class MemberManager implements IManageable<Reader> {

    private Map<Long, Reader> members = new HashMap<>();

    @Override
    public void add(Reader member) {
        if (!members.containsKey(member.getMemberRecord().getId())) {
            members.put(member.getMemberRecord().getId(), member);
            System.out.println("Member added successfully");
        } else {
            System.out.println("Member already exist with that id.");
        }
    }

    @Override
    public void remove(long id) {
        members.remove(id);
    }

    @Override
    public Reader findById(long id) {
        if (!members.containsKey(id)) {
            //System.out.println("There is no member with id!");
            return null;
        }

        return members.get(id);
    }

    @Override
    public void listAll() {
        if (members.isEmpty()) {
            System.out.println("No members in the system.");
            return;
        }

        for (Reader member : members.values()) {
            System.out.println(member.getMemberRecord().getMember());
        }
    }
}
