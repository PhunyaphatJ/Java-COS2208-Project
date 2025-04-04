/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Member.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import models.Member;

/**
 *
 * @author black
 */
public class MemberRepositoryImpl implements IMemberRepository {

    Connection db;

    public MemberRepositoryImpl(Connection db) {
        this.db = db;
    }

    @Override
    public ArrayList<Member> getAll() {
        String sql = "SELECT * FROM members ORDER BY id";
        ArrayList<Member> members = new ArrayList<>();
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                members.add(new Member(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDate("member_start").toLocalDate(),
                        rs.getDate("member_end").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public Member findById(int id) {
        String sql = "SELECT * FROM members WHERE id = ?";
        try (
            PreparedStatement stmt = db.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Member member = new Member(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDate("member_start").toLocalDate(),
                        rs.getDate("member_end").toLocalDate()
                );
                return member;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean addMember(Member member) {
        String sql = "INSERT INTO members (name,email,member_start,member_end) VALUES(?,?,?,?)";
        try{
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getEmail());
            stmt.setDate(3, Date.valueOf(member.getMemberStart()));
            stmt.setDate(4, Date.valueOf(member.getMemberEnd()));
            
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean updateMember(Member member) {
        String sql = "UPDATE members SET name = ? ,email = ? WHERE id = ?";
        try{
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getEmail());
            stmt.setInt(3, member.getId());
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
