/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author black
 */
public class Member {

    int id;
    String name;
    String email;
    LocalDate memberStart;
    LocalDate memberEnd;
    
    public Member(int id,String name,String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Member(int id, String name, String email, LocalDate memberStart, LocalDate memberEnd) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.memberStart = memberStart;
        this.memberEnd = memberEnd;
    }

    public Member(String name, String email, LocalDate memberStart, LocalDate memberEnd) {
        this.name = name;
        this.email = email;
        this.memberStart = memberStart;
        this.memberEnd = memberEnd;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getMemberStart() {
        return memberStart;
    }

    public LocalDate getMemberEnd() {
        return memberEnd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMemberStart(LocalDate memberStart) {
        this.memberStart = memberStart;
    }

    public void setMemberEnd(LocalDate memberEnd) {
        this.memberEnd = memberEnd;
    }

}
