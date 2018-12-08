package gr.uoa.di.m149.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users_activity")
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String query;
    private Timestamp timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
