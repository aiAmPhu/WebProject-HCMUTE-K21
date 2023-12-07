package murach.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Review\"")
public class Review implements Serializable {
    private int reviewId;
    private String name;
    private String phone;
    public Review() {
    }
    public Review(String userr, String phone, String subject, String feedback) {
        this.name = userr;
        this.phone= phone;
        this.subject = subject;
        this.feedback=feedback;
    }
    private String subject;
    private String feedback;
    
    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String username) {
        this.phone = username;
    }
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String rating) {
        this.subject = rating;
    }
    
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getReviewId() {
        return reviewId;
    }
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    
}