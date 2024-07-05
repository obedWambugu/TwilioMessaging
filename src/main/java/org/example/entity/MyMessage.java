package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "messages")
public class MyMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Body;
    private String Kutoka;
    private String Mpaka;

    public String getBody() {
        return Body;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }

    public String getKutoka() {
        return Kutoka;
    }

    public void setKutoka(String Kutoka) {
        this.Kutoka = Kutoka;
    }

    public String getMpaka() {
        return Mpaka;
    }

    public void setMpaka(String Mpaka) {
        this.Mpaka = Mpaka;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
