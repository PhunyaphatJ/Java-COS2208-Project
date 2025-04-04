/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg.Member.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import models.Member;

/**
 *
 * @author black
 */
public interface IMemberService {
    ArrayList<Member> getAll();
    Member findById(int id);
    Boolean addMember(String name,String email,LocalDate start,LocalDate end);
    Boolean updateMember(int id,String name,String email);
}
