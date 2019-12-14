package com.epi.hashtables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ContactListHandler {

    public static List<ContactList> mergeContactLists(List<ContactList> contacts){
        return new ArrayList<>(new HashSet(contacts));
    }

    public static class ContactList{
        public List<String> names;

        ContactList(List<String> names){
            this.names = names;
        }

        @Override
        public boolean equals(Object obj){
            if(obj == null || !(obj instanceof ContactList)){
                return false;
            }
            return this == obj ? true: new HashSet(names).equals(new HashSet(((ContactList)obj).names));
        }

        @Override
        public int hashCode(){
            return new HashSet(names).hashCode();
        }
    }
}
