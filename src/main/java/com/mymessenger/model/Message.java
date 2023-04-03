package com.mymessenger.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Aurimas
 * @created 2023-04-03
 */

@Entity
@Table(name = "messages")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message extends BaseEntity {
    private String text;

    @CreatedDate
    private Date senDate = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User user;
}
