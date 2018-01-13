package com.github.xuejike.springboot.jkfaststart.domain_ext;

import org.hibernate.annotations.ValueGenerationType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ValueGenerationType(generatedBy = UpdateDateTimeGeneration.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UpdateDateTime {
}
