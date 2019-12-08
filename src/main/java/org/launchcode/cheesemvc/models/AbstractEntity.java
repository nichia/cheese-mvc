package org.launchcode.cheesemvc.models;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue
    private int uid;

    public int getUid() {
        return this.uid;
    }
}
