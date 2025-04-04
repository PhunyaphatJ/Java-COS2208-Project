/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Member.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Member;
import pkg.Member.Repository.IMemberRepository;

/**
 *
 * @author black
 */
public class MemberServiceImpl implements IMemberService {

    IMemberRepository memberRepo;

    public MemberServiceImpl(IMemberRepository memberRepo) {
        this.memberRepo = memberRepo;
    }

    @Override
    public ArrayList<Member> getAll() {
        return memberRepo.getAll();
    }

    @Override
    public Member findById(int id) {
//        if (member == null) {
//            JOptionPane.showMessageDialog(null, "Can't find Member "+id, "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
       return memberRepo.findById(id);
    }

    @Override
    public Boolean addMember(String name, String email, LocalDate start, LocalDate end) {
        Member member = new Member(name,email,start,end);
        return memberRepo.addMember(member);
    }

    @Override
    public Boolean updateMember(int id, String name, String email) {
        Member member = new Member(id,name,email);
        return memberRepo.updateMember(member);
    }

}
