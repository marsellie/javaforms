package com.kpfu.javaforms.entity;

import com.kpfu.javaforms.entity.base.LongEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Record extends LongEntity {

    @ManyToOne
    @NotNull
    private AppUser user;

    @NotBlank
    private String text;
}
