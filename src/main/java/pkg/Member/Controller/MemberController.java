/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Member.Controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Member;
import pkg.Member.Repository.IMemberRepository;
import pkg.Member.Repository.MemberRepositoryImpl;
import pkg.Member.Service.IMemberService;
import pkg.Member.Service.MemberServiceImpl;

/**
 *
 * @author black
 */
public class MemberController {

    IMemberService memberService;

    public MemberController(IMemberService memberSerivce) {
        this.memberService = memberSerivce;
    }

    public ArrayList<Member> getAll() {
        return memberService.getAll();
    }

    public Member findById(int id) {
        Member member = memberService.findById(id);
        if (member == null) {
            JOptionPane.showMessageDialog(null, "Can't find Member " + id, "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return member;
    }

    public void addMember(String name, String email, LocalDate start, LocalDate end) {
        if (memberService.addMember(name, email, start, end)) {
            JOptionPane.showMessageDialog(null, "Add Member Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Add Member!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMember(int id, String name, String email) {
        if (memberService.updateMember(id, name, email)) {
            JOptionPane.showMessageDialog(null, "Update Member Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Update Member!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static MemberController getMemberController(Connection db) {
        IMemberRepository memberRepo = new MemberRepositoryImpl(db);
        IMemberService memberService = new MemberServiceImpl(memberRepo);

        return new MemberController(memberService);
    }
}
