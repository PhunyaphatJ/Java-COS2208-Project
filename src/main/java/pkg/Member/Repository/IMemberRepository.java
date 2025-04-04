/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg.Member.Repository;

import java.util.ArrayList;
import models.Member;

/**
 *
 * @author black
 */
public interface IMemberRepository {
    ArrayList<Member> getAll();
    Member findById(int id);
    Boolean addMember(Member member);
    Boolean updateMember(Member member);
}
