package com.example.mateproject.proc_test.repository;

import com.example.mateproject.proc_test.dto.StudentPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostsRepository {

    @Autowired
    DataSource dataSource;

    public void doInsert(String post_content,String post_writer){
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(
                            "insert into student_posts (post_content,post_writer) values (?,?)"
                    );
            pstmt.setString(1, post_content);
            pstmt.setString(2, post_writer);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(conn != null) try{ conn.close(); }catch (Exception e){}
        }
    }

    public List<StudentPost> doSelect(){
        List<StudentPost> list = new ArrayList<>();
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from student_posts");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                StudentPost post = StudentPost.builder()
                            .post_idx(rs.getInt("post_idx"))
                            .post_content(rs.getString("post_content"))
                            .post_writer(rs.getString("post_writer"))
                            .build();
//                Post post =
//                        new Post(rs.getInt("idx"),
//                                rs.getString("content"));
                list.add(post);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(conn != null) try{ conn.close(); } catch (Exception e){}
        }
        return list;
    }


}
