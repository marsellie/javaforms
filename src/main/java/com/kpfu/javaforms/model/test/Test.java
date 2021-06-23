package com.kpfu.javaforms.model.test;

import com.kpfu.javaforms.model.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Test extends GenericEntity<UUID> {

    @OneToOne
    public Test self;
}
